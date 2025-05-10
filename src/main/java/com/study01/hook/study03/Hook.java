package com.base.hook.study03;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Hook {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.base.hook.study03.Target");
        CtMethod ctMethod = cc.getDeclaredMethod("method1");

        // 打印传参数
        ctMethod.insertBefore("{System.out.println(\"args0 age:\" + $1.age);}");
        // 修改传入参数
        ctMethod.insertBefore("{$1.age = 20;}");

        // 打印返回值
        ctMethod.insertAfter("{System.out.println(\"ret:\" + $_.age);}");
        // 修改返回值
        ctMethod.insertAfter("{$_.age = 666;}");

        cc.toClass();

        Target target = new Target();
        Person person = new Person();
        person.age = 30;
        Person newPer = target.method1(person);
        System.out.println("ret from hook:" + newPer.age);
    }
}
