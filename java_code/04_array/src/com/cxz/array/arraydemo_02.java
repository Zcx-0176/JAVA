package com.cxz.array;
import java.util.Scanner;
public class arraydemo_02 {
    public static void main(String[] args) {
        array_demo_02();
    }
    public static void array_demo_02(){
        double[] grade = new double[8];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<8;i++){
            grade[i]=sc.nextDouble();
        }
        double average=0;
        double sum=0;
        for(int i=0;i<8;i++){
            sum+=grade[i];
        }
        average=sum/8.0;
        double min=grade[0];
        double max=grade[0];
       for(int i=1;i<8;i++){
           if(min>=grade[i]){
               min=grade[i];
           }
           else if(max<=grade[i]){
               max=grade[i];
           }
       }
       System.out.println("average:"+ average);
       System.out.println("max:"+ max);
       System.out.println("min:"+ min);
    }
}
