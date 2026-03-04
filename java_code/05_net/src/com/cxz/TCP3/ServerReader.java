package com.cxz.TCP3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String data = dis.readUTF();
                System.out.println("收到客户端数据：" + data);
                System.out.println("客户端的IP：" + socket.getInetAddress().getHostAddress() + "端口为:" + socket.getPort());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("一个TCPClient下线了");
            System.out.println("客户端的IP：" + socket.getInetAddress().getHostAddress() + "端口为:" + socket.getPort());
        }
    }
}
