package com.cxz.set;

import java.util.HashSet;
import java.util.Set;

public class demo2 {
    public static void main(String[] args) {
        student s1 = new student("cxz", 18);
        student s2 = new student("cxz", 18);
        Set< student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println(set);
    }
}
