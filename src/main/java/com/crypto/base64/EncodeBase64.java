package com.crypto.base64;

public class EncodeBase64 {
    //码表
    private static final char[] slegalChar = "i5jLW7S0GX6uf1cv3ny4q8es2Q+bdkYgKOIT/tAxUrFlVPzhmow9BHCMDpEaJRZN"
            .toCharArray();

    public static String encrypt(String plaintext) {
        if (plaintext.length() == 0) return "";

        //把待加密字符串转成8位二进制，用字符串的形式表式
        byte[] plaintextByteArr = plaintext.getBytes();
        String binaryStr = "";//8位二进制 字符串
        for (byte achar : plaintextByteArr) {
            String tmp = Integer.toBinaryString(achar);
            String prex = "";
            for (int i = 0; i < (8 - tmp.length()); i++) {
                prex += "0";
            }
            tmp = prex + tmp;
//            System.out.println("count1 : " + tmp.length());
            binaryStr += tmp;
        }
        System.out.println("填充前二进制字符串: " + binaryStr);

        //如果最后一组不足6位则在低位补0
        int lastgroupSize = binaryStr.length() % 6;
        if (lastgroupSize != 0) {
            String suffix = "";
            for (int i = 0; i < (6 - lastgroupSize); i++) {
                suffix += "0";
            }
            binaryStr += suffix;
        }
        System.out.println("填充后二进制字符串: " + binaryStr);

        int groupCount = binaryStr.length() / 6;
        char[] targetCharArr = new char[groupCount];
        System.out.println("groupCount : " + groupCount);
        for (int i = 0; i < groupCount; i++) {
            int index = i * 6;
            String charBinary = binaryStr.substring(index, index + 6);
            System.out.println(i + " : " + charBinary);
            int index_slegalChar = binToOct(charBinary);
            System.out.println(i + " : " + index_slegalChar);
            //获取码表中对应下标的字符
            char targetChar = slegalChar[index_slegalChar];
            System.out.println("targetChar : " + targetChar);
            targetCharArr[i] = targetChar;
        }

        //将字符串数组转成字符串
        String result = new String(targetCharArr);

        //如果结果不是4的倍数就补 =
        int numFiller = groupCount % 4;
        if (numFiller != 0) {
            String suffix = "";
            for (int i = 0; i < (4 - numFiller); i++) {
                suffix += "=";
            }
            result += suffix;
        }

        return result;
    }

    // 二进制字符串转整型
    static int binToOct(String bin) {
        int total = 0;
        char[] binCharArray = bin.toCharArray();
        for (int i = 0; i < binCharArray.length; i++) {
            total = total + binCharArray[i] - 48;
            if (i != binCharArray.length - 1) {
                total = total << 1;
            }
        }
        return total;
    }


    public static void main(String[] args) {
        String cipherttext = encrypt("AAAAAA");
        System.out.println(cipherttext);
    }
}
