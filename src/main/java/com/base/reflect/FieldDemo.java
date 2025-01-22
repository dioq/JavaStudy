package com.base.reflect;

import java.lang.reflect.Field;

public class FieldDemo {
    //4、通过反射获取成员变量并使用
    /*
    返回一个成员变量
    public Field getField(String name)          获取本类与父类中除私有外的变量
    public Field getDeclaredField(String name)  获取本类任意的变量(包含私有的)
    返回多个成员变量
    public Field[] getFields()
    public Field[] getDeclaredFields()
    */
    public static void main(String[] args) {
        try {
            //获取Class对象
            Class<?> c = Class.forName("com.base.reflect.target.Person");

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
