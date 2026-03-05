package com.cxz.annotation;

public class test2 {
    private String name;
    public test2(){}
    public test2(String name){
        this.name = name;
    }
    @mytest
    public void show(){
        System.out.println("show()方法执行了...");
    }
}
