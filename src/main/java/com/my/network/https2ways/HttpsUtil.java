package com.my.network.https2ways;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;

/*
 * https 双向验证
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

    private static final String CLIENT_CERT = "client.p12";//客户端证书
    private static final String CLIENT_CERTT_PASSWORD = "zxcvbnm,.";// 加载证书的密码
    private static final String SERVER_CERT = "server.jks";// 本地保存的服务器证书,https交换证书后 与服务器传来的证书作对比
    private static final String SERVER_CERT_PASSWORD = "zxcvbnm,.";// 加载证书的密码
    // 证书所在的文件的路径
    private static final String prefix_path = "src/main/resources/cert/";

    // 配置 SSL 验证模式, https 单向验证
    private void setHttpsConfig() {
        try {
            // 客户端证书
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            InputStream ksIn = Files.newInputStream(Paths.get(prefix_path + CLIENT_CERT));
            keyStore.load(ksIn, CLIENT_CERTT_PASSWORD.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, CLIENT_CERTT_PASSWORD.toCharArray());
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
            ksIn.close();

            // 服务端证书
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream tsIn = Files.newInputStream(Paths.get(prefix_path + SERVER_CERT));
            trustStore.load(tsIn, SERVER_CERT_PASSWORD.toCharArray());
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm);
            trustManagerFactory.init(trustStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            tsIn.close();

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagers, trustManagers, new SecureRandom());

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
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException | IOException | UnrecoverableKeyException e) {
            throw new RuntimeException(e);
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
