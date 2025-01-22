package com.bytecode.javassist.t1;

import javassist.*;

import java.lang.*;

public class Test {
    public static void main(String[] args) throws Exception {
        new Test().test();
    }

    public void test() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
//        ClassPool cp = ClassPool.getDefault();
//        CtClass cc = cp.get("com.bytecode.javassist.t1.Hello");
//        // 获取say方法
//        CtMethod m = cc.getDeclaredMethod("say");
//        // 在方法第一行前面插入代码
//        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
//        Class c = cc.toClass();
//        Hello h = (Hello) c.newInstance();
//        h.say();
    }
}
