package com.my.network.SSLUtil;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class MyHostnameVerifier implements HostnameVerifier {

    //服务器绑定的域名
    private static String host = "www.anant.club";

    @Override
    public boolean verify(String hostname, SSLSession session) {
//        if (host.equals(hostname)) {//判断域名是否和证书域名相等(不需要验证可以关掉)
//            return true;
//        } else {
//            return false;
//        }
        return true;
    }

}
