package com.study01.ThreadPool.study02;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * 关于关闭线程：
 * 推荐使用shutdown 而不是shutdownNiw，shutdown 会遍历线程池中的线程，并逐个关闭其状态，对于正在执行线程会等待其执行结束（interrupt），
 * shutdownNow类似立即停止，所以~推荐使用shutdown就好，当然如果有特殊情况除外。
 * 监控：
 * 通过继承线程池可以自定义线程池，重写beforeExecute、afterExecute、terminated方法，在开始前、执行后、中止的时候调用。
 * */
public class Test01 {
    public static void main(String[] args) {
        MyCustomPool testCustomMyPool = new MyCustomPool(10,
                10, 0L,
                TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("正在执行线程");
            }
        };
        testCustomMyPool.execute(runnable);
        testCustomMyPool.shutdown();
    }
}
