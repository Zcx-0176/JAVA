package com.cxz.UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
public class UDPService {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        DatagramSocket ds = new DatagramSocket(8080);
        byte[] bytes = new byte[1024*64];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        while(true) {
            ds.receive(dp);
            int length = dp.getLength();
            String data = new String(bytes, 0, length);
            System.out.println(data);
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            System.out.println("对方IP为：" + ip + "    对方端口为" + port);
        }
    }
}
