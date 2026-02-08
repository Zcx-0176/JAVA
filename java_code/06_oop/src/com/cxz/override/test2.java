package com.cxz.override;

public class test2 {
    public static void main(String[] args) {
        //子类重写Object类的toString()方法，以便返回对象的内容
        student s = new student("CXZ",18,'男');
        System.out.println(s); //默认调用的是s.toString()方法，返回对象s的地址值
    //输出对象的地址没有意思，想看的是对象的内容信息，故需要重写toString()方法，
        // 以便输出对象时默认就近重写的toString()方法,来输出对象内容。
    }
}
class student{
    private String name;
    private int age;
    private char sex;
    public student(String name,int age,char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public student(){}
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public char getSex() {
        return sex;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {  //重写后就是输出对象内容了
        return "姓名："+name+"，年龄："+age+"，性别："+sex;
    }
}