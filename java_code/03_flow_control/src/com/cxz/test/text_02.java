package com.cxz.test;
import java.util.Scanner;
public class text_02 {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        //随机生成1-100的数字
        int num = (int)(Math.random()*100+1);
        System.out.println("请您猜测一下生成的数字(1-100)范围内：");
        Scanner sc = new Scanner(System.in);
        int a = -1;
        while(a!=num){
            a = sc.nextInt();
            if(a<num){
                System.out.println("您猜的数字太小了！");
            }
            else if(a>num){
                System.out.println("您猜的数字太大了！");
            }
        }
        System.out.println("恭喜您猜对了！");
    }
}
