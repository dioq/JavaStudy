package com.my.reference;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ObjectTest07 {

    public static void changeValue(HttpURLConnection con) {
        System.out.println("changeValue : " + con.hashCode());
        con.setRequestProperty("User-Agent", "Android Client Agent");
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() throws IOException {
        URL url = new URL("https://www.anant.club:8081/getssl");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println("con : " + con.hashCode());
        changeValue(con);
        String agent = con.getRequestProperty("User-Agent");
        System.out.println("agent : " + agent);
    }
}
