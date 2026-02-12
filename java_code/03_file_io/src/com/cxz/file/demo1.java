package com.cxz.file;

import java.io.File;
import java.io.IOException;

public class demo1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("E:\\java-workplace\\file_practice");
        File f2 = new File("E:\\java-workplace\\file_practice","demo1_practice.txt");
        File f3 = new File(f1,"demo1_practice.txt");
        //System.out.println(f1.getName());
        //System.out.println(f2.length());
        //System.out.println(f3.length());
        //System.out.println(f1.isDirectory());
        //System.out.println(f2.isFile());
        File f4 = new File("E:\\java-workplace\\file_practice\\demo2_practice.txt");
        System.out.println(f4.createNewFile());
        File f5 = new File("E:\\java-workplace\\file_practice\\demo3_practice");
        System.out.println(f5.mkdir());
        File f6 = new File("E:\\java-workplace\\file_practice\\demo4_practice\\demo5_practice");
        System.out.println(f6.mkdirs());
        //System.out.println(f6.delete());
        //遍历
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
        String[] list = f1.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
