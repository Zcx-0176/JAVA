package com.cxz.TCP4;

import java.io.*;
import java.net.Socket;
public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream(); //字节输出流，把服务端数据推到浏览器上展示
            PrintStream ps = new PrintStream(os); //因为HTTP格式每次都要换行，所以跟打印流非常契合，因为打印流写数据自带换行
            //所以将字节输出流包装为打印流
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html; charset=UTF-8");
            ps.println();  //最后一行必须要换行
            ps.println("<html>");
            ps.println("<head><title>Hello World</title></head>");
            ps.println("<body>");
            ps.println("<h1 style='color=red;font-size:100px'>Hello World。啦啦啦啦这是给浏览器展示的正文</h1>");
            ps.println("</body>");
            ps.println("</html>");
            ps.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("一个TCPClient下线了");
            System.out.println("客户端的IP：" + socket.getInetAddress().getHostAddress() + "端口为:" + socket.getPort());
        }
    }
}