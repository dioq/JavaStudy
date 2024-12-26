package com.base.reflect;

public class DataType {

    public static void main(String[] args) {

        test1();
    }

    public static void test() throws ClassNotFoundException {
        String int_class = "java.lang.Integer";
        Class<?> intClass = Class.forName(int_class);
        Class clz = int.class;
    }

    public static void test1() {
        Class<?> intClass = Integer.TYPE;
        System.out.println(intClass.getName()); // 输出：int
        System.out.printf(intClass.getName());
    }
}
