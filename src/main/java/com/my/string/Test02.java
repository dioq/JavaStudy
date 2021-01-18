package com.my.string;

public class Test02 {
    public static void main(String[] args) {
        String tmp1 = "大奶子";
        String tmp1_hex = bytes2Hex(tmp1.getBytes());
        System.out.println("tmp1_hex:\n" + tmp1_hex);
        String tmp2 = "vP";
        char[] tmp2_chars = tmp2.toCharArray();
        for (char c : tmp2_chars) {
            System.out.println((int) c);
        }
    }

    /**
     * byte数组转换为16进制字符串
     *
     * @param bts 数据源
     * @return 16进制字符串
     */
    private static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = Integer.toHexString(bts[i] & 0xFF);
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

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
}
