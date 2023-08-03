package com.my.hook;

import javassist.*;

public class Javassist {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.my.hook.Hello");
        CtMethod personFly = cc.getDeclaredMethod("say");
        personFly.insertBefore("System.out.println(\"执行方法之前\");");
        personFly.insertAfter("System.out.println(\"执行方法之后\");");
        cc.toClass();

        Hello.say();
    }
}
