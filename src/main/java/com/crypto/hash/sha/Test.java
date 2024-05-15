package com.crypto.hash.sha;


import static com.crypto.hash.sha.HmacUtil.hmacSha256;

public class Test {

    private static String plaintext = "thisisatest";

    public static void main(String[] args) {
        test2();
    }
    private static void test2() {
        String value = "";
        String result1 = hmacSha256(plaintext, value);
        System.out.println("result1:\n" + result1);
    }
}
