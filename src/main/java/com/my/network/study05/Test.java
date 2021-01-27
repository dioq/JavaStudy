package com.my.network.study05;

import com.my.network.SSLUtil.SSLTrustWhich;
import org.json.JSONException;
import org.json.JSONObject;
import com.my.network.SSLUtil.SSLConfig;

public class Test {

    public static void main(String[] args) {
//        SSLConfig.set(SSLTrustWhich.TrustMeOneway);
//        get_func();
//        post_func();
        get_tls_oneway();
        get_tls_twoway();
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

    // 单向验证
    public static void get_tls_oneway() {
        SSLConfig.set(SSLTrustWhich.TrustMeOneway);
        String urlStr = "https://www.anant.club:8082/getdata";
        String response = new NetworkUtil().doGet(urlStr);
        System.out.println("get_tls_oneway response:\n" + response);
    }

    // 双向验证
    public static void get_tls_twoway() {
        SSLConfig.set(SSLTrustWhich.TrustMeTwoway);
        String urlStr = "https://www.anant.club:8083/getdata";
        String response = new NetworkUtil().doGet(urlStr);
        System.out.println("tsl_twoway response:\n" + response);
    }

}
