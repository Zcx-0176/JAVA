package com.cxz.thread_use;

public class demo2 {
    public static void main(String[] args) {
        //搞清楚Thread的sleep方法
        for(int i = 0; i < 100; i++){
            System.out.println("多线程创建");
            try {
                Thread.sleep(1000);
                System.out.println("线程睡眠1秒");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
