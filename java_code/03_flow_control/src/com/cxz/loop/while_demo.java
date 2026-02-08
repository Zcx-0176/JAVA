package com.cxz.loop;

public class while_demo {
    public static void main(String[] args) {

        test2();
    }
    public static void test() {
        double money=100000;
        double num=100000;
        int year=0;
        double rate=0.017;
        while(num<2.0*money){
            num=num*(1+rate);
            year++;
        }
        System.out.println(year);
    }
    public static void test2() {
        double a = 0.1;
        int i=0;
        while(a<8848860){
            a=a*2;
            i++;
        }
        System.out.println(i);
    }
}
