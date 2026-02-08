package com.cxz.lambda2;

import java.util.Arrays;
public class demo2 {
    public static void main(String[] args) {
        student[] s = new student[6];
        s[0] = new student("cxz1", 18, 182, "male");
        s[1] = new student("cxz2", 18, 157, "male");
        s[2] = new student("cxz3", 18, 156, "male");
        s[3] = new student("cxz4", 18, 170, "male");
        s[4] = new student("cxz5", 18, 160, "male");
        s[5] = new student("cxz6", 18, 189, "male");
        student t = new student();
        Arrays.sort(s, (s1,s2)->t.comparebyheight(s1,s2));
        Arrays.sort(s,t::comparebyheight); //这个就是实例方法引用
        for (int i = 0; i < s.length; i++) {
                System.out.println(s[i].getHeight());
        }
    }
}
