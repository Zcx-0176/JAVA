package com.cxz.thread_use;

public class demo3 {
    public static void main(String[] args) {
        //搞懂join 方法
        for(int i = 0; i < 12; i++){
            System.out.println("多线程创建");
            if(i == 9){
                Thread t = new Thread(() -> {
                    for(int j = 0; j < 10; j++){
                        System.out.println("多线程创建iiii");
                    }
                });
                t.start();
                try {
                    t.join();
                    System.out.println("t线程执行完毕");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
