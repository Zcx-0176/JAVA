package com.cxz.capsulation;

public class student {

    private String name;
    private int age;
    private double chinese;
    private double math;

    public void setage(int a){//暴露赋值
        if(a>0&&a<=100)
        {
            age=a;
        }
    }
    public int getage(){
        return age;
    }

    public void printallscore(){
        System.out.println(name+"的总成绩为："+(chinese+ math));
    }
    public void printallscore2(){
        System.out.println(name+"的平均成绩为："+(chinese+ math)/2);
    }
}
