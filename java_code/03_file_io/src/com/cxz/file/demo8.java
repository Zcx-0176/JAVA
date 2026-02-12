package com.cxz.file;

import java.io.FileWriter;
import java.io.IOException;

public class demo8 {
    public static void main(String[] args)
    { //文件字符输出流
        try(FileWriter fw = new FileWriter("E:\\java-workplace\\file_practice\\demo1_practice.txt"))
        {
            fw.write("hello world");
            fw.write("hello world");
            //字符数组
            char[] chs = {'a','b','c'};
            fw.write(chs);
            fw.write(chs,0,2);
            //写字符串的一部分
            fw.write("hello world",0,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
