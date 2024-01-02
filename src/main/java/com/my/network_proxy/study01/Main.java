package com.my.network_proxy.study01;

import com.google.gson.Gson;
import com.my.network_proxy.study01.model.Obj;
import com.my.network_proxy.study01.model.ProxyRoot;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import static com.my.network_proxy.study01.HttpUtil.httpRequest;

public class Main {

    /*
     * 注意:
     * 如果动态IP错误，会以本机网络IP访问。如果端口错误，会报错。
     * */

    public static void main(String[] args) {
//        set_proxy();
        get_dynamic_proxy();
    }

    //设置以指定代理访问网络(ip必须是有效的,否则就以本机ip访问)
    private static void set_proxy() {
        System.setProperty("http.maxRedirects", "50");
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
        System.getProperties().setProperty("proxySet", "true");

        String ip = "119.183.211.194";
        String port = "9020";
        System.getProperties().setProperty("http.proxyHost", ip);
        System.getProperties().setProperty("http.proxyPort", port);

        //确定代理是否设置成功
        String result = getHtml("http://www.ip111.cn/");
        System.out.println(result);
    }

    //动态获取代理地址
    private static void get_dynamic_proxy() {
        String urlStr = "http://route.xiongmaodaili.com/xiongmao-web/api/glip?secret=0669093de4b211ea65933ba3ca79bcbe&orderNo=GL20201126004658vSwZe7jx&count=1&isTxt=0&proxyType=1";
        String s = httpRequest(urlStr, "GET", null);
        System.out.println(s);

        Gson gson = new Gson();
        ProxyRoot proxyRoot = gson.fromJson(s, ProxyRoot.class);
        if (proxyRoot.getCode().equals("0")) {
            Obj obj = proxyRoot.getObj().get(0);
            System.out.println(obj.getIp() + " : " + obj.getPort());

            System.setProperty("http.maxRedirects", "50");
            // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
            System.getProperties().setProperty("proxySet", "true");

            String ip = obj.getIp();
            String port = obj.getPort();
            System.getProperties().setProperty("http.proxyHost", ip);
            System.getProperties().setProperty("http.proxyPort", port);
        } else {
            System.out.println("failture : " + proxyRoot.getMsg());
        }

        //确定代理是否设置成功
        String result = getHtml("http://www.ip111.cn/");
        System.out.println(result);
    }

    private static String getHtml(String address) {
        StringBuffer html = new StringBuffer();
        String result = null;
        try {
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

            try {
                String inputLine;
                byte[] buf = new byte[4096];
                int bytesRead = 0;
                while (bytesRead >= 0) {
                    inputLine = new String(buf, 0, bytesRead, "utf-8");
                    html.append(inputLine);
                    bytesRead = in.read(buf);
                    inputLine = null;
                }
                buf = null;
            } finally {
                in.close();
                conn = null;
                url = null;
            }
            result = new String(html.toString().trim().getBytes("utf-8"), "utf-8").toLowerCase();
            FileUtils.write_to_localFile(result, "src/main/resources/html/show.html");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            html = null;
        }
        return result;
    }
}
