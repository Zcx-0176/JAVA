package com.cxz.exception;

public class demo2 {
    public static void main(String[] args) {
        try {
            System.out.println(div(10, 0));
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常信息
        }
    }
    //求两个数的除的结果，并返回这个结果
    public static int div(int a,int b){
        if(b==0){
            throw new RuntimeException("除数不能为0");
            //通过throw new Exception对象，抛出一个异常
            //因为如果除法计算有问题，那么就需要告诉程序员有问题
            //但是程序必须要有int返回值了，还想要停止运行除法
            //那么就可以用throw new Exception对象，把异常【抛出去
        }
        return a/b;
    }
}
