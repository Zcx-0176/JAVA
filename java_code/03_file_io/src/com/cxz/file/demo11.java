package com.cxz.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class demo11 {
    public static void main(String[] args){
        //打印流
        try(PrintWriter pw = new PrintWriter(new FileOutputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt", true)))
            {
            pw.println("hello world");
            pw.println("hello world");
            pw.println(true);
            pw.println(10);
            pw.println(10.5);
            pw.println('a');
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
