package com.my.network.SSLUtil;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class SSLConfig {

    public static void set(SSLTrustWhich type) {
        SSLSocketFactory sslSocketFactory = null;
        switch (type) {
            case TrustAll:
                sslSocketFactory = getAllSSLSocketFactory();
                break;
            case TrustMeOneway:
                sslSocketFactory = getOnewaySSLContextFactory();
                break;
            case TrustMeTwoway:
                sslSocketFactory = getTwowaySSLContextFactory();
                break;
        }

        //将证书工厂 配置到 HttpsURLConnection
        HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
        //验证域名
        HttpsURLConnection.setDefaultHostnameVerifier(new MyHostnameVerifier());
    }

    // 信任所有服务器的证书(单向验证,只验证服务器)
    private static synchronized SSLSocketFactory getAllSSLSocketFactory() {
        try {
            // 生成 TrustManagerFactory
            TrustManager[] trustManagers = new TrustManager[]{new MyTrustManager()};

            // Create an SSLContext that uses our TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    private static String KEY_STORE_TRUST_PATH2 = "cert.pem";

    // 信任自己放在本地的服务器证书(单向验证,只验证服务器)
    private static synchronized SSLSocketFactory getOnewaySSLContextFactory() {
        FileInputStream inputStream = null;
        String prefix_path = "src/main/resources/crt/";
        try {
            // 生成 TrustManagerFactory
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            inputStream = new FileInputStream(prefix_path + KEY_STORE_TRUST_PATH2);//这里导入SSL证书文件
            Certificate ca = certificateFactory.generateCertificate(inputStream);
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(null, null);
            keystore.setCertificateEntry("ca", ca);
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm);
            trustManagerFactory.init(keystore);

            // Create an SSLContext that uses our TrustManager
            SSLContext s_sSLContext = SSLContext.getInstance("TLS");
            s_sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            return s_sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | CertificateException | IOException e) {
            e.printStackTrace();
            throw new AssertionError();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static final String KEY_STORE_TYPE_BKS = "bks";//证书类型 固定值
    private static final String KEY_STORE_TYPE_P12 = "PKCS12";//证书类型 固定值
    private static final String KEY_STORE_CLIENT_PATH = "client.p12";//客户端要给服务器端认证的证书
    private static final String KEY_STORE_TRUST_PATH = "client.jks";//客户端验证服务器端的证书库
    private static final String KEY_STORE_PASSWORD = "changeit";// 客户端证书密码
    private static final String KEY_STORE_TRUST_PASSWORD = "changeit";//服务端证书库密码

    //信任自己放在本地的证书 (双向验证)
    private static synchronized SSLSocketFactory getTwowaySSLContextFactory() {
        InputStream ksIn = null;
        InputStream tsIn = null;
        String prefix_path = "src/main/resources/crt/";
        try {
            // 服务器端需要验证的客户端证书
            KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE_P12);
            ksIn = new FileInputStream(prefix_path + KEY_STORE_CLIENT_PATH);
            keyStore.load(ksIn, KEY_STORE_PASSWORD.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, KEY_STORE_PASSWORD.toCharArray());
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

            // 客户端信任的服务器端证书
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            tsIn = new FileInputStream(prefix_path + KEY_STORE_TRUST_PATH);
            trustStore.load(tsIn, KEY_STORE_TRUST_PASSWORD.toCharArray());
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm);
            trustManagerFactory.init(trustStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagers, trustManagers, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | IOException | UnrecoverableKeyException |
                CertificateException e) {
            e.printStackTrace();
            throw new AssertionError();
        } finally {
            try {
                if (ksIn != null) {
                    ksIn.close();
                }
                if (tsIn != null) {
                    tsIn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
