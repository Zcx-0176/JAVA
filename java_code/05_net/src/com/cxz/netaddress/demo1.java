package com.cxz.netaddress;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo1 {
    public static void main(String[] args) {
        //认识InetAddress
        try{
            InetAddress ip1 = InetAddress.getLocalHost(); //获取本机IP
            System.out.println(ip1); //LAPTOP-HJJ64TEQ/169.254.172.173,主机名和主机IP地址
            System.out.println(ip1.getHostName()); //LAPTOP-HJJ64TEQ
            System.out.println(ip1.getHostAddress()); //169.254.172.173 就是自己的IP，即公网IP
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");  //获取百度的IP
            System.out.println(ip2); //www.baidu.com/39.156.70.239
            System.out.println(ip2.getHostName()); //www.baidu.com
            System.out.println(ip2.getHostAddress()); //39.156.70.239
            System.out.println(ip2.isReachable(1000));  //判断百度是否可以访问，联网了就是true
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
