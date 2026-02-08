package com.cxz.array;

public class arraydemo {
    public static void main(String[] args) {
        array_demo();
    }
    public static void array_demo(){
        String[] name={"aws","ffsg","hfhtfh","gfhdthr","hthrds"};
        int num=(int)(Math.random()*name.length);
        String a = name[num];
        System.out.println(a);
    }
}
