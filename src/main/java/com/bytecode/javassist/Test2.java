package com.bytecode.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Test2 {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.bytecode.javassist.Hello");
        // 获取say方法
        CtMethod m = cc.getDeclaredMethod("say");
        // 在方法第一行前面插入代码
        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        Class c = cc.toClass();
        Hello h = (Hello)c.getDeclaredConstructor().newInstance();
        h.say();
    }
}
