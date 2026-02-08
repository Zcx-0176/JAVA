package com.cxz.code;

public class test {
    public static String a;
    public static int[] arr=new int[52];
    static{
        // 静态代码块，与类一起优先加载，只执行一次，先加载静态代码块
        //故常用于初始化类的静态成员变量
        System.out.println("静态代码块");
        a = "ssssss";
        arr[0]=1;  //初始化静态数组
    }
    public static void main(String[] args) {
        System.out.println("main方法");
    }
}
