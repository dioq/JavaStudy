package com.my.proxy.dynamic_proxy;

import com.my.proxy.Shopping;
import com.my.proxy.ShoppingImpl;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TestDynamic {
    public static void main(String[] args) {
        Shopping women = new ShoppingImpl();

        // 正常购物
        System.out.println(Arrays.toString(women.doShopping(100)));
        System.out.println("==============================================");
        // 招代理
        women = (Shopping) Proxy.newProxyInstance(
                Shopping.class.getClassLoader(),
                women.getClass().getInterfaces(),
                new ShoppingHandler(women));

        System.out.println(Arrays.toString(women.doShopping(100)));
    }
}
