package com.base.reflect;

import java.lang.reflect.Method;

public class MethodInfo {
    public static void main(String[] args) throws Exception {
//            Method method = Person.class.getDeclaredMethod("method4", String.class);
//            new MethodInfo().test(method);
//            new MethodInfo().test1();
        test3();
    }

    public void test1() {
        String className = this.getClass().getName();
        System.out.println("className:" + className);
        className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("className:" + className);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("methodName:" + methodName);
        int lineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();
        System.out.println("lineNumber:" + lineNumber);
        String fileName = Thread.currentThread().getStackTrace()[1].getFileName();
        System.out.println("fileName:" + fileName);
    }

    public void test3(Method method) {
        // 获取类名
        String className = method.getDeclaringClass().getName();
        System.out.println("className:" + className);

        // 获取方法名
        String methodName = method.getName();
        System.out.println("methodName:" + methodName);

        Class<?>[] parameterTypes = method.getParameterTypes(); //获取参数类型
        System.out.println("参数类型:");
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clz = parameterTypes[i];
            System.out.println(i + " : " + clz);
        }
        System.out.println("返回类型:");
        Class<?> returnType = method.getReturnType(); // 获取返回类型
        System.out.println("returnType:" + returnType);

        // 获取类方法的修饰器
        /*
            修饰符在 Modifier 类中都被包装成一个 int 类型的数字，部分修饰符定义如下
            public static final int PUBLIC           = 0x00000001;
            public static final int PRIVATE          = 0x00000002;
            public static final int PROTECTED        = 0x00000004;
        **/
        int modifier = method.getModifiers();
        System.out.println("modifier:" + modifier);

        // 是不是 可变参数
        boolean varArgs = method.isVarArgs();
        System.out.println("varArgs:" + varArgs);
    }

    public static void test3() {
        int p1 = 10;
        String p2 = "abc";
        float p3 = (float) 3.14;

        Class<?>[] parameterTypes = getTypeByClassName(p1, p2, p3);
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clz = parameterTypes[i];
            System.out.println(i + " : " + clz);
        }
    }

    public static Class<?>[] getTypeByClassName(Object... args) {
        Class<?>[] parameterTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }
}
