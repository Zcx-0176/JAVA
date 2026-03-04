package com.cxz.synchronized_code;

public class demno2 {
    private String accountNo;
    private double balance;
    public synchronized void drawoney(double drawAmount){
        String name = Thread.currentThread().getName();
            if (balance >= drawAmount) {
                balance -= drawAmount;
                System.out.println(name + "取钱成功，余额为：" + balance);
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
    }
}
