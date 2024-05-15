package com.crypto.DES;

public class Test {

    public static void main(String[] args) {
        String plaintext = "This is a test string.";
        System.out.println("待加密字符串: " + plaintext);
        String ciphertext = DESUtil.encrypt(plaintext);
        System.out.println("加密后：" + ciphertext);
        String plaintext2 = DESUtil.decrypt(ciphertext);
        System.out.println("解密后：" + plaintext2);
    }

}
