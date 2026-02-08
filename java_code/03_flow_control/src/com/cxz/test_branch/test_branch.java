package com.cxz.test_branch;
import java.util.Scanner;
public class test_branch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("前方红绿灯是什么颜色：");
        String color = sc.next();
        traffic(color);
    }
    public static void traffic(String color){
        if(color.equals("红")){
            System.out.println("请等红灯,前方停车等待！");
        }
        else if(color.equals("绿")){
            System.out.println("请过绿灯,可以通行！");
        }
        else{
            System.out.println("为了行车安全请等待绿灯亮起！");
        }
    }
}
