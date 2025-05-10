package com.base.reflect;

import java.lang.reflect.Constructor;

public class ConstructorInfo {
    public static void main(String[] args) {
        try {
            Class<?> clz = Class.forName("com.base.reflect.target.Person");
            Constructor<?> con1 = clz.getConstructor();
            Constructor<?> con2 = clz.getDeclaredConstructor(String.class, int.class, String.class);
            showInfo(con1);
            System.out.println("----------------------");
            showInfo(con2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showInfo(Constructor<?> con) {
        String className = con.getDeclaringClass().getName();
        System.out.println("className:" + className);
        // className = con.getClass().getName();
        // System.out.println("className:" + className);

        int modifier = con.getModifiers();
        System.out.println("modifier:" + modifier);

        // System.out.println("getParameterCount():" + con.getParameterCount());
        // System.out.println("getParameters():" +
        // con.getParameters().getClass().getName());

        Class<?>[] parameterTypes = con.getParameterTypes(); // 获取参数类型
        System.out.println("parameterTypes:" + con.getParameterTypes().length);
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clz = parameterTypes[i];
            String msg = String.format("parameterTypes[%d]:%s", i, clz.getName());
            System.out.println(msg);
        }
    }
}
