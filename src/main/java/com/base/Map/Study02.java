package com.base.Map;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Study02 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Map<Method, String> map = new HashMap<>();
        try {
            Method m1 = Study02.class.getDeclaredMethod("func1");
            Method m2 = Study02.class.getDeclaredMethod("func2");

            map.put(m1, "1");
            map.put(m2, "2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Map.Entry<Method, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getName() + ":" + entry.getValue());
        }
    }

    public void func1() {
        System.out.println("func1");
    }

    public void func2() {
        System.out.println("func2");
    }
}
