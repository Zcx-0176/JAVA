package com.cxz.interator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class demo1 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add(new String("AA"));
        c.add(new String("BB"));
        c.add(new String("CC"));
        c.add(new String("DD"));
        c.add(new String("EE"));
        c.add(new String("FF"));
        c.add(new String("GG"));
        c.add(new String("HH"));
        c.add(new String("II"));
        c.add(new String("JJ"));
        System.out.println(c);
        Iterator< String> it = c.iterator();
        while (it.hasNext()) {  //判断当前位置有没有数据
            String s = it.next(); //取当前位置数据赋给s，并把指针移到下一位
            System.out.println(s);
        }
        for(String s:c){
            System.out.println(s);
        }
        c.forEach(new Consumer<String>() {  //一开始的需要匿名内部类
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        c.forEach(s-> System.out.println(s)); //lambda简化后的
    }
}
