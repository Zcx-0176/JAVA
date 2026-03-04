package com.cxz.executorService;

import java.util.concurrent.*;
public class demo2 {
    public static void main(String[] args) {
        //使用线程池的实现类ThreadPoolExecutor声明7个参数来创建
        ThreadPoolExecutor TE = new ThreadPoolExecutor(
                3,5,
                1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Future<String> ft1 = TE.submit( new mycallable(100));
        Future<String> ft2 = TE.submit( new mycallable(200));
        Future<String> ft3 = TE.submit( new mycallable(300));
        Future<String> ft4 = TE.submit( new mycallable(400));
        try {
            System.out.println(ft1.get());
            System.out.println(ft2.get());
            System.out.println(ft3.get());
            System.out.println(ft4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
