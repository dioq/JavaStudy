package com.my.network.https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;

/*
 * https 单向认证
 * */
public class HttpsUtil {

    private static HttpsUtil instance;

    //构造器私有化
    private HttpsUtil() {
    }

    //方法同步，调用效率低
    public static synchronized HttpsUtil getInstance() {
        if (instance == null) {
            instance = new HttpsUtil();
            instance.setHttpsConfig();
        }
        return instance;
    }

    // 配置 SSL 验证模式, https 单向验证
    private void setHttpsConfig() {
        try {
            TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new SecureRandom());

            //将证书工厂 配置到 HttpsURLConnection
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            //验证域名
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    String hostname = "jobs8.cn";
                    return s.equals(hostname);
                }
            });
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * GET 请求
     *
     * @param urlStr 请求接口
     */
    public String doGet(String urlStr) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            URL url = new URL(urlStr);
            //https.setHostnameVerifier(DO_NOT_VERIFY); //不验证域名是否和证书域名相等
            connection = (HttpsURLConnection) url.openConnection();

            connection.setConnectTimeout(8000);//连接最大时间
            connection.setReadTimeout(8000);//读取最大时间
            connection.setRequestMethod("GET");
            //处理返回信息
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream(); //获取网络输入流 in
                reader = new BufferedReader(new InputStreamReader(in)); //转换成BufferedReader
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = response.toString();
            } else {//网络请求错误时
                result = "network is failed.  " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

    /**
     * POST           restful接口        application/json
     *
     * @param urlStr 请求接口
     * @param param  参数
     */
    public String doPost(String urlStr, String param) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            URL url = new URL(urlStr);
            //https.setHostnameVerifier(DO_NOT_VERIFY); //不验证域名是否和证书域名相等
            connection = (HttpsURLConnection) url.openConnection();
            connection.setConnectTimeout(8000);//连接最大时间
            connection.setReadTimeout(8000);//读取最大时间
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestMethod("POST");
            //--------------------------------
            connection.setDoOutput(true);//是否写入参数
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(param.getBytes());//把参数的二进制格式 直接写入到网络输出流outputStream中
            //--------------------------------
            //处理返回信息
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();//获取网络输入流 in
                reader = new BufferedReader(new InputStreamReader(in)); //转换成BufferedReader
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = response.toString();
            } else {
                result = "network is failed.  " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

}
