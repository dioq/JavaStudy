package com.base.proxy.dynamic_proxy;

import com.base.proxy.Shopping;
import com.base.proxy.ShoppingImpl;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TestDynamic {
    public static void main(String[] args) {
        Shopping women = new ShoppingImpl();

        // 正常购物
        System.out.println(Arrays.toString(women.doShopping(100)));
        System.out.println("==============================================");
//        System.out.println(Shopping.class);
//        System.out.println(ShoppingImpl.class);
//        System.out.println(women.getClass());
        // 动态代理
        women = (Shopping) Proxy.newProxyInstance(
                women.getClass().getClassLoader(),
                women.getClass().getInterfaces(),
                new ShoppingHandler(women));

        System.out.println(Arrays.toString(women.doShopping(100)));
    }
}
