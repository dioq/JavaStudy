package com.my.proxy.static_proxy;

import com.my.proxy.Shopping;
import com.my.proxy.ShoppingImpl;

import java.util.Arrays;

public class TestStatic {
    public static void main(String[] args) {
        // 原始的厂家
        Shopping women = new ShoppingImpl();

        System.out.println(Arrays.toString(women.doShopping(100)));
        System.out.println("==============================================");
        // 换成代购
        women = new ProxyShopping(women);
        System.out.println(Arrays.toString(women.doShopping(100)));
    }
}
