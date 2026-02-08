package com.cxz.innerclass3;

public class test {
    public static void main(String[] args) {
        animal a = new animal(){
            @Override
            public void cry() {
                System.out.println("cry");
            }
        };
        a.cry();
    }
}
