package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Member;

public class Member01 {
    public static void main(String[] args) {
        try {
            Class<?> clz = Class.forName("com.base.reflect.target.Person");

            Constructor<?> con = clz.getConstructor();
            System.out.println(con);
            Method method = clz.getMethod("method4", String.class);
            System.out.println(method);
            System.out.println("----------------------");
            test1(con);
            System.out.println("----------------------");
            test1(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test1(Member member) {
        System.out.println(member.getClass().getName());
        System.out.println(member.getDeclaringClass().getName());
        if (member.getClass().equals(Method.class)) {
            System.out.println("This is a method");
        } else if (member.getClass().equals(Constructor.class)) {
            System.out.println("This is a constructor");
        }
    }
}
