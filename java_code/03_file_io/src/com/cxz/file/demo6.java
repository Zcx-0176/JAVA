package com.cxz.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo6 {
    public static void main(String[] args){
        try( FileInputStream f1 = new FileInputStream("E:\\java-workplace\\file_practice\\demo1_practice.txt");
             FileOutputStream f2 = new FileOutputStream("E:\\java-workplace\\file_practice\\demo1_practice_copy.txt");
             )
        {
            int b;
            while((b = f1.read()) != -1)
            {
                f2.write(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
