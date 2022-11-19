package com.my.base64;

import java.util.Base64;

public class main {
    public static void main(String[] args) {
        String originalInput = "test input";
        // 编码
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println("encodedString:" + encodedString);

        // 解码
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("decodedString:"+decodedString);
    }
}
