package com.cxz.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class demo10 {
    public static void main(String[] args)
    {
        //字符输入转换流，构造方法
        try(
                FileInputStream isr = new FileInputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
                InputStreamReader isr1 = new InputStreamReader(isr,"GBK");
        ){
            int b;
            while((b = isr.read()) != -1)
            {
                System.out.print((char)b);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("文件不存在");
        }
    }
}
