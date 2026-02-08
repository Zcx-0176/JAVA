package com.cxz.innerclass3;

import java.util.Arrays;
import java.util.Comparator;
public class test3 {
    public static void main(String[] args) {
        student[] s = new student[6];
        s[0] = new student("cxz1", 18, 180, "male");
        s[1] = new student("cxz2", 14, 183, "male");
        s[2] = new student("cxz3", 12, 181, "male");
        s[3] = new student("cxz4", 15, 159, "male");
        s[4] = new student("cxz5", 16, 160, "male");
        s[5] = new student("cxz6", 17, 190, "male");
        Arrays.sort(s, (o1,  o2)-> o1.getAge() - o2.getAge());
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
