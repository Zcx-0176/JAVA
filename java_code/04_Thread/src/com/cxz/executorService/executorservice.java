package com.cxz.executorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class executorservice {
    public static void main(String[] args) {
        //使用线程池的实现类ThreadPoolExecutor声明7个参数来创建
        ThreadPoolExecutor TE = new ThreadPoolExecutor(
                3,5,
                1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        myrunnable r = new myrunnable();
        TE.execute(r); //提交第一个任务 线程池会创建一个线程执行
        TE.execute(r); //提交第二个任务 线程池会创建一个线程执行
        TE.execute(r); //提交第三个任务 线程池会创建一个线程执行
        TE.execute(r); //复用，因为corePoolSize为3
        TE.execute(r); //复用，因为corePoolSize为3
        TE.execute(r);
        TE.execute(r);
        TE.execute(r);
        TE.execute(r);
        //一般不关闭线程池，如下只是演示
        TE.shutdown(); //等待所有任务执行完毕再关闭
        //TE.shutdownNow(); //立即关闭，并打断正在执行的任务
    }
}
