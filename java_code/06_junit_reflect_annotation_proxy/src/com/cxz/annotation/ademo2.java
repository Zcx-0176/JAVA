package com.cxz.annotation;

import com.cxz.junit.demo1;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
public class ademo2 {
    @Test
    public void parseClass(){
        Class c1 = demo.class;
        if(c1.isAnnotationPresent(mytest2.class)){
            mytest2 mt = (mytest2) c1.getDeclaredAnnotation(mytest2.class);
            System.out.println(mt.value());
            System.out.println(Arrays.toString(mt.city()));
            System.out.println(mt.price());
            System.out.println("--------------------------------");
        }
    }
    @Test
    public void parseMethod(){
        Class c1 = demo.class;
        Method[] methods = c1.getDeclaredMethods();
        for(Method m : methods){
            if(m.isAnnotationPresent(mytest2.class)){
                mytest2 mt = m.getDeclaredAnnotation(mytest2.class);
                System.out.println(mt.value());
                System.out.println(Arrays.toString(mt.city()));
                System.out.println(mt.price());
                System.out.println("--------------------------------");
            }
        }
    }
}
