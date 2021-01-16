package com.my.ThreadPool.study02;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * 线程池还有其他一些方法可以来监控线程池的情况
 * */
public class Test02 {
    public static void main(String[] args) {
        MyCustomPool testCustomMyPool = new MyCustomPool(10, 10, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("正在执行线程");
            }
        };
        testCustomMyPool.execute(runnable);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 需要执行的任务数量
        System.out.println("需要执行的任务数量:" + testCustomMyPool.getTaskCount());
        // 已完成的任务数量
        System.out.println("已完成的任务数量:" + testCustomMyPool.getCompletedTaskCount());
        // 创建最大线程数量
        System.out.println("创建最大线程数量:" + testCustomMyPool.getLargestPoolSize());
        // 线程池的线程数量
        System.out.println("线程池的线程数量:" + testCustomMyPool.getPoolSize());
        // 线程池活动的线程数
        System.out.println("线程池活动的线程数:" + testCustomMyPool.getActiveCount());

        testCustomMyPool.shutdown();
    }
}
