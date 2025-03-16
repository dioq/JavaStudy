package com.base.JavaClass;

public class MethodInfo02 {
    public static void main(String[] args) {
        test1();
    }

    // 类信息
    public static void test1() {
        String className = MethodInfo02.class.getClass().getName();
        System.out.println("className:" + className);
        className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("className:" + className);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("methodName:" + methodName);
        int lineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();
        System.out.println("lineNumber:" + lineNumber);
        String fileName = Thread.currentThread().getStackTrace()[1].getFileName();
        System.out.println("fileName:" + fileName);
    }
}
