package com.my.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo4 {

    public static void main(String[] args) {
        try {
            Class<?> threadClazz = Class.forName("com.my.reflect.Person");
            Method method = threadClazz.getMethod("method6", String.class);
            String result = (String) method.invoke(null, "a_test_valuex");
            System.out.println("result: " + result);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
