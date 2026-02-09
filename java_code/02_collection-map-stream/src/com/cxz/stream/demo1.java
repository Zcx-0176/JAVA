package com.cxz.stream;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args)
    {
        List< String > list = new ArrayList<>();
        list.add("CCCC ");
        list.add("BBAA");
        list.add("CCAA");
        list.add("DDAA");
        list.add("EEAA");
        list.add("BAA");
        //找出含有AA的，字符串为4个的，存放到新的集合中
        List< String > list2 = list.stream()
                .filter(s -> s.contains("AA"))
                .filter(s -> s.length() == 4)
                .toList();
        System.out.println(list2);
    }
}
