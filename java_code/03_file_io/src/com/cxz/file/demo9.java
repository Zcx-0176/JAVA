package com.cxz.file;

import javax.security.auth.login.FailedLoginException;
import java.io.*;

public class demo9 {
    public static void main(String[] args) throws IOException {
      //缓冲字节输入流
        FileInputStream fis = new FileInputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int b;
        while((b = bis.read()) != -1)
        {
            System.out.print((char)b);
        }
        bis.close();
        //缓冲字节输出流
        FileOutputStream fos = new FileOutputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("hello world".getBytes());
        bos.close();
        //缓冲字符输入流
        FileReader fr = new FileReader("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null)
        {
            System.out.println(line);
        }
        br.close();
        //缓冲字符输出流
        FileWriter fw = new FileWriter("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("hello world");
        bw.newLine();
        bw.write("hello world");
        bw.newLine();
        bw.close();
    }
}
