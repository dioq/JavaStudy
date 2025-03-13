package com.base.reflect;

import java.lang.reflect.Method;

public class MethodDemo {
    //6、通过反射获取成员方法并使用
    /*
    在反射机制中，把类中的成员方法使用类Method表示。可通过Class类中提供的方法获取成员方法：
          返回获取一个方法：
    　　　 public Method getMethod(String name, Class<?>... parameterTypes)
          获取本类与父类中除私有外的方法
    　　　 public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
          获取本类任意的方法(包含私有的)
    　　　 参数1: name 要查找的方法名称； 参数2： parameterTypes 该方法的参数类型
          返回获取多个方法：
    　　　 public Method[] getMethods() 获取本类与父类中除私有外的所有的方法
    　　　 public Method[] getDeclaredMethods() 获取本类中所有的方法(包含私有的)
    * */

    public static void main(String[] args) {
        try {
            //获取Class类
            Class<?> c = Class.forName("com.base.reflect.target.Person");

            //获取多个方法
            //Method[] methods = c.getMethods();
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            System.out.println("-----------------------");
            //获取一个方法：
            //public void method1()
            Method method = c.getMethod("method1");
            System.out.println(method);
            //public String method4(String name){
            method = c.getMethod("method4", String.class);
            System.out.println(method);
            //私有方法
            //private void method5()
            method = c.getDeclaredMethod("method5");
            System.out.println(method);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
