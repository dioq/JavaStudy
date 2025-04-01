package com.study01.singleton;

//懒汉式(线程安全,调用效率不高,但是能延时加载)
public class SingletonDemo {
    // 类初始化时,不初始化这个对象(延时加载,真正用的时候再创建)
    private static SingletonDemo instance;

    // 构造器私有化
    private SingletonDemo() {
    }

    // 方法同步,调用效率低
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                instance = new SingletonDemo();
            }
        }
        return instance;
    }
}
