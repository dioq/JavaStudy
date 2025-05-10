package com.base.MethodStack;

import java.util.Arrays;

import java.util.Map;

public class Study01 {
    public static void main(String[] args) {
        Study01 study01 = new Study01();
        study01.method01();
        System.out.println("------------------ another method ------------------");
        study01.method02();
    }

    public void method01() {
        Study01 study01 = new Study01();
        study01.func();
    }

    public void method02() {
        Study01 study01 = new Study01();
        study01.func();
    }

    public void func() {
        System.out.println("============ func ==============");
        // 获取所有线程的栈堆跟踪集合
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        // 去map集合里面拿当前线程的栈堆跟踪信息数组
        StackTraceElement[] stackTraceElements = allStackTraces.get(Thread.currentThread());
        // System.out.println(Arrays.toString(stackTraceElements));
        for (int i = 0; i < stackTraceElements.length; i++) {
            StackTraceElement element = stackTraceElements[i];
            // 获取类名
            String className = element.getClassName();
            // 获取方法名
            String methodName = element.getMethodName();
            String msg = String.format("%s->%s", className,methodName);
            System.out.println(msg);
        }
    }

    public void func2() {
        System.out.println("============ func2 ==============");
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("className:" + className);
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("methodName:" + methodName);
    }
}
