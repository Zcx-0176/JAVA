package com.cxz.executorService;

import java.util.concurrent.Callable;
public class mycallable implements Callable<String> {
    private int n;
    public mycallable(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {

        int sum = 0;
        for(int i = 1; i <=n; i++){
            sum += i;
        }
        return Thread.currentThread().getName()+"子线程计算后的结果为："+ sum;
    }
}