package com.base.reflect;

public class ClassLoad {

    public static void main(String[] args) throws ClassNotFoundException {
        test1();
        test2();
    }

    public static void test1() throws ClassNotFoundException {
        String int_class = "java.lang.Integer";
        Class<?> intClass = Class.forName(int_class);
        if (intClass.equals(int.class)) {
            System.out.println("intClass equals clz");
        } else {
            System.out.println("intClass not equals clz");
        }
    }

    public static void test2() {
        Class<?> intClass = Integer.TYPE;
        System.out.println(intClass.getName()); // 输出：int
    }
}
