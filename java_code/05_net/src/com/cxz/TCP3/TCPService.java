package com.cxz.TCP3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider;
public class TCPService {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        while(true) {
            Socket socket = ss.accept();
            System.out.println("有一个客户端上线了");
            System.out.println("客户端的IP为：" + socket.getInetAddress().getHostAddress());
            new ServerReader(socket).start();
        }
    }
}