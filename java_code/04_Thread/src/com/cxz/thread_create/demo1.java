package com.cxz.thread_create;

public class demo1 {
    public static void main(String[] args) {
        myThread t = new myThread();
        t.start();
        System.out.println("main主线程");
    }
}

class myThread extends Thread{
    @Override
    public void run() {
        System.out.println("线程启动了");
    }
}