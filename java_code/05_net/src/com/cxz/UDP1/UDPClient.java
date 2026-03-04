package com.cxz.UDP1;

import java.io.IOException;
import java.net.*;
public class UDPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("UDPClient启动");
        //完成UDP一发一收，客户端开发
        DatagramSocket ds = new DatagramSocket();  //创建发送端对象
        byte[] bytes = "hello,UDP".getBytes();  //数据内容
        /*
        参数一：发送的数据，字节数组
        参数二：字节数组的长度
        参数三：指定发送的目标地址
        参数四：指定发送的目标端口
         */
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),8080);  //创建要发的数据报包
        ds.send(dp);
    }
}
