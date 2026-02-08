package com.cxz.loop;

public class break_continue_demo {
    public static void main(String[] args) {
        test1();
    }
    public static void test() {
        for(int i=0;i<10;i++){
            if(i==5){
                break;
            }
            System.out.println(i);
        }
    }
    public static void test1() {
        for(int i=0;i<10;i++){
            if(i==5){
                continue;
            }
            System.out.println(i);
        }
    }
}
