package com.cxz.singlestance;

public class a {
    private a(){ //私有构造器，确保无法对外创建对象
    }
    //定义一个静态变量，用于保存单例对象
    public static final a  instance= new a(); //变量名为 instance
    //用final修饰后，就无法再次赋值，避免修改该对象为null导致错误
}
