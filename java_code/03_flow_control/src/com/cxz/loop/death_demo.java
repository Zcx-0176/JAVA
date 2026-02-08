package com.cxz.loop;

public class death_demo {
    public static void main(String[] args) {

    }
    public static void test(){
        while(true){
            System.out.println("死循环");
        }
    }
    public static void test2(){
        for(;;){
            System.out.println("死循环");
        }
    }
    public static void test3(){
        do{
            System.out.println("死循环");
        }while(true);
    }

}
