package com.cxz.lambda2;

import java.util.Arrays;
import java.util.Comparator;
public class demo3 {
    public static void main(String[] args) {
        //有一个字符串数组，里面有一些人的名字，请按照名字的首字母进行升序排序
        String[] names = {"cxz", "Aws", "ffsg", "hfhtfh", "gfhdthr", "hthrds", "as"};
        //把数组进行首字母排序Arrays.sort(names，comparator);
        //忽略首字母大小进行排序，需要自己制定好
        Arrays.sort(names,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2); //忽略大小写进行排序
            }
        });
        //调用特定类型的方法进行排序
        Arrays.sort(names,(o1, o2)-> o1.compareToIgnoreCase(o2));//忽略大小写进行排序
        Arrays.sort(names,String::compareToIgnoreCase); //特定方法类型引用
        //因为前面的参数列表的第一个参数是o1，是作为方法compareToIgnoreCase的主调
        //后面的参数o2,是作为该实例方法入参的，故可以进行特定类型方法引用
        //特定类型就是 String
        for (String name : names) {
            System.out.println(name);
        }
    }
}
