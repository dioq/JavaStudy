package com.bytecode.javassist.t2;

import javassist.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        ClassPool pool = ClassPool.getDefault();
        Loader cl = new Loader(pool);

        CtClass ct = pool.get("test.Rectangle");
        ct.setSuperclass(pool.get("test.Point"));

        Class c = cl.loadClass("test.Rectangle");
        Object rect = c.getDeclaredConstructor().newInstance();
    }
}
