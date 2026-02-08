package com.cxz.demo;

import java.util.Scanner;
public class test {
    public static void main(String[] args){
        goldcard gc = new goldcard("CXZ", "CXZ", "123456", 5000);
        silvercard sc = new silvercard("CXZ1", "CXZ1", "654321",2000);
        pay(gc);
        pay(sc);
    }
    public static void pay(card c){
        System.out.println("请刷卡，请输入您消费的金额：");
        Scanner scc = new Scanner(System.in);
        double money = scc.nextDouble();
        if(c instanceof goldcard){
            goldcard gc = (goldcard)c;
            gc.consume(money);
        }else if(c instanceof silvercard){
            silvercard sc = (silvercard)c;
            sc.consume(money);
        }
    }
}
