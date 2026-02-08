package com.cxz.test;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        double a = sc.nextDouble();
        System.out.println("请输入第二个数字：");
        double b = sc.nextDouble();
        System.out.println("请输入运算符：");
        String op = sc.next();
        double sum = 0;
        sum=test(a,b,op);
        System.out.println("结果为：" + sum);
    }
    public static double test(double a,double b,String op) {
        double sum=0;
        if(b==0 && op.equals("/")){
            System.out.println("除数不能为0，请重新输入！");
        }
        else {
                switch (op) {
                    case "+":
                        sum = a + b;
                        break;
                    case "-":
                        sum = a - b;
                        break;
                    case "*":
                        sum = a * b;
                        break;
                    case "/":
                        sum = a / b;
                        break;
                    default:
                        System.out.println("运算符输入有误！");
                        break;
                }
        }
        return sum;
    }
}
