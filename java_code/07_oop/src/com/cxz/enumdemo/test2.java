package com.cxz.enumdemo;

public class test2 {
    public static void main(String[] args)
    {
        move(m.UP);
    }
    public static void move(m em){
        switch (em){
            case UP:
                System.out.println("向上");
                break;
            case DOWN:
                System.out.println("向下");
                break;
            case LEFT:
                System.out.println("向左");
                break;
            case RIGHT:
                System.out.println("向右");
                break;
        }
    }
}
