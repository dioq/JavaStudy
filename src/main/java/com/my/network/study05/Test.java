package com.my.network.study05;

import com.my.network.SSLUtil.SSLTrustWhich;
import org.json.JSONException;
import org.json.JSONObject;
import com.my.network.SSLUtil.SSLConfig;

public class Test {

    public static void main(String[] args) {
        get_func();
        get_tls_oneway();
        get_tls_twoway();
    }

    public static void get_func() {
        String urlStr = "http://jobs8.cn:8081/getdata";
        String response = new NetworkUtil().doGet(urlStr);
        System.out.println("http_test response:\n" + response);
    }

    // 单向验证
    public static void get_tls_oneway() {
        SSLConfig.set(SSLTrustWhich.TrustMeOneway);
        String urlStr = "https://jobs8.cn:8082/getdata";
        String response = new NetworkUtil().doGet(urlStr);
        System.out.println("get_tls_oneway response:\n" + response);
    }

    // 双向验证
    public static void get_tls_twoway() {
        SSLConfig.set(SSLTrustWhich.TrustMeTwoway);
        String urlStr = "https://jobs8.cn:8083/getdata";
        String response = new NetworkUtil().doGet(urlStr);
        System.out.println("tls_twoway response:\n" + response);
    }

}
