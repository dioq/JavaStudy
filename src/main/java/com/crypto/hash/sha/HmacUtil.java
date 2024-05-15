package com.crypto.hash.sha;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacUtil {

    public static String hmacSha1(String KEY, String VALUE) {
        return hmacSha(KEY, VALUE, "HmacSHA1");
    }

    public static String hmacSha256(String KEY, String VALUE) {
        return hmacSha(KEY, VALUE, "HmacSHA256");
    }

    private static String hmacSha(String KEY, String VALUE, String SHA_TYPE) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(KEY.getBytes(), SHA_TYPE);
            Mac mac = Mac.getInstance(SHA_TYPE);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(VALUE.getBytes("UTF-8"));
            return bytes2Hex(rawHmac);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String bytes2Hex(byte[] bts) {
        StringBuilder des = new StringBuilder();
        String tmp = null;
        for (byte bt : bts) {
            tmp = (Integer.toHexString(bt & 0xFF));
            if (tmp.length() == 1) {
                des.append("0");
            }
            des.append(tmp);
        }
        return des.toString();
    }
}
