package com.cxz.synchronized_code;

public class account {
    private String accountNo;
    private double balance;
    public void drawoney(double drawAmount){
        String name = Thread.currentThread().getName();
        synchronized ("dlei") {
            if (balance >= drawAmount) {
                balance -= drawAmount;
                System.out.println(name + "取钱成功，余额为：" + balance);
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
        }
    }
}
