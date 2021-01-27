package com.my.network.SSLUtil;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class CertificateManagers {

    private static final String KEY_STORE_TYPE_BKS = "bks";//证书类型 固定值(Android 端用bks类型)
    private static final String KEY_STORE_TYPE_P12 = "PKCS12";//证书类型 固定值
    private static final String KEY_STORE_CLIENT_PATH = "client.p12";//客户端要给服务器端认证的证书
    private static final String KEY_STORE_TRUST_PATH = "client.jks";//客户端验证服务器端的证书库
    private static final String KEY_STORE_PASSWORD = "changeit";// 客户端证书密码
    private static final String KEY_STORE_TRUST_PASSWORD = "changeit";//服务端证书库密码

    // 证书所在的文件的路径
    private static final String prefix_path = "src/main/resources/crt/";

    /*
     * KeyManagerFactory 保存自己的证书
     * TrustManagerFactory 保存其他人的证书, 如服务器的
     * */

    public static KeyManager[] getKeyManagers() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        // 服务器端需要验证的客户端证书
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE_P12);
        InputStream ksIn = new FileInputStream(prefix_path + KEY_STORE_CLIENT_PATH);
        keyStore.load(ksIn, KEY_STORE_PASSWORD.toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, KEY_STORE_PASSWORD.toCharArray());
        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        ksIn.close();
        return keyManagers;
    }

    public static TrustManager[] getTrustManagers() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        // 客户端信任的服务器端证书
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream tsIn = new FileInputStream(prefix_path + KEY_STORE_TRUST_PATH);
        trustStore.load(tsIn, KEY_STORE_TRUST_PASSWORD.toCharArray());
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm);
        trustManagerFactory.init(trustStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        tsIn.close();
        return trustManagers;
    }

}
