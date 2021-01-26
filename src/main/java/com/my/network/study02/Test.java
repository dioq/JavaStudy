package com.my.network.study02;

import com.my.network.SSLUtil.SSLTrustWhich;
import org.json.JSONException;
import org.json.JSONObject;
import com.my.network.SSLUtil.SSLConfig;

public class Test {

    public static void main(String[] args) {
        SSLConfig.set(SSLTrustWhich.TrustAll);
//        get_func();
        post_func();
    }

    public static void get_func() {
        String urlStr = "https://www.anant.club:8081/getssl";
        String response = new NetworkUtil().doGet(urlStr);
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
        String response = new NetworkUtil().doPost(urlStr, requestData);
        System.out.println("post_tls_func response:\n" + response);
    }

}
