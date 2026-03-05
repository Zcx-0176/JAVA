package com.cxz.reflection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestInstancePreConstructCallback;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class demo2 {
    @Test
    public  void getclassInfo() {
        Class c1 = dog.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
    }
    @Test
    public void getclassInfo2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c1 = dog.class;
        Constructor[] cons = c1.getDeclaredConstructors();
        for(Constructor c : cons){
            System.out.println(c);
        }
        System.out.println("--------------------------------");
        Constructor con2 = c1.getDeclaredConstructor();
        System.out.println(con2);
        System.out.println("--------------------------------");
        Constructor con3 = c1.getDeclaredConstructor(String.class);
        System.out.println(con3);
        System.out.println("--------------------------------");
        Constructor con4 = c1.getDeclaredConstructor(String.class, int.class);
        System.out.println(con4);
        System.out.println("--------------------------------");
        //获取构造器的作用依旧是创建对象
        //可以暴力反射，暴力反射可以访问private属性和private方法
        con2.setAccessible(true); //绕过访问权限，临时改变访问权限
        dog d1 = (dog) con2.newInstance();
        System.out.println(d1);
        System.out.println("--------------------------------");
        dog d2 = (dog) con4.newInstance("张三", 18); //这和con4是public的，不需要暴力反射就能创建对象
        System.out.println(d2);
    }
    @Test
    public void getclassInfo3() throws NoSuchFieldException, IllegalAccessException {
        Class c1 = dog.class;
        Field[] fields = c1.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f);
        }
        System.out.println("--------------------------------");
        Field field = c1.getDeclaredField("name");
        System.out.println(field);
        System.out.println("--------------------------------");
        Field field2 = c1.getDeclaredField("age");
        System.out.println(field2);
        System.out.println("--------------------------------");
        //获取成员变量的目的依旧是取值赋值
        dog d1 = new dog("ssad", 10); //要想对成员变量进行操作，需要先声明一个对象
        //要么是暴力反射，把私有构造器临时改变，要么就是声明公有构造器
        //上面就是声明了公有构造器
        field.setAccessible(true);  //对私有成员变量暴力反射
        field.set(d1, "张三");  //赋值
        System.out.println(d1.getName());
        System.out.println("--------------------------------");
        String name = (String) field.get(d1);  //取值
        System.out.println(name);
    }
    @Test
    public void getclassInfo4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c1 = dog.class;
        Method[] methods = c1.getDeclaredMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println("--------------------------------");
        Method method = c1.getDeclaredMethod("getAge");
        System.out.println(method);
        System.out.println("--------------------------------");
        Method method2 = c1.getDeclaredMethod("setAge", int.class);
        System.out.println(method2);
        System.out.println("--------------------------------");
        Method method3 = c1.getDeclaredMethod("show");
        System.out.println(method3);
        System.out.println("--------------------------------");
        Method method4 = c1.getDeclaredMethod("show", String.class);
        System.out.println(method4);
        System.out.println("--------------------------------");
        //方法的目的是调用和执行
        //方法也需要用对象才能调，跟成员变量一样
        dog d1 = new dog("张三", 18);
        //method.setAccessible(true);
        int age = (int) method.invoke(d1);
        System.out.println(age);
    }
}
