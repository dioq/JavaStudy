package com.crypto.ECC;

import java.util.Base64;

public class Test {
    public static void main(String[] args) {
        // 明文
        String plainText = "This is a test string.";

        // 加密
        byte[] encryptedBytes = ECCUtil.getInstance().encrypt(plainText.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Text: " + encryptedText);

        // 解密
        byte[] decryptedBytes = ECCUtil.getInstance().decrypt(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
