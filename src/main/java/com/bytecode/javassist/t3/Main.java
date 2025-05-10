package com.bytecode.javassist.t3;

import javassist.*;
public class Main {
    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        ClassPool classPool = ClassPool.getDefault();
        classPool.appendClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
        String clsName = "com.bytecode.javassist.t3.Test1";
        CtClass ctClass = classPool.get(clsName);
        CtMethod ctMethod = ctClass.getDeclaredMethod("sayHi");
        ctMethod.setBody("System.out.println(\"Hello world!\");");
        ctClass.toClass();
//        // 释放对象
//        ctClass.detach();
//        new Test1().sayHi();
    }
}
