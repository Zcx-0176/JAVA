package com.cxz.thread_use;

import static java.lang.Thread.currentThread;
public class demo1 {
    public static void main(String[] args) {
        //学习线程提供的方法
        mythread t1 = new mythread();
        t1.start();
        mythread t2 = new mythread();
        t2.start();
        System.out.println(t1.getName()); //打印结果为Thread-0
        System.out.println(t2.getName()); //打印结果为Thread-1
        Thread T = currentThread(); //哪个线程调用这行代码，就返回哪个线程
        //这是主函数调用，所以下面一行打印结果为main
        System.out.println(T.getName());
        mythread t3 = new mythread();
        t3.setName("线程3"); //在线程启动前设置名字
        t3.start();
        System.out.println(t3.getName()); //打印结果为线程3
        mythread t4 = new mythread("4号线程");
        t4.start();
        System.out.println(t4.getName());  //打印结果为4号线程
        Runnable r = new myrunnable();
        Thread t5 = new Thread(r,"5号线程");
        Thread t6 = new Thread(r);
    }
}
class mythread extends Thread{
    public mythread(String name) {
        super(name);
    }
    public mythread() {
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"多线程创建");
        //哪个线程调用，就返回哪个线程的名称+多线程创建这行字符串
    }
}
class myrunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("多线程创建");
    }
}