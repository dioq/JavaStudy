package com.my.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo3 {
    //8、通过反射，创建对象，调用指定的private 方法
    /*
        1. 获取Class对象
    　　2. 获取构造方法
    　　3. 通过构造方法，创建对象
    　　4. 获取指定的方法
    　　5. 开启暴力访问
    　　6. 执行找到的方法
　　　　 public Object invoke(Object obj,  Object... args)   执行指定对象obj中，当前Method对象所代表的方法，方法要传入的参数通过args指定。
    * */
    public static void main(String[] args) {
        try {
            //1， 获取Class对象
            Class c = Class.forName("com.my.reflect.Person");
            //2,获取构造方法
            //public Person(String name, int age, String address){
            Constructor con = c.getConstructor(String.class, int.class, String.class);
            //3，通过构造方法，创建对象
            Object obj = con.newInstance("小明", 23, "哈尔滨");
            //4，获取指定的方法
            //private void method5(){
            Method m5 = c.getDeclaredMethod("method5", null);
            //5,开启暴力访问
            m5.setAccessible(true);
            //6，执行找到的方法
            m5.invoke(obj, null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
