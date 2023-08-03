package com.my.hook.study02;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Hook {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.my.hook.study02.Target");
        CtMethod ctMethod = cc.getDeclaredMethod("method1");

        // 打印传参数
        ctMethod.insertBefore("System.out.println(\"args1:\" + $1 + \"\targs2:\" + $2);");
        // 修改传入参数
        ctMethod.insertBefore("{$1 = 100;}");

        // 打印返回值
        ctMethod.insertAfter("System.out.println(\"ret:\" + $_);");
        // 修改返回值
        ctMethod.insertAfter("{$_ = 666;}");

        cc.toClass();

        Target target = new Target();
        int ret = target.method1(10, "param2");
        System.out.println("ret from hook:" + ret);
    }
}
