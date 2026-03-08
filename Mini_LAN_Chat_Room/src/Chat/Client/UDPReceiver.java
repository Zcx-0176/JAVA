package Chat.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP接收端
 * 创建UDP套接字，并绑定端口，等待接收数据
 * 独立线程，持续监听服务器UDP广播
 *
 */
public class UDPReceiver extends Thread{
    private DatagramSocket udpsocket;
    private boolean running = true;

    public UDPReceiver(int udpPort) throws SocketException {
        this.udpsocket = new DatagramSocket(udpPort);
        System.out.println("UDP接收端已启动，等待服务器广播...");
    }
    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        while(running){
            try{
                //接收UDP数据包
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
                udpsocket.receive(packet);
                //获取数据包中的数据
                String message = new String(packet.getData(),0,packet.getLength());
                System.out.println("[UDP]"+message);
            } catch (IOException e) {
                if(running){
                    throw new RuntimeException(e);
                }
            }
        }
        udpsocket.close();
    }
}
