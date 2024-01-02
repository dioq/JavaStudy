package com.my.reflect;

import java.lang.reflect.Field;

public class FieldDemo {
    //4、通过反射获取成员变量并使用
    /*
    返回一个成员变量
    public Field getField(String name) 获取指定的 public修饰的变量
    public Field getDeclaredField(String name) 获取指定的任意变量
    返回多个成员变量
    public Field[] getFields() 获取所有public 修饰的变量
    public Field[] getDeclaredFields() 获取所有的 变量 (包含私有)
    */
    public static void main(String[] args) {
        try {
            //获取Class对象
            Class c = Class.forName("com.my.reflect.Person");

            //获取成员变量
            //多个变量
            //Field[] fields = c.getFields();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("-----------------");
            //一个变量
            //public int age;
            Field ageField = c.getField("age");
            System.out.println(ageField);

            //private String address
            Field addressField = c.getDeclaredField("address");
            System.out.println(addressField);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
