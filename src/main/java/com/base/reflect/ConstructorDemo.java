package com.base.reflect;

import java.lang.reflect.Constructor;

public class ConstructorDemo {

    //1、通过反射获取构造方法
    /*
    在反射机制中，把类中的成员（构造方法、成员方法、成员变量）都封装成了对应的类进行表示。其中，构造方法使用类Constructor表示。可通过Class类中提供的方法获取构造方法
            返回一个构造方法
    public Constructor<T> getConstructor(Class<?>... parameterTypes)         获取本类与父类中除私有外的构造方法
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 获取本类任意的构造(包含私有的)
    返回所有构造方法
    public Constructor<?>[] getConstructors()
    public Constructor<?>[] getDeclaredConstructors()
    */
    public static void main(String[] args) {
        try {
            //获取Class对象
            Class<?> c = null;//包名.类名
            c = Class.forName("com.base.reflect.target.Person");

            //获取所有的构造方法
            //Constructor[] cons = c.getConstructors();
            Constructor<?>[] cons = c.getDeclaredConstructors();
            for (Constructor<?> con : cons) {
                System.out.println(con);
            }

            System.out.println("------------------------");
            //获取一个构造方法
            //public Person()
            Constructor<?> con1 = c.getConstructor(null);
            System.out.println(con1);

            //public Person(String name)
            Constructor<?> con2 = c.getConstructor(String.class);
            System.out.println(con2);

            //private Person(String name, int age)
            Constructor<?> con3 = c.getDeclaredConstructor(String.class, int.class);
            System.out.println(con3);

            //public Person(String name, int age, String address)
            Constructor<?> con4 = c.getDeclaredConstructor(String.class, int.class, String.class);
            System.out.println(con4);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
