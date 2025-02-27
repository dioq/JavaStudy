package com.base.DataStruct.bytes;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String hex_str = "1234567890abcdef1234567890abcdef";

        System.out.println("将16进制数据的字符串 还原成byte数组");
        byte[] bytes = DataFormatUtil.hexToByte(hex_str);
        String test_bytes_str_2 = Arrays.toString(bytes);
        System.out.println("bytes:\n" + test_bytes_str_2);

        System.out.println("转化成16进制,然后以字符串形式打印出来");
        hex_str = DataFormatUtil.byteToHex(bytes);
        System.out.println("hex:\n" + hex_str);
    }
}
