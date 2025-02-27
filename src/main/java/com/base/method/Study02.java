package com.base.method;

import java.lang.reflect.Method;

public class Study02 {
    public static void main(String[] args) throws Exception {
        // Method method = MethodInfo.class.getDeclaredMethod("func2", int.class,
        // Integer.class, String.class);
        // test2(method);
        // test3();
        // test4();
        // new MethodInfo().test1();
        test10();
    }

    public static void test10() {
        Object[] obj = new Object[] { 1, 2, 3 };
        Class<?> clz = obj.getClass().getComponentType();// 获取数组的元素类型
        System.out.println("className:" + clz.getName());
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

    public static void test2(Method method) {
        // 获取类名
        String className = method.getDeclaringClass().getName();
        System.out.println("className:" + className);

        // 获取方法名
        String methodName = method.getName();
        System.out.println("methodName:" + methodName);

        Class<?>[] parameterTypes = method.getParameterTypes(); // 获取参数类型
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
         * 修饰符在 Modifier 类中都被包装成一个 int 类型的数字，部分修饰符定义如下
         * public static final int PUBLIC = 0x00000001;
         * public static final int PRIVATE = 0x00000002;
         * public static final int PROTECTED = 0x00000004;
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

    public static void test4() throws NoSuchMethodException {
        Method method = Study02.class.getDeclaredMethod("func");
        Class<?>[] parameterTypes = method.getParameterTypes(); // 获取参数类型
        System.out.println("参数类型:");
        if (parameterTypes == null || parameterTypes.length == 0) {
            return;
        }
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clz = parameterTypes[i];
            System.out.println(i + " : " + clz);
        }
    }

    public static void test5() throws NoSuchMethodException {
        Method method = Study02.class.getDeclaredMethod("func");
        Method method2 = Study02.class.getDeclaredMethod("func2", int.class, Integer.class, String.class);
        Class<?>[] pTypes1 = method.getParameterTypes();
        if (method.getParameterTypes().length == 0) {
            System.out.println("is empty");
        }
        show(pTypes1);
        System.out.println("===============");
        Class<?>[] pTypes2 = method2.getParameterTypes();
        show(pTypes2);
    }

    public static void show(Class<?>[] parameterTypes) {
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clz = parameterTypes[i];
            System.out.println(i + " : " + clz);
        }
    }

    public int func() {
        return 10;
    }

    public int func2(int a, Integer b, String c) {
        return a + b;
    }
}
