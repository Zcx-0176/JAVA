package com.cxz.proxy;

import java.lang.reflect.Proxy;
public class demo1 {
    //创建代理对象
    public static void main(String[] args) {
        Star star = new Star("cxz");
        StarService proxy = ProxyUtil.createProxy(star);
        proxy.sing("玛卡巴卡");
        String dance = proxy.dance();
    }
}
