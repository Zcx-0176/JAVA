package com.cxz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//专门负责创建代理对象并返回
public class ProxyUtil {
    public static StarService createProxy(Star s){
        StarService proxy=(StarService) Proxy.newProxyInstance(
                /*
                参数一：用于执行哪个类加载器去加载生成的代理对象
                固定代码 ：类名.class.getClassLoader()
                 */
                ProxyUtil.class.getClassLoader(),
                /*
                参数二：代理对象需要实现的接口
                固定代码 ：new Class[]{接口.class}
                 */
                new Class[]{StarService.class},
                /*
                参数三：代理类需要如何去代理(代理要做的事情)
                固定代码 ：new InvocationHandler(){}
                 */
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //声明代理对象要干的活
                        /*
                            这个匿名内部类
                            参数一：proxy接收代理对象本身
                            参数二：method接收代理对象要调用的方法
                            参数三：args接收代理对象要调用方法时传递的参数
                         */
                        if(method.getName().equals("sing")){
                            System.out.println("开始执行代理方法");
                            System.out.println("准备话筒，收钱20w");
                        }else if(method.getName().equals("dance")){
                            System.out.println("开始执行代理方法");
                            System.out.println("准备场地跳舞，收钱20w");
                        }
                        Object result = method.invoke(s, args);
                        return  result;
                    }
                });
        return proxy;
    }
}
