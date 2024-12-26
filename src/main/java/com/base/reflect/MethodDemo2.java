package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo2 {
    //7、 通过反射，创建对象，调用指定的方法
    /*
        1. 获取Class对象
　　    2. 获取构造方法
　　    3. 通过构造方法，创建对象
        4. 获取指定的方法
        5. 执行找到的方法
　　  public Object invoke(Object obj,  Object... args)  执行指定对象obj中，当前Method对象所代表的方法，方法要传入的参数通过args指定。
    * */
    public static void main(String[] args) {
        try {
            //1， 获取Class对象
            Class<?> c = Class.forName("com.base.reflect.target.Person");
            //2,获取构造方法
            //public Person(String name, int age, String address){
            Constructor<?> con = c.getConstructor(String.class, int.class, String.class);
            //3，通过构造方法，创建对象
            Object obj = con.newInstance("小明", 23, "哈尔滨");
            //4，获取指定的方法
            //public void method1()  没有返回值没有参数的方法
            //Method m1 = c.getMethod("method1", null);

            //public String method4(String name)
            Method m4 = c.getMethod("method4", String.class);
            //5，执行找到的方法
            //m1.invoke(obj, null);
            Object result = m4.invoke(obj, "itcast");
            System.out.println("result = " + result);
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
