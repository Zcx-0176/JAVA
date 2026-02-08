package com.cxz.operator;

import org.w3c.dom.ls.LSOutput;

public class operator {
    public static void main(String[] args) {
     //目标：理解基本算数运算符
        operator_demo1();
        operator_demo2();
        operator_demo3();
        operator_demo4();
        operator_demo5();
        operator_demo6();
        System.out.println(operator_demo7(180,70,'男'));
    }
    //算数运算符
    public static void operator_demo1(){
        int a = 10;
        int b = 3;
        int c = a + b;
        System.out.println(c);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println((double)a/b);
        System.out.println(a%b);
    }
    public static void operator_demo2(){
        int a=5;
        System.out.println("abc"+a);
        System.out.println(a+5);
        System.out.println("fdsfee"+a+"abc");
        System.out.println(a+'a'+"abc");
    }
    public static void operator_demo3(){
        int a=1;
        int d=++a;
        System.out.println(d);
        int b=1;
        int e=b++;
        System.out.println(e);
        System.out.println(b);
        int c=1;
        int m=--c;
        System.out.println(m);
        int z=1;
        int n=z--;
        System.out.println(n);
        System.out.println(z);
    }
    public static void operator_demo4(){
        //收红包
        byte a = 100;
        byte b=10;
        a +=b;
        System.out.println(a);
    }
    public static void operator_demo5(){
        int a=10;
        int b=11;
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a!=b);
    }
    public static void operator_demo6(){
        int a=10;
        int b=40;
        int c=50;
        int max=a>b?(a>c?a:c):(b>c?b:c);
        System.out.println(max);
    }
    public static boolean operator_demo7(int height,int weight,char sex){
        boolean result=height>170&weight>60&sex=='男';
        return result;
    }
}
