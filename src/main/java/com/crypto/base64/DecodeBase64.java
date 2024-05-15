package com.crypto.base64;

public class DecodeBase64 {
    private static final char[] legalChars = "i5jLW7S0GX6uf1cv3ny4q8es2Q+bdkYgKOIT/tAxUrFlVPzhmow9BHCMDpEaJRZN"
            .toCharArray();

    //依次读取 二进制 字符串，并根据ASCII码表 转换成对应的字符，然后将得到的字符进行拼接
    public static String readCharByASCIIStr(String vaule) {
//        System.out.println("origin string : \n" + vaule);
//        System.out.println("length : " + vaule.length());
        int num = vaule.length() / 8;
        char[] bytes = new char[num];
        for (int i = 0; i < num; i++) {
            int index = i * 8;
            String charBinary = vaule.substring(index, index + 8);
//            System.out.println(charBinary);
            char re = BinstrToChar(charBinary);
//            System.out.println(re);
            bytes[i] = re;
        }
        return new String(bytes);
    }

    // 将二进制字符串转换为char
    private static char BinstrToChar(String binStr) {
        int[] temp = BinstrToIntArray(binStr);
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[temp.length - 1 - i] << i;
        }
        return (char) sum;
    }

    // 将二进制字符串转换成int数组
    private static int[] BinstrToIntArray(String binStr) {
        char[] temp = binStr.toCharArray();
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i] - 48;
        }
        return result;
    }

    //拼接所有 二进制 字符
    public static String allBinaryStr(String value) {
        String result = "";
        String pureStr = removeFilledcharacters(value);//祛除 填充字符 =
        for (int i = 0; i < pureStr.length(); i++) {
            int index = getIndex(pureStr.charAt(i));//获取 每个字符的索引
            String indexBinary = get6BitBinary(index);//把索引转换成6位的二进制
            result += indexBinary; //将所有6位二进制拼接
        }
        return result;
    }

    //祛除 填充字符 =
    public static String removeFilledcharacters(String value) {
        String result = value.replace("=", "");
        return result;
    }

    //把索引转换成6位二进制
    public static String get6BitBinary(int index) {
        String indexBinStr = Integer.toBinaryString(index);
        if (indexBinStr.length() < 6) {
            String prex = "";
            for (int i = 0; i < (6 - indexBinStr.length()); i++) {
                prex += "0";
            }
            indexBinStr = prex + indexBinStr;
        }
//        System.out.println("result : " + indexBinStr);
        return indexBinStr;
    }

    //根据字符获取 码表中的索引
    public static int getIndex(char value) {
        for (int i = 0; i < legalChars.length - 1; i++) {
            if (value == legalChars[i]) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String tryStr = "3q753q75";
        String result = allBinaryStr(tryStr);//获取 二进制 字符串
        String result2 = readCharByASCIIStr(result); //读取 二进制 字符串
        System.out.println("result2:\n" + result2);
    }
}
