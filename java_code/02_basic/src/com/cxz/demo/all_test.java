package com.cxz.demo;
import java.util.Scanner;
public class all_test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你的性别：");
        String sex = sc.next();
        System.out.println("请输入你的体重(kg)：");
        double weight = sc.nextDouble();
        System.out.println("请输入你的身高(m)：");
        double height = sc.nextDouble();
        System.out.println("你的BMI是："+ BMI(weight,height));
        System.out.println("你的BMR是："+ BMR(weight,height,age,sex));
    }
    public static double BMI(double weight,double height){
        double bmi=weight/(height*height);
        return bmi;
    }
    public static double BMR(double weight,double height,int age,String sex){
        double bmr=0.0;
        if("男".equals(sex)){
            bmr=88.362+(13.397*weight)+(4.799*100*height)-(5.677*age);
        }
        else if("女".equals(sex)){
            bmr=447.593+(9.247*weight)+(3.098*100*height)-(4.330*age);
        }
        return bmr;
    }
}
