package com.cxz.array;
public class arraydem {
    public static void main(String[] args) {
        start(5);
    }
    public static void start(int n) {
        int[][] num=new int[n][n];
        int a=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                num[i][j]=a;
                a++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(num[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               int u =(int)(Math.random()*n);
               int v=(int)(Math.random()*n);
               int swap=num[i][j];
               num[i][j]=num[u][v];
               num[u][v]=swap;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(num[i][j]+" ");
            }
            System.out.println();
        }
    }
}
