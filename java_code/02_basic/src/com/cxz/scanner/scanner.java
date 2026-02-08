package com.cxz.scanner;
//1.导包
import java.util.Scanner;   //告诉我的程序去jdk里面找包用scanner
                            //可以选中scanner，按alt+shift+回车，自动导包
public class scanner {
    public static void main(String[] args) {
        print();
    }
    //写一个程序，可以让用户键盘输入他的用户名和年龄
    public static void print() {

        //2.创建对象(直接抄写这行代码，得到一个scanner扫描器对象)
        Scanner sc = new Scanner(System.in);

        //3.调用方法
        System.out.println("请输入你的用户名：");
        String name = sc.next();   //让程序在这一行暂停，等待用户输入一个字符串，等到按了回车，再往下走
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();   //让程序在这一行暂停，等待用户输入一个整数，等到按了回车，再往下走
        System.out.println("你的用户名是：" + name + "，你的年龄是：" + age);
    }
}
