package com.cxz.staticmathod;

public class student {
    private double score;
    public static void printhelloworld(){
        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");
    }
    public void printpass(){
        System.out.println(score>=60?"通过":"不通过");
    }
    public void setscore(double score){
        this.score=score;
    }
}
