package com.cxz.thread_create;

public class demo2 {
    public static void main(String[] args) {
        myrunnable r = new myrunnable();
        Thread t = new Thread(r);
        t.start();
        //匿名内部类写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程创建");
            }
        }).start();
        new Thread(() -> System.out.println("多线程创建")).start();
    }
}
class myrunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("多线程创建");
    }
}