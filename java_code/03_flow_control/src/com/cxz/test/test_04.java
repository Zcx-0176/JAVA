package com.cxz.test;
public class test_04 {
    public static void main(String[] args) {
        int count=0;
        for(int i=101;i<=200;i++){
        count=test(i,count);
        }
        System.out.println("101-200之中共有"+ count + "个素数");
    }
    public static int test(int number,int count){
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                count++;
                System.out.println(number);
                return count;
            }
        }
        return count;
    }
}
