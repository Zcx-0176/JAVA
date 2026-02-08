package com.cxz.test;
public class test_03 {
    public static void main(String[] args) {
        System.out.println(test(6));
    }
    public static String test(int n) {
        String code = "";
        for(int i=0;i<n;i++){
            int type=(int)(Math.random()*3);
            switch(type){
                case 0:
                    code+=(char)(Math.random()*26+'a');
                    break;
                case 1:
                    code+=(char)(Math.random()*26+'A');
                    break;
                case 2:
                    code+=(int)(Math.random()*10);
                    break;
            }
        }
        return code;

    }
}
