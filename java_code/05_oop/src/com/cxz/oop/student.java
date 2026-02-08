package com.cxz.oop;

public class student {
    String name;
    String gender;
    double ygrade;
    double mgrade;
    public void sum_grade_print(){
        System.out.println(name+"的总成绩为："+(ygrade+mgrade));
    }
    public void average_grade_print(){
        System.out.println(name+ "的平均成绩为："+((ygrade+mgrade)/2));
    }
}
