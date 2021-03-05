package com.my.test;

import com.my.bytes.BytesHexUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.IIOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Dianping_crack4 {

    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test02() {
        String test_str = "6ccf6f61ac4b6e0c593dbf0e7257a9b03168e9b9e26adde57ee3fcc25180d037cb4596b61d2d0641a1321b922f484f12801d7937f982d86c9c9c3202ab6d5f6c6730030916c249eba7f6e344593b6d816c69bf40a1f9e5546321da3eec805653634ad4d116462425cfc722838cd57c13393424574ac068b68de80956d4cad4965bcc2044dacfad915189900e865b0efac278320290a992c24680c67ed3700b3f";
        byte[] bytes_str_2 = BytesHexUtil.hexToByte(test_str);
//        String test_bytes_str_2 = Arrays.toString(bytes_str_2);
//        System.out.println("test_bytes_str_2:\n" + test_bytes_str_2);

        try {
            InputStream in = new ByteArrayInputStream(bytes_str_2);
            InputStream inputStream2 = decrypt(in);

            int len = inputStream2.available();
            byte[] buff = new byte[len];
            inputStream2.read(buff, 0, len);
            String hex_str = BytesHexUtil.byteToHex(buff);
            System.out.println("解密 plaintext:\n" + hex_str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test01() {
        String test_str = "73686f7069643d383233333839303926746f6b656e3d3965386362643234326435303538643834326161393035383936313965356461363564303362333432333438393264643633323762333763336663336362373131323066353061336235393861376335303862636232373336623831623434316631636437373239333062393534333235343965643062396561326661343432";
        byte[] bytes_str_2 = BytesHexUtil.hexToByte(test_str);
//        String test_bytes_str_2 = Arrays.toString(bytes_str_2);
//        System.out.println("test_bytes_str_2:\n" + test_bytes_str_2);

        try {
            InputStream in = new ByteArrayInputStream(bytes_str_2);
            InputStream inputStream2 = wrappedInputStream(in);

            int len = inputStream2.available();
            byte[] buff = new byte[len];
            inputStream2.read(buff, 0, len);
            String hex_str = BytesHexUtil.byteToHex(buff);
            System.out.println("加密 ciphertext:\n" + hex_str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public static InputStream wrappedInputStream(InputStream wrappedInputStream) throws IOException {
        int n = wrappedInputStream.available();
        byte[] pbytes = new byte[(n % 16 == 0 ? n : (16 - (n % 16)) + n)];
        int i = 0;
        while (true) {
            int l = wrappedInputStream.read(pbytes, i, n - i);
            if (l <= 0) {
                break;
            }
            i += l;
        }
        byte[] encrBuffer = null;
//        if (NativeHelper.A) {
//            encrBuffer = new byte[pbytes.length];
//            if (!NativeHelper.ne(pbytes, encrBuffer, DefaultMApiService.this.k, DefaultMApiService.this.v)) {
//                encrBuffer = null;
//            }
//        }
//        if (encrBuffer == null) {
        byte[] k = new byte[]{68, 55, 67, 54, 70, 55, 49, 65, 49, 50, 49, 53, 51, 69, 69, 53};
        byte[] v = new byte[]{53, 53, 67, 57, 51, 48, 68, 56, 50, 55, 66, 68, 65, 66, 70, 68};
        SecretKeySpec key = new SecretKeySpec(k, "AES");
        IvParameterSpec iv = new IvParameterSpec(v);

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, key, iv);
            encrBuffer = cipher.doFinal(pbytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
//        }
        return new ByteArrayInputStream(encrBuffer);
    }

    public static InputStream decrypt(InputStream wrappedInputStream) throws IOException {
        int n = wrappedInputStream.available();
        byte[] pbytes = new byte[(n % 16 == 0 ? n : (16 - (n % 16)) + n)];
        int i = 0;
        while (true) {
            int l = wrappedInputStream.read(pbytes, i, n - i);
            if (l <= 0) {
                break;
            }
            i += l;
        }
        byte[] encrBuffer = null;
//        if (NativeHelper.A) {
//            encrBuffer = new byte[pbytes.length];
//            if (!NativeHelper.ne(pbytes, encrBuffer, DefaultMApiService.this.k, DefaultMApiService.this.v)) {
//                encrBuffer = null;
//            }
//        }
//        if (encrBuffer == null) {
        byte[] k = new byte[]{68, 55, 67, 54, 70, 55, 49, 65, 49, 50, 49, 53, 51, 69, 69, 53};
        byte[] v = new byte[]{53, 53, 67, 57, 51, 48, 68, 56, 50, 55, 66, 68, 65, 66, 70, 68};
        SecretKeySpec key = new SecretKeySpec(k, "AES");
        IvParameterSpec iv = new IvParameterSpec(v);

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, key, iv);
            encrBuffer = cipher.doFinal(pbytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
//        }
        return new ByteArrayInputStream(encrBuffer);
    }

}
