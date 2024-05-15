package com.base.bytes;

public class DataFormatUtil {

    // bytes -> hex
    public static String byteToHex(byte[] bts) {
        if (bts.length == 0) {
            return null;
        }
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

    // hex -> byte
    public static byte[] hexToByte(String hex) {
        byte[] cipherBytes = hex.getBytes();
        if ((cipherBytes.length % 2) != 0) {
            return null;
        }
        byte[] result = new byte[cipherBytes.length / 2];
        for (int i = 0; i < cipherBytes.length; i += 2) {
            String item = new String(cipherBytes, i, 2);
            result[i / 2] = (byte) Integer.parseInt(item, 16);
        }
        return result;
    }

}
