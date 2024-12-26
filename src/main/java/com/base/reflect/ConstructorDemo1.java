package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo1 {

    //2、通过反射方式，获取构造方法，创建对象
    /*
    获取构造方法，步骤如下：
        1. 获取到Class对象
        2. 获取指定的构造方法
        3. 通过构造方法类Constructor中的方法，创建对象
    */
    public static void main(String[] args) {
        try {
            //1,获取到Class对象
            Class<?> c = Class.forName("com.base.reflect.target.Person");//包名.类名
            //2,获取指定的构造方法
            //public Person()
            //Constructor con = c.getConstructor(null);

            //public Person(String name, int age, String address)
            Constructor<?> con = c.getConstructor(String.class, int.class, String.class);

            //3,通过构造方法类中Constructor的方法，创建对象
            //Object obj = con.newInstance(null);
            Object obj = con.newInstance("小明", 22, "哈尔滨");
            //显示
            System.out.println(obj);
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
