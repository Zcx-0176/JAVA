package com.cxz.singlestance;

public class test {
    public static void main(String[] args) {
        a a1 =  a.instance; //因为是静态变量只加载一份
        a a2 =  a.instance; //a1,a2 都指向同一份

        b b1 = b.getInstance();
    }
}
