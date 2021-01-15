package com.my.network.study04;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {
        SSLConfig.set(SSLTrustWhich.TrustAll);
//        get_http_func();
//        get_https_func();
        post_func();
    }

    public static void get_http_func() {
        NetworkUtil networkUtil = new NetworkUtil(true);
//        String urlStr = "http://test.abuyun.com/";
        String urlStr = "http://www.anant.club:8848/getTest";
        String result = networkUtil.doGet(urlStr);
        System.out.println(result);
    }

    public static void get_https_func() {
        String urlStr = "https://www.anant.club:8081/getssl";
        String response = new NetworkUtil(true).doGet(urlStr);
        System.out.println("get_tls_func response:\n" + response);
    }

    public static void post_func() {
        String urlStr = "https://www.anant.club:8081/postssl";
        JSONObject param_json = new JSONObject();
        try {
            param_json.put("username", "Dio");
            param_json.put("password", "13131313");
            param_json.put("argot", "You are geat!");
            param_json.put("num", 1111);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String requestData = param_json.toString();
        String response = new NetworkUtil(true).doPost(urlStr, requestData);
        System.out.println("post_tls_func response:\n" + response);
    }

}
