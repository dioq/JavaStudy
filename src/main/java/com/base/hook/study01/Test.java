package com.base.hook.study01;

import javassist.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.base.hook.study01.Hello");
        CtMethod personFly = cc.getDeclaredMethod("say");

        personFly.insertBefore("System.out.println(\"执行方法之前\");");
        personFly.insertAfter("System.out.println(\"执行方法之后\");");
        cc.toClass();

        Hello.say();
    }
}
