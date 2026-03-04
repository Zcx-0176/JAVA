package com.cxz.thread_create;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
public class demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        mycallable c = new mycallable();
        FutureTask<String> ft = new FutureTask<String>(c);
        Thread t = new Thread(ft);
        t.start();
        System.out.println(ft.get());
    }
}
//定义一个实现类实现Callable接口
class mycallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            sum += i;
        }
        return "子线程计算后的结果为："+ sum;
    }
}
