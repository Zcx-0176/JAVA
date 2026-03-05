package com.cxz.junit;

public class demo1 {
    public static void printNumber(String name){
        System.out.println("名字长度是" + name.length());
    }
    public static int getMaxIndex(String data){
        if(data == null|| "".equals(data)){
            return -1;
        }
        return data.length();
    }
}
