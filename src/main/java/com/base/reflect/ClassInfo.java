package com.base.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ClassInfo {

    /*
    修饰符在 Modifier 类中都被包装成一个 int 类型的数字，部分修饰符定义如下
    public static final int PUBLIC           = 0x00000001;
    public static final int PRIVATE          = 0x00000002;
    public static final int PROTECTED        = 0x00000004;
    */
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        try {
            Class<?> cla = Class.forName("com.base.reflect.target.UserServiceImpl");
            int modifyInt = cla.getModifiers();
            System.out.println(modifyInt);

            //getPackage 方法获取类的包相关信息
            Package packageClazz = cla.getPackage();
            System.out.println(packageClazz.getName());

            // 通过反射获取类的父类
            Class<?> superclass = cla.getSuperclass();
            System.out.println(superclass.getName());

            // 通过反射获取类的实现接口
            Class<?>[] interfaces = cla.getInterfaces();
            System.out.println(Arrays.toString(interfaces));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            Class<?> cla = Class.forName("com.base.reflect.target.ReflectGenericDemo");
//            Method method = cla.getMethod("getStringList", (Class<?>) null);
            Method method = cla.getDeclaredMethod("getStringList", null);
            // 返回值 的泛型类型
            Type returnType = method.getGenericReturnType();
            if (returnType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for (Type typeArgument : typeArguments) {
                    System.out.println(typeArgument);
//                    Class<?> typeArgumentClass = (Class<?>) typeArgument;
//                    System.out.println(typeArgumentClass);
                }
            }
            System.out.println("---------------- 返回值 的泛型类型 ----------------");
            Method method2 = cla.getDeclaredMethod("setStringList", List.class);
            // 参数的泛型类型
            Type[] genericParameterTypes = method2.getGenericParameterTypes();
            for (Type genericParameterType : genericParameterTypes) {
                if (genericParameterType instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                    Type[] parameterArgTypes = parameterizedType.getActualTypeArguments();
                    for (Type parameterArgType : parameterArgTypes) {
                        System.out.println(parameterArgType);
//                        Class parameterArgClass = (Class) parameterArgType;
//                        System.out.println("parameterArgClass = " + parameterArgClass);
                    }
                }
            }
            System.out.println("---------------- 参数 的泛型类型 ----------------");
            // 泛型变量类型
            Field field = cla.getDeclaredField("stringList");
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType) {
                ParameterizedType fieldGenericType = (ParameterizedType) type;
                Type[] fieldGenericTypes = fieldGenericType.getActualTypeArguments();
                for (Type genericType : fieldGenericTypes) {
                    System.out.println(genericType);
//                    Class fieldGenericTypeClass = (Class) genericType;
//                    System.out.println(fieldGenericTypeClass);
                }
            }
            System.out.println("---------------- 泛型变量类型 ----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
