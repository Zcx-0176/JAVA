package com.cxz.stream;

import java.util.*;
import java.util.stream.Stream;

public class demo2 {
    public static void main(String[] args) {
        Collection< String > list = new ArrayList<>();
        Stream< String > s1 = list.stream();
        Map< String, Integer > map = new HashMap<>();
        Stream< Map.Entry< String, Integer > > s2 = map.entrySet().stream();
        Stream< String > s3 = map.keySet().stream();
        String [] arr = {"hello","world","hello world"};
        Stream< String > s4 = Arrays.stream(arr);
        System.out.println(s4.count());
        Stream< String > s5 = Stream.of("hello","world","hello world");
        System.out.println(s5);

    }
}
