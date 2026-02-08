package com.cxz.interface4;

public interface a {
    //默认方法
    //能定义普通方法，必须加default修饰，默认会用public修饰
    //只能找实现类调用，因为接口没有对象
    default void print(){
        System.out.println("接口的默认方法");
        print2();
    }
    //私有方法
    //私有的实例方法，不能用实现类对象调用，因为是私有的
    //所以只能在该接口中的其他实例方法中调用
    //比如在上面的print方法中调用
    private void print2(){
        System.out.println("接口的私有方法");
    }
    //静态方法
    //默认用public修饰，只能使用当前接口名调用
    static void print3(){
        System.out.println("接口的静态方法");
    }
}
