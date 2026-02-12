package com.cxz.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class demo4 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
       // int b;
       // while ((b = is.read()) != -1) {
        //    System.out.print((char)b);
       // }
        byte[] bs = new byte[1024];
        int len;
        while ((len = is.read(bs)) != -1) {
            System.out.print(new String(bs,0,len));
        }
    }
}
