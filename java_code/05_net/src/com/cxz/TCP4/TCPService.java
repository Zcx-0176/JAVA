package com.cxz.TCP4;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class TCPService {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        ExecutorService executorService = new ThreadPoolExecutor(
                10,
                10,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.AbortPolicy());
        while(true) {
            Socket socket = ss.accept();
            System.out.println("有一个客户端上线了");
            System.out.println("客户端的IP为：" + socket.getInetAddress().getHostAddress());
            executorService.execute(new ServerReader(socket));
        }
    }
}