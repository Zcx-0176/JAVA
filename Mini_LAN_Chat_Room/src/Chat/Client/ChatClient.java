package Chat.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 聊天室客户端
 * 启动客户端，连接服务器
 * 要想启动多个客户端，需要点击绿色run旁边的下三角，点击Edit Configurations...
 * 然后点击modify options,点击allow multiple instances
 */
public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int TCP_PORT = 8888;  //服务器TCP端口
    private static final int UDP_PORT = 9999;  //服务器UDP端口

    private Socket tcpSocket;
    private PrintWriter tcpOut;
    private BufferedReader tcpIn;
    private UDPReceiver udpReceiver;
    private String username;
    private int clientUdpPort;     //客户端UDP端口

    public ChatClient(String username){
        this.username = username;
        this.clientUdpPort = 10000 + (int)(Math.random() * 55535);
    }
    /**
     * 启动客户端
     */
    public void start(){
        try{
            System.out.println("正在连接服务器"+SERVER_IP+":"+TCP_PORT);
            tcpSocket = new Socket(SERVER_IP,TCP_PORT);
            tcpOut = new PrintWriter(tcpSocket.getOutputStream(),true);
            tcpIn = new BufferedReader(new java.io.InputStreamReader(tcpSocket.getInputStream()));

            //规定了服务端与客户端连接时，客户端输出的数据格式为username:clientUdpPort
            //所以服务端会有一个解析的操作，解析这个消息包含的信息
            String connectInfo = username+":"+clientUdpPort;
            tcpOut.println(connectInfo);

            udpReceiver = new UDPReceiver(clientUdpPort);
            udpReceiver.start();   //启动UDP接收线程

            //客户端连接成功后，第一条就是欢迎信息的收取
            //因为服务器端的客户端处理线程有broadcastMessage("JOIN:"+username+" 加入聊天室");
            //是在添加客户端到在线列表后的代码，会向所有客户端发送欢迎信息
            //所以会与下面的代码，接收欢迎信息，然后打印
            String welcomeMsg = tcpIn.readLine();
            if(welcomeMsg!= null){
                System.out.println(welcomeMsg);
            }

            //启动消息读取线程
            //在服务器端的客户端处理线程紧跟了另一行代码
            //内容为对应客户端的输出流打印"SERVER:欢迎"+username+" 加入聊天室!当前在线用户："+onlineClients.size()+"人"
            //下面的函数是线程，循环阻塞接收服务器端的消息
            //根据不同的消息，会打印不同的颜色
            //跟主程序的线程互不干扰
            startMessageReader();

            Scanner scanner = new Scanner(System.in);  // 创建一个Scanner对象，用于从控制台读取输入
            //这是客户端用户输入的消息
            System.out.println("请输入要发送的消息：");
            System.out.println("输入 '/list' 查看在线用户");
            System.out.println("输入 '@用户名 消息' 私聊");
            System.out.println("输入 '/exit' 退出\n");

            while(true){  //循环，等待用户输入
                String input = scanner.nextLine().trim();
                if(input.isEmpty()){
                    continue;
                }
                if("/exit".equalsIgnoreCase(input)){
                    tcpOut.println("/exit");  //发送退出消息给服务器，服务器端接收后，就会断开连接
                    break;
                }else if("/list".equalsIgnoreCase(input)){
                    tcpOut.println("/list");   //发送查看在线用户消息给服务器
                }else if(input.startsWith("@")){
                    tcpOut.println(input);
                }else{
                    tcpOut.println(input);
                }
            }
            cleanup();
            scanner.close();
            System.out.println("已退出聊天室");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void startMessageReader(){
        new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = tcpIn.readLine()) != null) {
                    if (serverMessage.startsWith("PRIVATE:")) {
                        System.out.println("\u001B[32m" + serverMessage.substring(8) + "\u001B[0m");
                    } else if (serverMessage.startsWith("SYSTEM:")) {
                        System.out.println("\u001B[33m" + serverMessage.substring(7) + "\u001B[0m");
                    } else if (serverMessage.startsWith("ERROR:")) {
                        System.out.println("\u001B[31m" + serverMessage.substring(6) + "\u001B[0m");
                    } else if (serverMessage.startsWith("SERVER:")) {
                        String content = serverMessage.substring(7);
                        if(content.contains("当前在线用户：") && content.contains("人")){
                            System.out.println("\u001B[36m" + content + "\u001B[0m");
                        }else{
                            System.out.println(content);
                        }
                    } else {
                        System.out.println(serverMessage);
                    }
                }
            } catch (IOException e) {
                if (!tcpSocket.isClosed()) {
                    System.err.println("与服务器的连接已断开");
                }
            }
        }).start();

    }
    private void cleanup(){
        try {
            if (udpReceiver != null) {
                udpReceiver.interrupt();
            }
            if (tcpOut != null) tcpOut.close();
            if (tcpIn != null) tcpIn.close();
            if (tcpSocket != null && !tcpSocket.isClosed()) {
                tcpSocket.close();
            }
        } catch (IOException e) {
            System.err.println("清理资源时出错: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            new ChatClient(args[0]).start();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== 迷你局域网聊天室客户端 ===");
            System.out.print("请输入用户名: ");
            String username = scanner.nextLine().trim();

            if (username.isEmpty()) {
                username = "用户" + (int)(Math.random() * 1000);
                System.out.println("使用默认用户名: " + username);
            }

            new ChatClient(username).start();
        }
    }
}
