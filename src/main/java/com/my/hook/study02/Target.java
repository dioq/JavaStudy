package com.my.hook.study02;

public class Target {

    public int method1(int p1, String p2) {
        String retVal = "p1:" + p1 + "\tp2:" + p2;
        System.out.println(retVal);
        return p1 +1;
    }
}
