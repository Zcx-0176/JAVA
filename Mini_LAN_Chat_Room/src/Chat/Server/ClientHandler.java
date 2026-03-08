package Chat.Server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器端-客户端处理器类
 * 主要就是声明为一个客户端处理线程
 * 来一个客户端，创建一个ClientHandler线程对象处理
 * 具体如何处理，声明了一堆方法
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientHandler extends Thread{
    private Socket clientSocket;    //TCP客户端连接套接字
    private BufferedReader in;    //输入流
    private PrintWriter out;      //输出流
    private String username;     //客户端用户名
    private InetAddress clientAddress;  //客户端IP地址
    private int udpPort;   //客户端UDP端口号
    private DatagramSocket udpSocket;   //UDP套接字
    private ConcurrentHashMap<String,ClientInfo> onlineClients;  //在线客户端列表

    public ClientHandler(Socket clientSocket, DatagramSocket udpSocket, ConcurrentHashMap<String,ClientInfo> onlineClients){
        this.clientSocket = clientSocket;
        this.udpSocket = udpSocket;
        this.onlineClients = onlineClients;
    }
    @Override
    public void run(){
        try{
            //创建输入输出流
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            //true是为了刷新缓冲区，把数据写入输出流中，确保消息立即发送

            //获取用户连接信息
            //这个连接信息是从客户端发来的，客户端输出，服务端接收
            String connectInfo = in.readLine();
            if(connectInfo == null || !connectInfo.contains(":")){
                out.println("连接信息错误");
                return;
            }
            //根据获取的用户连接信息connectInfo进一步解析用户名和UDP端口
            //根据":"来分开
            //这个格式为用户名:UDP端口
            //在ChatClient类中，第42行，已经被规定设置为这个格式了
            //第43行，客户端输出，服务端接收到，然后就是下面的代码，开始分割传入的信息
            String[] parts = connectInfo.split(":");
            this.username = parts[0];  //用户名
            this.udpPort = Integer.parseInt(parts[1]);   //UDP端口
            this.clientAddress = clientSocket.getInetAddress();  //客户端IP地址

            //创建客户端信息对象
            //把从客户端传过来的消息分割后，传给客户端信息对象
            ClientInfo clientInfo = new ClientInfo(username,clientAddress,udpPort,out);

            //添加用户到在线列表
            //也是上同步锁了
            synchronized (onlineClients){
                onlineClients.put(username,clientInfo);
            }

            //添加到在线列表后，调用广播函数广播用户加入消息
            broadcastMessage("JOIN:"+username+" 加入聊天室");

            //接着输出流发送欢迎信息，这是对应客户端的输出流，只在对应客户端打印显示，不是广播给所有用户
            out.println("SERVER:欢迎"+username+" 加入聊天室!当前在线用户："+onlineClients.size()+"人");

            //持续处理客户端消息
            String clientMessage;
            while((clientMessage=in.readLine())!=null){
                //equalsIgnoreCase不区分大小写比较
                if("/exit".equalsIgnoreCase(clientMessage)){
                    break;
                }else if("/list".equalsIgnoreCase(clientMessage)){
                    //发送在线用户列表
                    sendUserList();
                }else if(clientMessage.startsWith("@")){//检查消息是否以@开头
                    //私聊
                    sendprivateMessage(clientMessage);
                }else{
                    //普通聊天信息
                    //发给所有在线客户端‘
                    //这个是公共聊天消息，所有人都能看见
                    broadcastMessage("MESSAGE:"+username+": "+clientMessage);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{// 无论什么情况下都会被执行
            cleanup();
        }
    }
    /**
     * 格式化消息
     * 是把枚举类的消息格式换成正常的聊天信息
     * 比如把一段内容中的JOIN+内容换成[系统]+内容
     */
    private String formatMessage(String rawMessage){
        if(rawMessage == null || rawMessage.isEmpty()){
            return rawMessage;
        }
        int colonIndex = rawMessage.indexOf(':');
        if(colonIndex == -1){
            return rawMessage;
        }
        String type = rawMessage.substring(0, colonIndex);
        String content = rawMessage.substring(colonIndex + 1);
        switch(type){
            case "JOIN":
                return "[系统]"+content;
            case "EXIT":
                return "[系统]"+content;
            case "MESSAGE":
                return content;
            default:
                return rawMessage;
        }
    }
    /**
     * 清理资源
     * 当用户断开连接时清理资源
     * 从在线列表中删除该用户
     * 通知其他人该用户已退出
     * 关闭网络连接和输入输出流
     */
    private void cleanup(){
        try{
            //synchronized是同步锁，同步代码块
            //把括号内的内容加锁，只有获取锁的线程才能执行
            //username是每个线程都有的自己的用户名，因为每来一个客户端都会创建一个线程
            //所以使用username来移除该用户
            synchronized (onlineClients){
                if(username!=null){
                    onlineClients.remove(username);  //把断开联系的用户移除在线列表中
                    broadcastMessage("EXIT:"+username+" 退出聊天室"); //广播给所有在线用户
                }
            }
            if(in!=null){  //关闭输入流
                in.close();
            }
            if(out!=null){   //关闭输出流
                out.close();
            }
            if(clientSocket!=null&&!clientSocket.isClosed()){  //关闭套接字
                clientSocket.close();
            }
            //只是在服务端打印用户断开连接的信息
            System.out.println("用户"+username+"已断开连接，剩余用户："+onlineClients.size());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 发送在线用户消息
     * 即打印在线用户信息
     */
    private void sendUserList(){
        //构建统计信息，创建一个新的字符串：“当前在线用户：N人”
        StringBuilder userList = new StringBuilder("当前在线用户："+onlineClients.size()+"人");
        //遍历在线用户列表，将用户名添加到userList中，格式为“ - 用户名”
        onlineClients.keySet().forEach(user->userList.append(" - ").append(user).append("\n"));
        //发送用户列表给用户
        out.println("SERVER:"+userList.toString());
    }
    /**
     * 广播消息给所有在线客户端，除了给自己发送
     */
    private void broadcastMessage(String message){
        //先格式化消息，把原始消息转换成可读格式
        String formattedMsg = formatMessage(message);
        //转换为字节数组，为UDP传输做准备
        byte[] buffer = formattedMsg.getBytes();
        //遍历所有在线用户，用forEach遍历访问每个客户端
        onlineClients.forEach((name,info)->{
            if(!name.equals(username)){
                try{
                    DatagramPacket packet = new DatagramPacket(  //创建 UDP 数据包：封装消息字节、目标地址和端口
                            buffer,  // 数据
                            buffer.length,  // 长度
                            info.getAddress(),  // 目标地址
                            info.getUdpPort());   // 目标端口
                    udpSocket.send(packet);  //发送UDP包
                } catch(Exception e){
                    System.err.println("发送UDP包失败");
                }
                }
        });
    }
    /**
     * 发送私聊消息给指定用户
     * 私聊格式为 @用户名 消息内容
     */
    private void sendprivateMessage(String message){
        try{
            int spaceIndex = message.indexOf(" ");  // 找到空格索引
            if(spaceIndex==-1){
                out.println("ERROR:私聊格式错误，使用 @用户名 消息内容");
                return;
            }
            String targetUser = message.substring(1,spaceIndex);  // 获取目标用户名(截取@后的索引到空格前)
            String content = message.substring(spaceIndex+1);  // 获取私聊内容(截取空格后到末尾)
            ClientInfo targetInfo = onlineClients.get(targetUser);  // 获取目标用户信息
            if(targetInfo==null){
                out.println("ERROR:用户"+targetUser+"不存在");
                return;
            }
            // targetInfo.getOut() 获取目标用户的输出流，向其发送私聊消息（包含发送者用户名）
            targetInfo.getOut().println("PRIVATE:"+username+" 悄悄对你说："+content);  // 给目标用户发送私聊消息
            //通过当前用户的输出流 out，给发送者回显确认消息（告知消息已发送给目标用户）
            out.println("PRIVATE:"+"你悄悄对"+targetUser+"说："+content);  // 给发送者发送私聊消息
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
