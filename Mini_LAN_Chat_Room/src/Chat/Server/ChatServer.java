package Chat.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器端
 * 服务器主类
 * 启动服务器，监听TCP端口，实现多个客户端与服务器通信
 * 也使用了UDP广播实现对所有客户端发送系统消息
 * 流程：
 *     1.运行服务器，创建TCP  UDP套接字
 *     2.启动控制台输入线程，管理员可以发送系统公告给所有在线客户端
 *     3.进入无限循环，等待客户端连接
 *     4.每接收一个客户端连接，创建一个ClientHandler线程对象处理
 *     5.ClientHandler线程对象独立处理该客户端的所有通信
 */
public class ChatServer {
    private static final int TCP_PORT = 8888;  //TCP监听端口
    private static final int UDP_PORT = 9999;   //UDP广播端口

    //ConcurrentHashMap是线程安全的HashMap,保存在线用户列表
    // key 是用户名，value 是客户端信息
    //udpsocket 作为类成员，让所有方法都能访问同一个 UDP 套接字
    private static ConcurrentHashMap<String,ClientInfo> onlineClients = new ConcurrentHashMap<>();
    private static DatagramSocket udpsocket = null;
    public static void main(String[] args) {
        ServerSocket tcpsocket = null;

        try{
            //赋值tcp套接字用于TCP通信
            //并打印服务器信息
            tcpsocket = new ServerSocket(TCP_PORT);
            System.out.println("===迷你聊天室服务器===");
            System.out.println("服务器启动在："+ InetAddress.getLocalHost().getHostAddress());
            System.out.println("TCP监听端口："+TCP_PORT);
            System.out.println("UDP广播端口："+UDP_PORT);
            System.out.println("服务器已启动，等待客户端连接...");
            //赋值udp套接字用于广播
            udpsocket = new DatagramSocket(UDP_PORT);
            System.out.println("UDP广播端口已启动，等待广播...");

            //启动控制台输入线程
            startConsoleInputThread();


            //主循环，勇于接受客户端连接
            while(true){
                Socket clientSocket = tcpsocket.accept();  //接受客户端连接
                InetAddress clientAddress = clientSocket.getInetAddress();  //获取客户端IP地址
                int clientPort = clientSocket.getPort();  //获取客户端端口
                System.out.println("客户端已连接："+clientAddress+":"+clientPort);
                System.out.println("当前在线用户："+onlineClients.size());

                //为每个客户端创建处理线程
                ClientHandler clientHandler = new ClientHandler(clientSocket,udpsocket,onlineClients);
                clientHandler.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(tcpsocket!=null){
                    tcpsocket.close();
                }
                if(udpsocket!=null){
                    udpsocket.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    /**
     * 启动控制台输入线程
     * 允许服务器管理员发送系统公告
     * 输入 /list 查看在线用户
     * 输入 /exit 关闭服务器
     * 其他输入都会作为系统公告广播给所有客户端
     */
    private static void startConsoleInputThread(){
        new Thread(()->{    // 这是 Lambda 表达式写法，创建新线程
            //System.in代表键盘输入
            try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
                System.out.println("\n服务器控制台已启动，请输入消息广播给所有用户");
                System.out.print("输入'/list'查看在线用户");
                System.out.print("输入'/exit'退出服务器\n");
                while(true){
                    String input = consoleReader.readLine(); //获取用户的每一行输入
                    //根据输入内容，输出预期结果
                    if(input== null){
                        break;
                    }
                    if("/list".equalsIgnoreCase(input)){
                        System.out.println("当前在线用户："+onlineClients.size());
                    }else if("/exit".equalsIgnoreCase(input)){
                        System.out.println("服务器已关闭");
                        System.exit(0); //退出程序
                    }else{
                        broadcastSystemMessage("[系统公告]"+input);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();  //启动线程
    }
    /**
     * 广播系统消息给所有在线用户
     * 管理员在服务器端输入信息
     * 会通知给所有客户端，即群发消息给所有在线用户
     * 声明为静态方法，主函数可以直接调用
     */
    private static void broadcastSystemMessage(String message){
        if(message == null || udpsocket == null || udpsocket.isClosed()){
            return;
        }

        byte[] buffer = message.getBytes();  //创建字节数组
        for(ClientInfo clientInfo : onlineClients.values()){  //遍历所有在线用户
            try{
                if(clientInfo == null || clientInfo.getAddress() == null){  //用户信息为空
                    continue;  //跳过该用户
                }

                DatagramPacket packet = new DatagramPacket(  //创建 UDP 数据包：封装消息字节、目标地址和端口
                        buffer,
                        buffer.length,
                        clientInfo.getAddress(),
                        clientInfo.getUdpPort()
                );

                udpsocket.send(packet);  //发送 UDP 数据包，所有客户端接收后会打印消息
            } catch(IOException e){
                System.err.println("向用户 "+clientInfo.getName()+" 发送系统消息失败：" + e.getMessage());
            }
        }
        System.out.println(message);  //输出系统消息，这个是在服务器端输出的
    }
}
