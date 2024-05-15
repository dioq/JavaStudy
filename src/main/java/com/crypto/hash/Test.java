package com.crypto.hash;

public class Test {

    private static String plaintext = "thisisatest";

    public static void main(String[] args) {
        Test test = new Test();
//        test.testMD5();
        test.testSHA();
    }

    public void testMD5() {
        String ciphertext = HashUtil.md5(plaintext);
        System.out.println("result:\n" + ciphertext);
    }

    public void testSHA() {
        String ciphertext = HashUtil.sha256(plaintext);
        System.out.println("result:\n" + ciphertext);
    }
}
