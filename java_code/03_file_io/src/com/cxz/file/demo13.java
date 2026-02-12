package com.cxz.file;

import org.apache.commons.io.FileUtils;

public class demo13 {
    public static void main(String[] args)
    {//Commom-io框架的使用
        try {
            FileUtils.copyFile(new java.io.File("E:\\java-workplace\\file_practice\\demo1_practice.txt"),new java.io.File("E:\\java-workplace\\file_practice\\demo1_practice_copy.txt"));
            System.out.println("复制成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
