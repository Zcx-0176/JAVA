package com.cxz.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class demo7 {
    public static void main(String[] args) throws IOException {
        //文件字符输入流
        FileReader fr = new FileReader("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        int b;
        while((b = fr.read()) != -1)
        {
            System.out.print((char)b);
        }
        fr.close();
        FileReader fr2 = new FileReader("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        char[] c = new char[1024];
        int len;
        while((len = fr2.read(c)) != -1)
        {
            System.out.print(new String(c,0,len));
        }
        fr2.close();
    }
}
