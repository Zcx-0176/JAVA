package com.cxz.oop;

public class Test {
    public static void main(String[] args) {
        /*Star s1 = null;
        try {
            s1 = new Star();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        s1.name="王祖贤";
        s1.age=30;
        s1.gender="女";
        s1.height=1.58;
        s1.weight=50;
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.gender);
        System.out.println(s1.height);
        System.out.println(s1.weight);*/
        student s1 = new student();
        s1.name="张三";
        s1.gender="女";
        s1.ygrade=100;
        s1.mgrade=100;
        s1.sum_grade_print();
        s1.average_grade_print();
        student s2 = new student();
        s2.name="李四";
        s2.gender="男";
        s2.ygrade=59;
        s2.mgrade=100;
        s2.sum_grade_print();
        s2.average_grade_print();

    }
}
