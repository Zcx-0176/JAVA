package com.cxz.javabean;

public class student {
    private String name;
    private int age;
    private double chinese;
    private double math;
    public student() {
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getChinese() {
        return chinese;
    }

    public double getMath() {
        return math;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public student(String name, int age, double chinese, double math) {
        this.name = name;
        this.age = age;
        this.chinese = chinese;
        this.math = math;
    }
}
