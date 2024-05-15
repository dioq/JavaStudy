package com.crypto.AES;

public class Test {
    public static void main(String[] args) {
        String plaintext = "This is a test string.";
        String ciphertext = AESUtils.encrypt(plaintext);
        System.out.println("ciphertext:\n" + ciphertext);
        String plaintext2 = AESUtils.decrypt(ciphertext);
        System.out.println("plaintext2:\n" + plaintext2);
    }
}
