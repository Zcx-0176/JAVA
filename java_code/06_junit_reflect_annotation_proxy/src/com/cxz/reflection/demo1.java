package com.cxz.reflection;

public class demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = student.class;
        System.out.println(c1); //打印：class com.cxz.reflection.student
        Class c2 = Class.forName("com.cxz.reflection.student");
        System.out.println(c2);
        student s = new student();
        Class c3 = s.getClass();
        System.out.println(c3);
    }
}
