package com.crypto.base64;

import java.util.Base64;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.system_test();
    }

    public void system_test() {
        String originalInput = "test input";
        // 编码
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println("encodedString:" + encodedString);

        // 解码
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("decodedString:" + decodedString);
    }
}
