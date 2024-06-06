package com.crypto.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static String md5(String plainText) {
        return encrypto(plainText, "MD5");
    }

    public static String sha256(String plainText) {
        return encrypto(plainText, "SHA-256");
    }

    public static String encrypto(String plainText, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);// 将此换成SHA-1、SHA-512、SHA-384等参数
            md.update(plainText.getBytes());
            return bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
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
