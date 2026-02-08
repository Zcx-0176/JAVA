package com.cxz.type;

public class type {
    public static void main(String[] args) {
        //认识自动类型转换
        byte a=12;
        type_demo1(a);
        int b=12;
        type_demo2(b);
        int c=150;
        //强制类型转换
        byte d=(byte)c;
        type_demo3(d);


    }
    //认识自动类型转换
    public static void type_demo1(int a){
        System.out.println(a);
    }
    public static void type_demo2(double a){
        System.out.println(a);
    }
    //写一个方法掌握强制类型转换
    public static void type_demo3(byte a){
        System.out.println(a);
    }
    //目标：理解表达式中的自动类型提升
    public static double calc(int a ,int b,double c,char r){
        return a+b+c+r;
    }
    public static int calc(byte a ,byte b){
        return a+b;
    }
    public static byte calc(byte a ,byte b,byte d){
        byte c=(byte)(a+b+d);
        return c;
    }
}
