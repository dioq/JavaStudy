package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo2 {

    //3、通过反射方式，获取私有构造方法，创建对象
    /*
    获取私有构造方法，步骤如下：
        1. 获取到Class对象
        2. 获取指定的构造方法
        3. 暴力访问, 通过setAccessible(boolean flag)方法
        4. 通过构造方法类Constructor中的方法，创建对象
    * */
    public static void main(String[] args) {
        try {
            //1,获取到Class对象
            Class<?> c = Class.forName("com.base.reflect.target.Person");//包名.类名
            //2,获取指定的构造方法
            //private Person(String name, int age)
            Constructor<?> con = c.getDeclaredConstructor(String.class, int.class);
            //3,暴力反射
            con.setAccessible(true);//取消 Java 语言访问检查

            //4,通过构造方法类中的功能，创建对象
            Object obj = con.newInstance("小明", 23);
            System.out.println(obj);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
