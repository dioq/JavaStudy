package com.my.network.study01;

public class Test {
    public static void main(String[] args) {
        NetworkUtil networkUtil = new NetworkUtil();
        String urlStr = "http://www.anant.club:8848/getTest";
        String result = networkUtil.doGet(urlStr);
        System.out.println(result);
    }
}
