package com.my.network.study03;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

    private static Test test = new Test();

    public static void main(String[] args) {
        SSLConfig.set(SSLTrustWhich.TrustAll);
        test.get_func();
//        test.post_func();
    }

    public void get_func() {
        String urlStr = "https://www.anant.club:8081/getssl";
        String response = new NetworkUtil().doGet(urlStr);
        System.out.println("get_tls_func response:\n" + response);
    }

    public void post_func() {
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
        String response = new NetworkUtil().doPost(urlStr, requestData);
        System.out.println("post_tls_func response:\n" + response);
    }

}
