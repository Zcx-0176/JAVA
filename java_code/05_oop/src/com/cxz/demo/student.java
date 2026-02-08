package com.cxz.demo;

public class student {
    String name;
    int age;
    String sex;
    public void print(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.sex);
    }
    public student(String name,int age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
}
