package com.cxz.variable;

public class variable {
    public static void main(String[] args) {
        //目标：认识变量
        variable_demo();
        variable_replace();
        wallet();
        basic_data_type();
    }
    //定义一个方法，学习变量的定义
    public static void variable_demo(){
        //定义一个变量
        int a = 10;
        //定义一个变量
        int b = 20;
        //定义一个变量
        int c = a + b;
        //定义一个变量
        String name = "cxz";
        //定义一个变量
        char gender = '男';
        //定义一个变量
        double score = 99.99;
        //定义一个变量
        boolean flag = true;
        //定义一个变量
        int age = 18;
       //输出上述变量
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(score);
        System.out.println(flag);
        System.out.println(age);
    }
    //变量是可以被替换的
    public static void variable_replace(){
        int a = 10;
         a = a+2;
        System.out.println(a);
    }
    //微信钱包目前有9.5元，收到6元的红包，又发出去5元设计一个方法，实时输出目前钱包的钱数
    public static void wallet(){
        //定义一个变量，表示微信钱包的余额
        double money = 9.5;
        System.out.println(money);
        //定义一个变量，表示收到的红包
        double redpacket = 6;
        money=money+redpacket;
        System.out.println(money);
        //定义一个变量，表示发出去的红包
        double redpacket2 = 5;
        money=money-redpacket2;
        System.out.println(money);
        char ch='A';
        System.out.println(ch+1);
        char ch1='a';
        System.out.println(ch1+1);
    }
    //掌握八种基本数据类型的定义
    public static void basic_data_type(){
        int a = 10;
        System.out.println(a);
        char ch = 'A';
        System.out.println(ch);
        double d = 99.99;
        System.out.println(d);
        boolean flag = true;
        System.out.println(flag);
        byte b = 127;
        System.out.println(b);
        short s = 32767;
        System.out.println(s);
        long l = 999999999999999999L;
        System.out.println(l);
        float f = 99.99f;
        System.out.println(f);
        //输出一个引用数据类型
        String str = "cxz";
        System.out.println(str);
        String num = "1";
        System.out.println(num+"2");
    }
}
