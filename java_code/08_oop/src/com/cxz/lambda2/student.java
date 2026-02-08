package com.cxz.lambda2;

public class student {
    private String name;
    private int age;
    private int height;
    private String sex;

    public student() {

    }

    public static int compare(student s1, student s2){
        return s1.getAge() - s2.getAge();
    }
    public student(String name, int age, int height, String sex) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
    }
    public int comparebyheight(student s1, student s2){
        return s1.getHeight() - s2.getHeight();
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
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
