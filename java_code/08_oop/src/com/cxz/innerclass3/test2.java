package com.cxz.innerclass3;

public class test2 {
    public static void main(String[] args) {
        swim s1 = new swim(){
            @Override
            public void swiming() {
                System.out.println("student can swiming");
            }
        };
        start(s1);
        start(new swim(){
            @Override
            public void swiming() {
                System.out.println("teacher can swiming");
            }
        });
    }
    public static void start(swim s){
        s.swiming();
    }
}
interface swim{
    void swiming();
}
