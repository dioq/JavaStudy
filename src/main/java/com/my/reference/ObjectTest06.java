package com.my.reference;

public class ObjectTest06 {

    public static void changeValue(String str) {
        System.out.println("changeValue : " + str.hashCode());
        str = "new value";
    }

    public static void main(String[] args) {
        String str = "old value";
        System.out.println("str : " + str.hashCode());
        changeValue(str);
        System.out.println(str);
    }
}
