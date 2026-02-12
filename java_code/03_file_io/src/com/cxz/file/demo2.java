package com.cxz.file;

public class demo2 {
    public static void main(String[] args) {
        //认识递归
        print2(5);
    }
    public static void print(int n)
    {
        print2( n);
    }
    //间接递归
    public static void print2(int n)
        {
            if(n > 0)
            {
                System.out.println(n);
                print(n - 1);
            }
        }
}
