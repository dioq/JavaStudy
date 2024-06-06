package com.crypto.ECC;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

import javax.crypto.Cipher;
import java.security.*;


public class ECCUtil {

    private static ECCUtil instance;

    //构造器私有化
    private ECCUtil() {
    }

    //方法同步，调用效率低
    public static synchronized ECCUtil getInstance() {
        if (instance == null) {
            instance = new ECCUtil();
            instance.getKeyPair();
        }
        return instance;
    }

    private KeyPair keyPair;

    private void getKeyPair() {
        // 添加Bouncy Castle作为加密提供程序
        Security.addProvider(new BouncyCastleProvider());
        // 选择椭圆曲线参数
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256r1");

        try {
            // 生成密钥对
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "BC");
            keyPairGenerator.initialize(ecSpec, new SecureRandom());
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] encrypt(byte[] plainText) {
        try {
            PublicKey publicKey = keyPair.getPublic();
            System.out.println(publicKey.toString());
//            Key tmpKey = keyPair.getPublic();
//            System.out.println(tmpKey);
//            System.out.println(publicKey.toString());
            Cipher cipher = Cipher.getInstance("ECIES", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decrypt(byte[] ciphertext) {
        try {
            PrivateKey privateKey = keyPair.getPrivate();
//            System.out.println(privateKey.toString());
            Cipher cipher = Cipher.getInstance("ECIES", "BC");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(ciphertext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
