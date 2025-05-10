package com.base.URLEncoder;

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

            String tmp3 = URLDecoder.decode("%3A%2F%2F", "utf-8");
            System.out.println(tmp3);
            String tmp4 = URLDecoder.decode("%3Fid%3D", "utf-8");
            System.out.println(tmp4);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
