package com.my.network_proxy.study02.proxy;

import com.google.gson.Gson;
import com.my.network_proxy.study02.proxy.model.Obj;
import com.my.network_proxy.study02.proxy.model.ProxyRoot;

import static com.my.network_proxy.study02.proxy.netutil.HttpUtil.httpRequest;

public class ProxyUtil {

    //动态代理 获取地址
    private static String proxy_resource_url = "http://route.xiongmaodaili.com/xiongmao-web/api/glip?secret=e9487221405fcbd530cc5a4ccb0f33e1&orderNo=GL20201202201117G50veWgu&count=1&isTxt=0&proxyType=1";
    //检查代理是否设置成功(访问这个网站可以查看当前代理地址)
    private static String proxy_check_url = "http://www.ip111.cn";

    private static String ip = null;//获取到的ip
    private static String port = null;//获取到的端口

    public static boolean proxy_check() {
        proxy_set();
        if (ip == null || port == null) {
            return false;
        }
        String response = httpRequest(proxy_check_url, "GET", null);
        System.out.println("proxy_check :\n" + response);
        /*
         * 如果返回的html里包含 之前设置的ip,那动态代理就设置成功了。否则就没设置成功
         * */
        return response.contains(ip);
    }

    private static void proxy_set() {
        get_dynamic_proxy();
        if (ip != null && port != null) {
            /*
             * 注意:
             * 如果动态IP错误，会以本机网络IP访问。如果端口错误，会报错。
             * */
            System.setProperty("http.maxRedirects", "50");
            System.getProperties().setProperty("proxySet", "true");
            System.getProperties().setProperty("http.proxyHost", ip);
            System.getProperties().setProperty("http.proxyPort", port);
        }
    }

    //动态获取代理地址
    private static void get_dynamic_proxy() {
        String s = httpRequest(proxy_resource_url, "GET", null);
        System.out.println("get_dynamic_proxy :\n" + s);
        Gson gson = new Gson();
        ProxyRoot proxyRoot = gson.fromJson(s, ProxyRoot.class);
        if (proxyRoot.getCode().equals("0")) {
            Obj obj = proxyRoot.getObj().get(0);
            ip = obj.getIp();
            port = obj.getPort();
            System.out.println(ip + " : " + port);
        } else {
            ip = null;
            port = null;
            System.out.println("failture : " + proxyRoot.getMsg());
        }
    }

}
