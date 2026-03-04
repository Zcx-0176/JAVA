package com.cxz.TCP1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider;

public class TCPService {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String data = dis.readUTF();
        int id = dis.readInt();
        System.out.println("收到客户端数据："+data+"  id为："+id);
        System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress()+"端口为:"+socket.getPort());
        socket.close();
    }
}
