package com.base.string;

public class Test03 {
    public static void main(String[] args) {
        String tmp = "тебя";
        String tmp_arr = bytes2Hex(tmp.getBytes());
        System.out.println("tmp_arr : \n" + tmp_arr + "  length : " + tmp_arr.length());

        String tmp2 = "B51O";
        String tmp2_arr = bytes2Hex(tmp2.getBytes());
        System.out.println("tmp2_arr : \n" + tmp2_arr + "  length : " + tmp2_arr.length());
    }

    private static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
