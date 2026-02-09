package com.cxz.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class demo5 {
    public static void main(String[] args) {
        List< String > list = new ArrayList<>();
        list.add("11");
        list.add("21");
        list.add("31");
        list.add("41");
        Collections.addAll(list,"51","61");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
