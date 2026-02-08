package com.cxz.javabean;

public class student_service {
    private student s;

    public student_service(student s) {
        this.s = s;
    }

    //打印学生总成绩
    public void print_sum_grade(){
        System.out.println(s.getName()+"的总成绩是："+(s.getChinese()+s.getMath()));
    }
    //打印学生平均成绩
    public void print_average_grade(){
        System.out.println(s.getName()+"的平均成绩是："+(s.getChinese()+s.getMath())/2);
    }
}
