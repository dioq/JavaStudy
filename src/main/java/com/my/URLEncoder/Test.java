package com.my.URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
    public static void main(String[] args) {
        try {
            String tmp = URLEncoder.encode("{\"signature\":\"bbb\"}", "utf-8");
            System.out.println(tmp);
            String tmp2 = URLDecoder.decode(tmp, "utf-8");
            System.out.println(tmp2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
