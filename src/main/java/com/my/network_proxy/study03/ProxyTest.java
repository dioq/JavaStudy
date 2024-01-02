package com.my.network_proxy.study03;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.*;

/**
 * 注意：下面代码仅仅实现HTTP请求链接，每一次请求都是无状态保留的，仅仅是这次请求是更换IP的，如果下次请求的IP地址会改变
 * 如果是多线程访问的话，只要将下面的代码嵌入到你自己的业务逻辑里面，那么每次都会用新的IP进行访问，如果担心IP有重复，
 * 自己可以维护IP的使用情况，并做校验。
 * <p>
 * JDK 8u111版本后环境下：要访问的目标页面为HTTPS协议时，需修改“jdk.http.auth.tunneling.disabledSchemes”值
 */
public class ProxyTest {
    public static void main(String args[]) throws Exception {
        // 要访问的目标页面
        String targetUrl = "http://test.abuyun.com";

        // JDK 8u111版本后，目标页面为HTTPS协议，启用proxy用户密码鉴权
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");

        // 代理服务器
        String proxyServer = "http-dyn.abuyun.com";
        int proxyPort = 9020;

        // 代理隧道验证信息
        String proxyUser = "HW5RE145V8V4756D";
        String proxyPass = "4B2FDEB625EBB5EE";

        try {
            URL url = new URL(targetUrl);

            Authenticator.setDefault(new ProxyAuthenticator(proxyUser, proxyPass));

            // 创建代理服务器地址对象
            InetSocketAddress addr = new InetSocketAddress(proxyServer, proxyPort);
            // 创建HTTP类型代理对象
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

            // 设置通过代理访问目标页面
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

            // 解析返回数据
            byte[] response = readStream(connection.getInputStream());

            System.out.println(new String(response));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 将输入流转换成字符串
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;

        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();

        return outSteam.toByteArray();
    }

}