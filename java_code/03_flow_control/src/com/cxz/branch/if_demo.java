package com.cxz.branch;

import java.util.Scanner;

public class if_demo {
    public static void main(String[] args) {
        if_demo();
    }
    public static void if_demo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入该员工的分数：");
        int grade = sc.nextInt();
        if(grade<60){
            System.out.println("E");
        }
        else if(grade>=60&&grade<70){
            System.out.println("D");
        }
        else if(grade>=70&&grade<80){
            System.out.println("C");
        }
        else if(grade>=80&&grade<90){
            System.out.println("B");
        }
        else if(grade>=90&&grade<=100){
            System.out.println("A");
        }
        else{
            System.out.println("分数输入有误！");
        }
    }
}
