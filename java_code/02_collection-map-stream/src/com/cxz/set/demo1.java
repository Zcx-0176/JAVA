package com.cxz.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class demo1 {
    public static void main(String[] args) {
        Set<String> ss = new HashSet<>();
        ss.add("AAAA");
        ss.add("BBBB");
        ss.add("CCCC");
        ss.add("DDDD");
        ss.add("EEEE");
        ss.add("AAAA");
        System.out.println(ss);
        Set< String > Sh = new LinkedHashSet<>();
        Sh.add("AAAA");
        Sh.add("BBBB");
        Sh.add("CCCC");
        Sh.add("DDDD");
        Sh.add("EEEE");
        Sh.add("AAAA");
        System.out.println(Sh);
        Set< String> St = new TreeSet<>();
        St.add("AAAA");
        St.add("CCCC");
        St.add("DDDD");
        St.add("EEEE");
        St.add("BBBB");
        St.add("AAAA");
        System.out.println(St);
    }
}
