package com.cxz.javabean;

public class test {
    public static void main(String[] args) {
        student s1 = new student();
        s1.setName("CXZ");
        s1.setAge(18);
        s1.setChinese(100);
        s1.setMath(100);
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getChinese());
        System.out.println(s1.getMath());

        student s2 = new student("CXZ",18,100,100);
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.getChinese());
        System.out.println(s2.getMath());

        student_service ss = new student_service(s2);
        ss.print_sum_grade();
        ss.print_average_grade();

    }
}
