package com.cxz.abstreactdemo3;

public  abstract class write {
    public void write2(){
        System.out.println("写");
        write1();
        System.out.println("写完");
    }
    public abstract void write1();
}
