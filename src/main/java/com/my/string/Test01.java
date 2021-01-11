package com.my.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String strUtf8 = "abc123测试";    //utf8字符串
        byte[] strGbkBytes = strUtf8.getBytes("GBK");    //获取GBK格式的数组
        System.out.println("GBK  bytes: " + Arrays.toString(strGbkBytes));
        byte[] strUtf8Bytes = strUtf8.getBytes("UTF-8");    //获取UTF8格式的数组
        System.out.println("UTF8 bytes: " + Arrays.toString(strUtf8Bytes));
//文字和编码一致
        String strGbk = new String(strGbkBytes, "GBK");    //告诉String,strGbkBytes的数据时GBK格式
        byte[] strGbkBytes1 = strGbk.getBytes("GBK");  //获取GBK格式的数组
        System.out.println("GBK1 bytes: " + Arrays.toString(strGbkBytes1));
//文字和编码不一致
        String strGbk2 = new String(strGbkBytes, "UTF-8"); //告诉String,strGbkBytes的数据时UTF-8格式
        byte[] strGbkBytes2 = strGbk2.getBytes("GBK"); //获取GBK格式的数组
        System.out.println("GBK2 bytes: " + Arrays.toString(strGbkBytes2));
    }
}
