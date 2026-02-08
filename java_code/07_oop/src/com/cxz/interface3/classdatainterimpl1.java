package com.cxz.interface3;

public class classdatainterimpl1 implements classdatatnter{
    private student[] students;
    public classdatainterimpl1(student[] students) {
        this.students = students;
    }
    @Override
    public void printallstudentinfos() {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
    @Override
    public void printaveragestudentinfos() {
        double sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getScore();
        }
        System.out.println("平均分是：" + sum / students.length);
    }
}
