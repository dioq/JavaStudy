package com.base.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo4 {
    /*
     * Refect 调用静态方法
     * */
    public static void main(String[] args) {
        try {
            Class<?> cla = Class.forName("com.base.reflect.target.Person");
            Method method = cla.getDeclaredMethod("method6", String.class);
            String result = (String) method.invoke(null, "a_test_valuex");
            System.out.println("result: " + result);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
