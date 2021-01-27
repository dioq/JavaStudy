package com.my.network.SSLUtil;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class SSLConfig {

    public static void set(SSLTrustWhich type) {
        try {
            KeyManager[] keyManagers = null;
            TrustManager[] trustManagers = null;
            switch (type) {
                case TrustAll:
                    /*
                     * 只配置 trustManagers, 客户端只验证服务器是单向验证
                     * 这里信任所有的证书
                     * */
                    trustManagers = new TrustManager[]{new MyTrustManager()};
                    break;
                case TrustMeOneway:
                    /*
                     * 只配置 trustManagers, 客户端只验证服务器证书是单向验证
                     * 公钥证书固定. 只信任自己指定的服务器证书
                     * */
                    trustManagers = CertificateManagers.getTrustManagers();
                    break;
                case TrustMeTwoway:
                    // 配置 trustManagers,keyManagers,客户端验证服务器证书、服务器也验证客户端证书，是双向验证
                    keyManagers = CertificateManagers.getKeyManagers();
                    trustManagers = CertificateManagers.getTrustManagers();
                    break;
            }

            SSLContext s_sSLContext = SSLContext.getInstance("TLS");
            s_sSLContext.init(keyManagers, trustManagers, new SecureRandom());

            //将证书工厂 配置到 HttpsURLConnection
            HttpsURLConnection.setDefaultSSLSocketFactory(s_sSLContext.getSocketFactory());
            //验证域名
            HttpsURLConnection.setDefaultHostnameVerifier(new MyHostnameVerifier());
        } catch (IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

}
