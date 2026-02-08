package com.cxz.Stringdemo;

import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(s1);
        System.out.println(s1.length());  //处理字符串的方法，取长度

        String s2 = new String();
        System.out.println(s2);
        String s3 = new String("hello");
        System.out.println(s3);
        char[] chars= {'h','e','l','l','o'};
        String s4 = new String(chars);
        System.out.println(s4);
        byte[] bytes = {97,98,99,100,101};
        String s5 = new String(bytes);
        System.out.println(s5);
        s1.length();  //获取字符串长度
        s1.charAt(0); //获取指定索引位置的字符
        s1.toCharArray();  //将当前字符串转换成字符数组
        s1.equals(s3);   //判断两个字符串的内容是否一样，一样返回true
        s1.equalsIgnoreCase(s3);  //忽略大小写判断两个字符串的内容是否一样，一样返回true
        s1.substring(1,3);  //根据开始和结束索引进行截取，得到新的字符串，左闭右开
        s1.substring(1);  //截取从传入的索引开始，一直截取到字符串末尾，得到新的字符串
        s1.replace('l','o');  //替换，将所有匹配的旧字符替换为新字符，得到新的字符串
        s1.contains("ll");  //判断当前字符串中是否包含传入的子串，包含返回true
        s1.startsWith("he");  //判断当前字符串是否以指定字符串开头，是返回true
        s1.split("l");  //将当前字符串按照传入的分隔符进行切割，得到字符串数组

        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add(1,"java");
        System.out.println(list);
        list.remove(1);
        System.out.println(list.remove("world"));
        System.out.println(list);
        list.set(0,"java");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}
