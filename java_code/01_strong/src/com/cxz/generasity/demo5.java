package com.cxz.generasity;

public class demo5 {
    public static void main(String[] args) {
        myarraylist<xiaomi> list = new myarraylist<xiaomi>();
        go(list);
        myarraylist<huawei> list2 = new myarraylist<huawei>();
        go(list2);
    }
    public static void go(myarraylist<? extends car> list){
    }
    public static void go2(myarraylist<? super car> list){
    }
}
class car{
}
class xiaomi extends car{
}
class huawei extends car{
}