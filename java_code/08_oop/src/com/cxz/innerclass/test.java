package com.cxz.innerclass;

public class test {
    public static void main(String[] args)
    {
        //外部类名.内部类名 创建内部类对象名 = new 外部类名().new 内部类名();
        classd.innerclass a = new classd().new innerclass();
        a.show();
    }
}
