package com.cxz.code;

public class test2 {
    private String name;
    {  // 实例代码块，无static修饰，属于对象
        System.out.println("实例代码块");
        name = "cxz"; //初始化对象的实例资源
    }
    public static void main(String[] args) {
        test2 t = new test2();
        System.out.println("main方法");
    }
}
