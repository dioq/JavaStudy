package com.base.hook.study04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ProxyObject implements InvocationHandler {
    private final Object targetObject;

    public ProxyObject(Object target) {
        this.targetObject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 3. 自定义逻辑
        System.out.println("Before calling method: " + method.getName());

        // 4. 执行原始方法
        Object result = method.invoke(targetObject, args);

        // 3. 自定义逻辑
        System.out.println("After calling method: " + method.getName());

        return result;
    }
}