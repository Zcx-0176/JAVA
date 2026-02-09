package com.cxz.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo3 {
    public static void main(String[] args) {
        //调用一堆中间方法
        List< String > list = new ArrayList<>();
        list.add("CCC ");
        list.add("BBAAS");
        list.add("CCAA");
        list.add("DDAADDD");
        list.add("EEAA");
        list.add("BAA");
       /* list.stream()
                .filter(s -> s.contains("AA"))
                .filter(s -> s.length() == 4)
                .forEach(System.out::println);
        System.out.println("------------------");
        //排序
        list.stream().sorted().forEach(System.out::println);
        System.out.println("------------------");
        list.stream().sorted((s1,s2)->s2.length()-s1.length()).forEach(System.out::println);
        System.out.println("------------------");
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("------------------");
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("------------------");
        list.stream().distinct().forEach(System.out::println);
        System.out.println("------------------");
        list.stream().map(s -> "每个加B:"+(s+"B")).forEach(System.out::println);
        System.out.println("------------------");
        String[] arr1 = {"1,2,3","4,5,6","7,8,9"};
        String[] arr2 = {"10,11,12","13,14,15","16,17,18"};
        Stream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).forEach(System.out::println);
*/
        List< student > list1 = new ArrayList<>();
        list1.add( new student("张三",18,90));
        list1.add( new student("李四",19,80));
        list1.add( new student("王五",20,70));
        list1.add( new student("赵六",21,60));
        //list1.stream().forEach(System.out::println);
        //System.out.println("------------------");
        //System.out.println(list1.stream().count());
        //System.out.println("------------------");
        //System.out.println(list1.stream().max(Double::compareTo));
        //System.out.println("------------------");
        //System.out.println(list1.stream().min(Double::compareTo));
        //System.out.println("------------------");
        //List< Double> list2 = list1.stream().collect(Collectors.toList());
        //System.out.println(list2);
        //System.out.println("------------------");
        //Set< Double > set = list1.stream().collect(Collectors.toSet());
        //System.out.println(set);
        //System.out.println("------------------");
        //toArray() | 转成数组，返回Object[]
        //Object[] arr = list1.stream().toArray();
        //System.out.println(Arrays.toString(arr));
        //System.out.println("------------------");
        //toList() | 转成List集合，返回List<T>
        //

       //取学生姓名和成绩转成Map集合，返回Map<K,V>
        Map< String,Integer > map1 = list1.stream().collect(Collectors.toMap(student::getName,student::getScore));
        System.out.println(map1);
        System.out.println("------------------");




    }
}
