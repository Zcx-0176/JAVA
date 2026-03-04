package com.cxz.synchronized_code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class demo3 {
    private String accountNo;
    private double balance;
    private final Lock lk = new ReentrantLock();
    public void drawoney(double drawAmount){
        String name = Thread.currentThread().getName();
        lk.lock();
        try{
            if (balance >= drawAmount) {
                balance -= drawAmount;
                System.out.println(name + "取钱成功，余额为：" + balance);
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
        }finally {
            lk.unlock();
        }
    }
}
