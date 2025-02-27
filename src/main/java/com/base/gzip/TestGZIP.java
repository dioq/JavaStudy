package com.base.gzip;

import com.base.bytes.DataFormatUtil;
import com.base.file_io.FileUtils;

import java.nio.charset.StandardCharsets;

public class TestGZIP {
    private static String testStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    public static void main(String[] args) {
        test00();
//        test01();
//        test02();
    }

    private static void test03() {
        byte[] bytes1 = FileUtils.readBytes_from_localFile("C:\\Users\\zhend\\Desktop\\byte3");
        assert bytes1 != null;
        System.out.println("byte1 hex : " + DataFormatUtil.byteToHex(bytes1));

        byte[] bytes2 = GZIPUtils.uncompress(bytes1);
    }

    private static void test02() {
        byte[] bytes1 = FileUtils.readBytes_from_localFile("C:\\Users\\zhend\\Desktop\\byte3");
        assert bytes1 != null;
        System.out.println("byte1 hex : " + DataFormatUtil.byteToHex(bytes1));

        byte[] bytes2 = GZIPUtils.uncompress(bytes1);
//        System.out.println("byte2 : " + BytesHexUtil.byteToHex(bytes2));
//        String str2 = new String(bytes2, StandardCharsets.UTF_8);
//        System.out.println("str2 : " + str2);
    }

    public static void test01() {
        byte[] bytes0 = testStr.getBytes(StandardCharsets.UTF_8);
        System.out.println("origin hex :\n" + DataFormatUtil.byteToHex(bytes0));

        byte[] bytes1 = GZIPUtils.compress(testStr, "UTF-8");
        System.out.println("compressed hex :\n" + DataFormatUtil.byteToHex(bytes1));
        System.out.println("compressed str :\n" + new String(bytes1, StandardCharsets.UTF_8));
        byte[] bytes2 = GZIPUtils.uncompress(bytes1);
        System.out.println("uncompressed hex :\n" + DataFormatUtil.byteToHex(bytes2));
        String str2 = new String(bytes2, StandardCharsets.UTF_8);
        System.out.println("uncompressed str :\n" + str2);
    }

    private static void test00() {
        System.out.println("字符串长度：" + testStr.length());
        System.out.println("压缩后：：" + GZIPUtils.compress(testStr).length);
        System.out.println("解压后：" + GZIPUtils.uncompress(GZIPUtils.compress(testStr)).length);
        System.out.println("解压字符串后：：" + GZIPUtils.uncompressToString(GZIPUtils.compress(testStr)).length());
    }
}
