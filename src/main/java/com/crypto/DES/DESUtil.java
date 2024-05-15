package com.crypto.DES;

import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DESUtil {

    private static final String key = "vpRZ1kmU";
    // 偏移量
    private static final String OFFSET = "EbpU4WtY";

    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";

    // 加密和解密 的key和iv(偏移)是一样的
    private static final SecretKeySpec skeySpec;
    private static final IvParameterSpec iv;

    static {
        skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.US_ASCII), "DES");
        iv = new IvParameterSpec(OFFSET.getBytes(StandardCharsets.UTF_8));//使用CBC模式，需要一个向量iv，可增加加密算法的强度
    }

    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (NoSuchAlgorithmException | BadPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String ciphertext) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] buffer = Base64.getDecoder().decode(ciphertext);
            byte[] encrypted = cipher.doFinal(buffer);
            return new String(encrypted, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | BadPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
