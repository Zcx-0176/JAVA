package com.cxz.reflection;

public class dog {
    private String name;
    private int age;
    private dog(){}
    public dog(String name, int age){
        this.name = name;
        this.age = age;
    }
    private dog(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("我的名字叫" + name + "，年龄是" + age);
    }
    public void show(String name){
        System.out.println("我的名字叫" + name + "，年龄是" + age);
    }
}
