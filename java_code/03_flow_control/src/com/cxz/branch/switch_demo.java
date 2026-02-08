package com.cxz.branch;
import java.util.Scanner;
public class switch_demo {
    public static void main(String[] args) {

        test2();
    }
    public static void test() {
        System.out.println("请输入你的性别：");
        Scanner sc = new Scanner(System.in);
        String sex = sc.next();
        switch(sex){
            case "男":
                System.out.println("剑来");
                break;
            case "女":
                System.out.println("霸道总裁爱上我");
                break;
            default:
                System.out.println("你输入的性别有误");
                break;
        }
    }
    public static void test2() {
        String week="周二";
        switch (week){
            case "周一":
                System.out.println("上班");
                break;
            case "周二":
            case "周三":
            case "周四":
                System.out.println("休息");
                break;
            case "周五":
            case "周六":
                System.out.println("玩");
        }
    }
}
