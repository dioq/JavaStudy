package com.crypto.RSA;

import java.util.Base64;

public class Test {

    public static void main(String[] args) {
        String plaintext = "This is a test string.";
        System.out.println("待加密字符串: " + plaintext);
        byte[] ciphertext = RSAUtil.encrypt(plaintext.getBytes());
        System.out.println("加密后：" + Base64.getEncoder().encodeToString(ciphertext));
        byte[] plaintext2 = RSAUtil.decrypt(ciphertext);
        System.out.println("解密后：" + new String(plaintext2));
    }

}
