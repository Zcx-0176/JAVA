package com.cxz.generasity;

public class demo6 {
    public static void main(String[] args) {
        Integer it = Integer.valueOf(100);

        Integer it1 = 100;

        int i1 = it1;

        int j = 23;
        String[] rs = new String[]{Integer.toString(j)};
        System.out.println(rs[0]);

        String str = "98";
        int i=Integer.parseInt(str);
        System.out.println(i);
        System.out.println(i+2);
        int k = Integer.valueOf(str);
        System.out.println(k);
    }
}
