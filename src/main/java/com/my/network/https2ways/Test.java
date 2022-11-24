package com.my.network.https2ways;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {
//        get_func();
        post_func();
    }

    public static void get_func() {
        String urlStr = "https://jobs8.cn:8092/get";
        String response =  HttpsUtil.getInstance().doGet(urlStr);
        System.out.println("get_tls_func response:\n" + response);
    }

    public static void post_func() {
        String urlStr = "https://jobs8.cn:8092/post";
        JSONObject param_json = new JSONObject();
        try {
            param_json.put("name", "Dio");
            param_json.put("age", 18);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String requestData = param_json.toString();
        String response = HttpsUtil.getInstance().doPost(urlStr, requestData);
        System.out.println("post_tls_func response:\n" + response);
    }

}
