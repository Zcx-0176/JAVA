package com.cxz.staticfield;

public class test {
    public static void main(String[] args) {
        student.name="CXZ";
        System.out.println(student.name);

        student s1 = new student();
        s1.age=18;
        student s2 = new student();
        s2.age=19;
        System.out.println(s1.age);
        System.out.println(s2.age);
    }
}
