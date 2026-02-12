package com.cxz.file;

import java.io.UnsupportedEncodingException;

public class demo3 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "啦啦啦啦啦";
        byte[] by=name.getBytes();
        System.out.println(by.length); // 15个字节
        byte[] by2=name.getBytes("GBK");
        System.out.println(by2.length); // 10个字节

        String name2 = new String(by);
        System.out.println(name2);
        String name3 = new String(by2,"GBK");
        System.out.println(name3);
    }
}
