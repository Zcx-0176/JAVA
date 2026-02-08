package com.cxz.lambda;

public class test {
    public static void main(String[] args) {
        animal a = new animal(){
            @Override
            public void cry() {
                System.out.println("cry");
            }
        };
        a.cry();
        animal a1 = ()-> {System.out.println("cry");};
        a1.cry();
    }
}
@FunctionalInterface  // 函数式接口的声明注解
interface animal { //函数式接口
    void cry();
}