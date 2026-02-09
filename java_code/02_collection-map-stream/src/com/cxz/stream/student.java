package com.cxz.stream;

public class student {
    private String name;
    private int age;
    private int score;
    public student(String name,int age,int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getScore(){
        return score;
    }
    @Override
    public String toString(){
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

}
