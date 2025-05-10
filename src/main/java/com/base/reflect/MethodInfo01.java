package com.base.reflect;

import java.lang.reflect.Method;

/*
 * 修饰符在 Modifier 类中都被包装成一个 int 类型的数字，部分修饰符定义如下
 * public static final int PUBLIC = 0x00000001;
 * public static final int PRIVATE = 0x00000002;
 * public static final int PROTECTED = 0x00000004;
 **/
public class MethodInfo01 {

    public void func1() {
        System.out.println("func1");
    }

    public int func2(int a, Integer b, String c) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        Method method1 = MethodInfo01.class.getDeclaredMethod("func1");
        Method method2 = MethodInfo01.class.getDeclaredMethod("func2",
                int.class, Integer.class, String.class);
        showInfo(method1);
        // showInfo(method2);
    }

    public static void showInfo(Method method) {
        // 获取类名
        String className = method.getDeclaringClass().getName();
        System.out.println("className:" + className);

        // className = method.getClass().getName();
        // System.out.println("className2:" + className);

        // 获取类方法的修饰器
        int modifier = method.getModifiers();
        System.out.println("modifier:" + modifier);

        Class<?> returnType = method.getReturnType(); // 获取返回类型
        System.out.println("returnType:" + returnType);

        // 获取方法名
        String methodName = method.getName();
        System.out.println("methodName:" + methodName);

        Class<?>[] parameterTypes = method.getParameterTypes(); // 获取参数类型
        System.out.println("parameterTypes:" + method.getParameterTypes().length);
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clz = parameterTypes[i];
            String msg = String.format("parameterTypes[%d]:%s", i, clz.getName());
            System.out.println(msg);
        }

        // 是不是 可变参数
        boolean varArgs = method.isVarArgs();
        System.out.println("varArgs:" + varArgs);
    }
}
