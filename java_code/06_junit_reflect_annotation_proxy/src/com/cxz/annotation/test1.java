package com.cxz.annotation;
@a(name = "java", city = {"上海"})
@b("去掉了value=，直接写属性值，就是这个字符串")
public class test1 {
    @a(name = "java", age = 12, city = {"上海"})
    public static void main(String[] args) {
    }
}
