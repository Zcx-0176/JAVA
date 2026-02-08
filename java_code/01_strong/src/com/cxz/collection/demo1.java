package com.cxz.collection;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
       /* List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        System.out.println(list.get(0));

        Set< String> s = new HashSet<>();
        s.add("hello");
        s.add("hello");
        s.add("world");
        s.add("java");
        System.out.println(s); */

        Collection< String > list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        list.remove("world");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("hello"));
        list.clear();
        Object[] Ob  = list.toArray();
        String[] arr = list.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));
    }
}
