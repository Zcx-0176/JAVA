package com.cxz.executorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class executordemo1 {
    public static void main(String[] args) {
        //通过创建Executors类中的方法获取线程池对象
        ExecutorService pool1 = Executors.newFixedThreadPool(5);
        ExecutorService pool2 = Executors.newSingleThreadExecutor();
        ExecutorService pool3 = Executors.newCachedThreadPool();
        ExecutorService pool4 = Executors.newScheduledThreadPool(5);
    }
}
