package com.base.reflect;

import java.lang.reflect.Field;

import com.base.reflect.target.Person;

public class FieldDemo2 {
    // 5、通过反射，创建对象，获取指定的成员变量，进行赋值与获取值操作
    /*
     * 获取成员变量，步骤如下:
     * 1. 获取Class对象
     * 2. 获取构造方法
     * 3. 通过构造方法，创建对象
     * 4. 获取指定的成员变量（私有成员变量，通过setAccessible(boolean flag)方法访问）
     * 5. 通过方法，给指定对象的指定成员变量赋值或者获取值
     * public void set(Object obj, Object value) 在指定对象obj中，将此 Field
     * 对象表示的成员变量设置为指定的新值
     * public Object get(Object obj) 返回指定对象obj中，此 Field 对象表示的成员变量的值
     */
    public static void main(String[] args) {
        try {
            // 获取Class对象
            Class<?> c = Class.forName("com.base.reflect.target.Person");
            // 获取指定的成员变量
            // public String name;
            Field nameField = c.getField("name");
            // public int age;
            Field ageField = c.getField("age");
            // private String address;
            Field addressField = c.getDeclaredField("address");
            addressField.setAccessible(true); // 取消 Java 语言访问检查
            // 类的静态属性, 没有生命周期,进程结束才释放
            Field weathField = c.getDeclaredField("weath");
            weathField.setAccessible(true); // 取消 Java 语言访问检查
            // public final
            Field f5_Field = c.getDeclaredField("f5");
            f5_Field.setAccessible(true); // 取消 Java 语言访问检查
            System.out.println("f5_Field.getModifiers() :" + f5_Field.getModifiers());

            // 生成一个 Object 便于测试
            Person obj = new Person("TOM");

            System.out.println("----------- value 1-------------");
            // 取值
            System.out.println("name = " + nameField.get(obj));
            System.out.println("age = " + ageField.get(obj));
            System.out.println("address = " + addressField.get(obj));
            System.out.println("weath = " + weathField.get(null));
            System.out.println("f5 = " + f5_Field.get(obj));

            // 赋值
            ageField.set(obj, 23);
            // addressField.set(obj, "York");
            weathField.set(null, "150万");
            f5_Field.set(obj, 66);

            System.out.println("----------- value 2-------------");
            System.out.println("name = " + nameField.get(obj));
            System.out.println("age = " + ageField.get(obj));
            System.out.println("address = " + addressField.get(obj));
            System.out.println("weath = " + weathField.get(null));
            System.out.println("f5 = " + f5_Field.get(obj));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
