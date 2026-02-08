package com.cxz.override;

public class test {
    public static void main(String[] args) {
        cat c = new cat();
        c.cry();
    }
}
class animal{
    public void cry(){
        System.out.println("动物会叫");
    }
}
class cat extends animal{
    @Override  //方法重写的校验注解，告诉编译器，我重写这个方法，方法名要是不一样就会报错
    public void cry(){
        System.out.println("喵喵喵");
    }
}
