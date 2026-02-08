package com.cxz.generasity;

public class demo4 {
    public static void main(String[] args)
    {
        String[] array = {"1","2","3"};
        printarray(array);
        student[] students = new student[3];
        students[0] = new student();
        students[1] = new student();
        students[2] = new student();
        printarray(students);
    }
    public static <E> void printarray(E[] array){
    }
}
