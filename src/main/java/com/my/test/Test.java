package com.my.test;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,4};
        System.out.println(a.getClass());
        System.out.println(a.getClass().getComponentType());
    }
}
