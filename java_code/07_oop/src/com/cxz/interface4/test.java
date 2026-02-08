package com.cxz.interface4;

public class test {
    public static void main(String[] args) {
        b b1= new b();
        b1.print();
        a.print3();  //用当前接口名来调用静态方法，不能用子类名在调
    }
}
