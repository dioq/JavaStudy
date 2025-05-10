package com.base.hook.study04;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // 1. 获取目标对象
        TargetObject target = new TargetObject();

        // 2. 创建代理对象
        ProxyObject proxy = new ProxyObject(target);

        // 5. 替换机制 - 使用动态代理
        DoTask proxyTarget = (DoTask) Proxy.newProxyInstance(
                TargetObject.class.getClassLoader(),
                TargetObject.class.getInterfaces(),
                proxy
        );

        // 调用目标对象
        proxyTarget.doSomething();

        // 5. 恢复机制 (可选)
        // 在某些情况下，可能需要将目标对象恢复到原来的状态
    }
}
