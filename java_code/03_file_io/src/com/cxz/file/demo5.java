package com.cxz.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class demo5 {
    public static void main(String[] args) throws IOException {
        // 创建一个File对象，构造方法中传递父目录和子文件/目录的名称
        OutputStream f1 = new FileOutputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        f1.write(97);
        f1.write("\r\n".getBytes());
        f1.write(98);
        f1.write('v');
        byte[] bt = {97,98,99,100,101};
        f1.write(bt);
        f1.write(bt,1,3);
        byte[] bt2 = "hello world".getBytes();
        f1.write(bt2);
        f1.close();
        //OutputStream f1 = new FileOutputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt",true);
    }
}
