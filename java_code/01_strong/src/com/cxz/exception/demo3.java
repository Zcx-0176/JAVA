package com.cxz.exception;

public class demo3 {
    public static void main(String[] args) {
        try {
            show(0);
        } catch (AgeIllegalRuntimeException e) {
            e.printStackTrace();
        }
    }
    //公司的系统，只要收到了年龄小于1岁或大于200岁，就是一个非法异常
    public static void show(int age) {
        if(age<1||age>200){
            throw new AgeIllegalRuntimeException("非法年龄");
        }else{
            System.out.println("年龄合法");
        }
    }
}
