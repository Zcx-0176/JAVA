package com.cxz.array;

public class arraydemo_03 {
    public static void main(String[] args) {
        array_demo_03();
    }
    public static void array_demo_03() {
        String[][] classroom=new String[][]{
                {"aws ","ffsg ","hfhtfh ","gfhdthr ","hthrds "},
                {"aws ","ffsg ","hfhtfh ","gfhdthr ","hthrds "},
                {"aws ","ffsg ","hfhtfh ","gfhdthr ","hthrds "},
                {"aws ","ffsg ","hfhtfh ","gfhdthr ","hthrds "},
                {"aws ","ffsg ","hfhtfh ","gfhdthr ","hthrds "}
        };
        for(int i=0;i<classroom.length;i++){
            for(int j=0;j<classroom[i].length;j++){
                System.out.print(classroom[i][j]);
            }
            System.out.println();
        }
    }
}