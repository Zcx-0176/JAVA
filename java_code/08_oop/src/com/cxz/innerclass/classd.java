package com.cxz.innerclass;

public class classd {
    public static int a=0;
    private int b=0;
    public class innerclass {  //成员内部类，属于外部类对象
        public void show()
        {
            System.out.println("show");
            System.out.println(a);
            System.out.println(b);
            System.out.println(classd.this);
        }
    }
}
