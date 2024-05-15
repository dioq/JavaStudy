package com.base.string;

public class Str_substring {
    public static void main(String[] args) {
        String tmp = "\u0007�0{\"sid\":\"w8TAZzvf6vatUGwXB5Qv\",\"upgrades\":[\"websocket\"],\"pingInterval\":20000,\"pingTimeout\":10000}";
        String ret = tmp.substring(3);
        System.out.println("ret : " + ret);
    }
}
