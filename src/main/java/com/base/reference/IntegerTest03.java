package com.base.reference;

public class IntegerTest03 {
    private static void changeInteger(Integer value) {
        ++value;
    }

    public static void main(String[] args) {
        Integer a = 1;
        changeInteger(a);
        System.out.println("a = " + a);
    }
}
