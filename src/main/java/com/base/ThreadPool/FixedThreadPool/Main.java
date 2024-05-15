package com.base.ThreadPool.FixedThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    /*
        newFixedThreadPool
        创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        */
    public static void main(String[] args) {
//        fixTheadPoolTest();
        fixTheadPoolTest2();
    }

    /**
     * 1.创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小<br>
     * 2.线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程<br>
     * 3.因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字，和线程名称<br>
     */
    public static void fixTheadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(() -> {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /*
     * 使用execute提交的任务，但是execute方法没有返回值，所以无法判断任务知否被线程池执行成功
     *
     * 使用submit 方法来提交任务，它会返回一个future,那么我们可以通过这个future来判断任务是否执行成功，
     * 通过future的get方法来获取返回值，get方法会阻塞住直到任务完成，而使用get(long timeout, TimeUnit unit)方法则会阻塞一段时间后立即返回，
     * 这时有可能任务没有执行完
     * */
    public static void fixTheadPoolTest2() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            Runnable runnable = () -> {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Future future = fixedThreadPool.submit(runnable);
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
