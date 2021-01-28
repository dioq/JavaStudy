package com.my.certificate2format;

public class CertificateTest {
    public static void main(String[] args) {
//        test01();
        test02();
    }

    private static void test02() {
        String jksFilePath = "E:\\SSL_cert\\tmp\\client.jks";
        String jksPasswd = "changeit";
        CertificateUtil.listAllCerts(jksFilePath,jksPasswd,"jks");
    }

    private static void test01() {
        String jksFilePath = "E:\\SSL_cert\\tmp\\client.jks";
        String jksPasswd = "changeit";
        String pfxFolderPath = "E:\\SSL_cert\\tmp\\client.p12";
        String pfxPasswd = "changeit";
        try {
            CertificateUtil.covertJSKToPFX(jksFilePath, jksPasswd, pfxFolderPath, pfxPasswd);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
