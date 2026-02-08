package com.cxz.interface3;

public class classdatainterimpl2 implements classdatatnter{
    private student[] students;
    public classdatainterimpl2(student[] students) {
        this.students = students;
    }
    @Override
    public void printallstudentinfos() {
        //打印所有信息，以及打出学生是男生的人数
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
            if (students[i].getSex().equals("男")) {
                count++;
            }
        }
        System.out.println("男生人数是：" + count);
    }
    @Override
    public void printaveragestudentinfos() {
        //打印平均分，并输出男生的平均分
        double sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getScore();
        }
        System.out.println("平均分是：" + sum / students.length);
        double sum1 = 0;
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getSex().equals("男")) {
                sum1 += students[i].getScore();
                count++;
            }
        }
        System.out.println("男生平均分是：" + sum1 / count);
    }
}
