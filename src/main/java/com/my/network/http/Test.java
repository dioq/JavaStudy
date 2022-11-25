package com.my.network.http;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {
//        get();
//        post();
//      post2();
        upload();
    }

    private static void get() {
        String urlStr = "http://jobs8.cn:8090/get?name=dio&age=100";
        String result = HttpUtil.getInstance().doGet(urlStr);
        System.out.println(result);
    }

    private static void post() {
        String urlStr = "http://jobs8.cn:8090/post";
        JSONObject param_json = new JSONObject();
        try {
            param_json.put("name", "Dio");
            param_json.put("age", 18);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String requestData = param_json.toString();
        String result = HttpUtil.getInstance().doPost(urlStr, requestData);
        System.out.println(result);
    }

    private static void post2() {
        String urlStr = "http://jobs8.cn:8090/post?name=JOJO&age=18";
        JSONObject param_json = new JSONObject();
        try {
            param_json.put("name", "Dio");
            param_json.put("age", 18);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String requestData = param_json.toString();
        String result = HttpUtil.getInstance().doPost(urlStr, requestData);
        System.out.println(result);
    }

    private static void upload() {
        String urlStr = "http://jobs8.cn:8090/upload";
        String filePath = "src/main/resources/images/001.jpeg";
        String result = HttpUtil.getInstance().uploadFile(urlStr,filePath);
        System.out.println(result);
    }
}
