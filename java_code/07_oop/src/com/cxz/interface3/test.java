package com.cxz.interface3;

public class test {
    public static void main(String[] args) {
        student[] students = new student[10];
        students[0] = new student("张三", "男",100);
        students[1] = new student("张三1", "男",10);
        students[2] = new student("张三2", "女",20);
        students[3] = new student("张三3", "男",30);
        students[4] = new student("张三4", "男",40);
        students[5] = new student("张三5", "女",50);
        students[6] = new student("张三6", "女",60);
        students[7] = new student("张三7", "男",70);
        students[8] = new student("张三8", "女",80);
        students[9] = new student("张三9", "男",90);
        classdatainterimpl2 impl1 = new classdatainterimpl2(students);
        impl1.printallstudentinfos();
        impl1.printaveragestudentinfos();
    }
}
