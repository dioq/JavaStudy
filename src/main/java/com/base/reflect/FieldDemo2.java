package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldDemo2 {
    //5、通过反射，创建对象，获取指定的成员变量，进行赋值与获取值操作
    /*
    获取成员变量，步骤如下:
        1. 获取Class对象
    　　 2. 获取构造方法
    　　 3. 通过构造方法，创建对象
         4. 获取指定的成员变量（私有成员变量，通过setAccessible(boolean flag)方法访问）
         5. 通过方法，给指定对象的指定成员变量赋值或者获取值
　　　　  public void set(Object obj, Object value)   在指定对象obj中，将此 Field 对象表示的成员变量设置为指定的新值
　　　　  public Object get(Object obj)   返回指定对象obj中，此 Field 对象表示的成员变量的值
    */
    public static void main(String[] args) {
        try {
            //1,获取Class对象
            Class<?> c = Class.forName("com.base.reflect.target.Person");
            //2，获取构造方法
            //public Person(String name)
            Constructor<?> con = c.getConstructor(String.class);
            //3，通过构造方法，创建对象
            Object obj = con.newInstance("小明");
            //4，获取指定的成员变量
            //public String name;
            Field nameField = c.getField("name");
            //public int age;
            Field ageField = c.getField("age");
            //private String address;
            Field addressField = c.getDeclaredField("address");
            addressField.setAccessible(true); //取消 Java 语言访问检查
            // 类的静态属性, 没有生命周期,进程结束才释放
            Field weathField = c.getDeclaredField("weath");
            weathField.setAccessible(true); //取消 Java 语言访问检查

            //5，通过方法，给指定对象的指定成员变量赋值或者获取值
            //取值
            System.out.println("name = " + nameField.get(obj));
            System.out.println("age = " + ageField.get(obj));
            System.out.println("address = " + addressField.get(obj));
            System.out.println("weath = " + weathField.get(null));

            //赋值
            ageField.set(obj, 23);
            addressField.set(obj, "凯利广场");
            weathField.set(weathField.get(null), "150万");

            System.out.println("------------------------");
            System.out.println("name = " + nameField.get(obj));
            System.out.println("age = " + ageField.get(obj));
            System.out.println("address = " + addressField.get(obj));
            System.out.println("weath = " + weathField.get(null));
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
