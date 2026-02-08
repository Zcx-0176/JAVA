package com.cxz.method;

public class method {
    public static void main(String[] args) {
        //目标:掌握方法的定义和调用
        System.out.println(sum(10,20));
        printlnHelloWorld();
        System.out.println(getCode(4));
        printlnHelloWorld(3);
        printlnHelloWorld("cxz");
        printlnHelloWorld("cxz",3);
        divide(10,0);
    }
    //定义一个方法求任意两个整数的和
    public static int sum(int a,int b){
        int result = a+b;
        return result;
    }
    //打印三行的Hello World
    public static void printlnHelloWorld(){
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
    }
    //定义一个方法获取一个四位数验证码，需要接收验证码长度，返回验证码
    public static String getCode(int length){
        String code = "";
        for (int i = 0; i < length; i++) {
            int num = (int)(Math.random()*10);
            code += num;
        }
        return code;
    }
    //掌握方法的重载
    public static void printlnHelloWorld(int count){
        for (int i = 0; i < count; i++) {
            System.out.println("Hello World");
        }
    }
    public static void printlnHelloWorld(String name){
        System.out.println("Hello World, "+name);
    }
    public static void printlnHelloWorld(String name,int count){
        for (int i = 0; i < count; i++) {
            System.out.println("Hello World, "+name);
        }
    }
    //掌握在无返回值的方法中单独使用return，设计一个除法到的功能
    public static void divide(int a,int b){
        if (b==0) {
            System.out.println("除数不能为0");
            return;
        }
        System.out.println(a/b);
    }

}
