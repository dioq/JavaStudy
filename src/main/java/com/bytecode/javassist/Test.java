package com.bytecode.javassist;

import javassist.*;

import java.io.File;

public class Test {
    private static final String clsDir = "/Users/lzd/repository/JavaStudy/src/main/java/";
    public static void main(String[] args)  {
        try {
            File file = new File(clsDir,"com/base/javassist/out");
            if (file.exists()) {
                file.delete();
            }
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() throws Exception {
        // 获取javassist默认类池
        ClassPool pool = ClassPool.getDefault();
        // 创建Hello类
        CtClass ctClass = pool.makeClass("com.bytecode.javassist.out.Hello");
        // 创建main方法
        CtMethod ctMethod = CtNewMethod.make("public static void main(String[] args){System.out.println(\"Hello world\");}", ctClass);
        // 将方法添加到ctClass中
        ctClass.addMethod(ctMethod);
        // 将类写成文件
        ctClass.writeFile(clsDir);

        // 获取生成后类的class文件
//        ctClass.defrost();//ctClass.toClass();
//        Class<?> Hello = ctClass.toClass();
        // 实例化生成后的类
//        Object hello = helloClazz.newInstance();
//        // 调用生成后的类的main方法
//        Method main = helloClazz.getDeclaredMethod("main",String[].class);
//        // 调用生成的main方法
//        main.invoke(hello,(Object) new String[0]);
    }
}
