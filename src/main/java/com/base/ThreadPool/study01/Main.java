package com.base.ThreadPool.study01;

import java.util.concurrent.*;

/*
 * 提交任务的方法：
 * 1.execute：不返回值
 * 2.submit：返回值（future类型对象）
 *
 * future 是一个接口类，其实现类是FutureTask
 * Callable 类似Runnable 但是它会有返回值。
 * */
public class Main {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "hi 我是返回值";
            }
        };
        executor.execute(runnable);

        Future future = executor.submit(callable);
        try {
            Object o = future.get();
            System.out.println(o);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
