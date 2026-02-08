package com.cxz.lambda2;

import java.util.Arrays;

public class demo1 {
    public static void main(String[] args) {

    }

    public static void test(){
        student[] s= new student[5];
        s[0] = new student("cxz", 18, 180, "male");
        s[1] = new student("cxz", 18, 180, "male");
        s[2] = new student("cxz", 18, 180, "male");
        s[3] = new student("cxz", 18, 180, "male");
        s[4] = new student("cxz", 18, 180, "male");

        Arrays.sort(s, (s1, s2) -> s1.getAge() - s2.getAge());
        Arrays.sort(s, (s1, s2) -> student.compare(s1, s2));
        Arrays.sort(s, student::compare);  //这个就是静态方法引用
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
