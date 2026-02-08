package com.cxz.literal;

public class literal_demo {
    /**
     * 目标:掌握常见字面量的书写格式
     */
    public static void main(String[] args) {
        printlnliteral();
    }
    public static void printlnliteral(){
        //请帮我直接输出常见的字面量
        System.out.println(true);   //输出布尔型字面量
        System.out.println(false);
        System.out.println(1);   //输出整型字面量
        System.out.println(1.0);   //输出浮点型字面量
        System.out.println('a');   //输出字符型字面量,且有且有一个字符
        System.out.println("hello world");  //输出字符串字面量
        System.out.println('a'+1);
        System.out.println("hello\nworld\n");   //\n换行
        System.out.println("hello\tworld");  //\t制表符,表示缩进
    }
}
