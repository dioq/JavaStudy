package com.base.reference;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ObjectTest08 {

    public static HttpURLConnection changeValue(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Android Client Agent");
        System.out.println("changeValue  con : " + con.hashCode());
        return con;
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() throws IOException {
        String urlStr = "https://www.anant.club:8081/getssl";
        HttpURLConnection con = changeValue(urlStr);
        System.out.println("test  con : " + con.hashCode());
        String agent = con.getRequestProperty("User-Agent");
        System.out.println("agent : " + agent);
    }
}
