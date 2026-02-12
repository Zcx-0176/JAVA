package com.cxz.file;

import java.io.*;

public class demo12 {
    public static void main(String[] args) throws FileNotFoundException {
        //特殊数据流，特殊字节输入流构造器
        FileInputStream fis = new FileInputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        DataInputStream dis = new DataInputStream(fis);
        try(dis){
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readChar());
        } catch (Exception e){
            e.printStackTrace();
        }
        //特殊字符输出流
        FileOutputStream fos = new FileOutputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        try(dos){
            dos.writeInt(100);
            dos.writeBoolean(true);
            dos.writeChar('a');
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
