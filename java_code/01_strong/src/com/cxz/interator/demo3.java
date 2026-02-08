package com.cxz.interator;

import java.util.ArrayList;
import java.util.List;

public class demo3 {
    public static void main(String[] args) {
        List< String>  list = new ArrayList<>();
        list.add("CCCC ");
        list.add("BBAA");
        list.add("CCAA");
        list.add("DDAA");
        System.out.println(list);
        System.out.println(list.get(2));
        list.add(2,"AAAA");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.set(2,"BBBB");
        System.out.println(list);
    }
}
