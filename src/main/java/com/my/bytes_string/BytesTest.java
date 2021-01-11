package com.my.bytes_string;

import java.util.Arrays;

public class BytesTest {
    public static void main(String[] args) {
        String test_str = "1qaz2wsx3edc";

        System.out.println("原始byte数据");
        byte[] test_bytes = test_str.getBytes();
        String test_bytes_str = Arrays.toString(test_bytes);
        System.out.println("test_bytes_str:\n" + test_bytes_str);

        System.out.println("转化成16进制,然后以字符串形式打印出来");
        String hex_str = BytesHexUtil.byteToHex(test_bytes);
        System.out.println("hex_str:\n" + hex_str);

        System.out.println("将16进制数据的字符串 还原成byte数组");
        byte[] bytes_str_2 = BytesHexUtil.hexToByte(hex_str);
        String test_bytes_str_2 = Arrays.toString(bytes_str_2);
        System.out.println("test_bytes_str_2:\n" + test_bytes_str_2);
    }
}
