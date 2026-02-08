package com.cxz.lambda;

import com.cxz.innerclass3.student;
import java.util.Arrays;
import java.util.Comparator;
public class test2 {
    public static void main(String[] args) {
        com.cxz.innerclass3.student[] s = new com.cxz.innerclass3.student[6];
        s[0] = new com.cxz.innerclass3.student("cxz1", 18, 180, "male");
        s[1] = new com.cxz.innerclass3.student("cxz2", 14, 183, "male");
        s[2] = new com.cxz.innerclass3.student("cxz3", 12, 181, "male");
        s[3] = new com.cxz.innerclass3.student("cxz4", 15, 159, "male");
        s[4] = new com.cxz.innerclass3.student("cxz5", 16, 160, "male");
        s[5] = new com.cxz.innerclass3.student("cxz6", 17, 190, "male");
        Arrays.sort(s, (com.cxz.innerclass3.student o1, student o2)-> {
            return o1.getAge() - o2.getAge(); //返回值是正数，升序排列
            //返回值是负数，降序排列
        });
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}

