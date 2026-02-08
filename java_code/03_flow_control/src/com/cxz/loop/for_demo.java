package com.cxz.loop;
public class for_demo {
    public static void main(String[] args) {
        test();
    }
    public static void test() {

        for(int i = 100; i < 1000; i++){
            int a=i/100;
            int b=i/10-a*10;
            int c=i-100*a-10*b;
            int sum=a*a*a+b*b*b+c*c*c;
            if(sum==i){
                System.out.println(i);
            }
        }

    }
}
