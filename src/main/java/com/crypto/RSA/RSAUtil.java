package com.crypto.RSA;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

    private static final String publicKey_base64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoeMASyMmEy3KtpJ197lKnE+Mgo7WuK3i0H1vwf8y4WOmgXCJe9R5l0+ajpNDeL5nMdRfpuMu69VEaNX40fZXe2N8pnMvyTXurzScZ7IfH1XiRdLKT2ZiP6mFUQlZGZ96z0b2l4HXXxTxxkuZLObwfOalh4wLrAdmw0jTcPCZWJ2SujNJO6gDh/vw6KNeRO73c0IVLUBBAvZUKAPqq51PG0wvD4wCYl5JdfBsy5D+25fRMOE9y20V5tzIpemMGN3KmYLr+/dp4jrNdXA06RS2YumlMrASJCnjUaNuZRfqcZ3/vN4vUAjwl01hZ5X0xlHinC/fr7fOYJhmgAUSq2wa2QIDAQAB";
    private static final String privateKey_base64 = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCh4wBLIyYTLcq2knX3uUqcT4yCjta4reLQfW/B/zLhY6aBcIl71HmXT5qOk0N4vmcx1F+m4y7r1URo1fjR9ld7Y3ymcy/JNe6vNJxnsh8fVeJF0spPZmI/qYVRCVkZn3rPRvaXgddfFPHGS5ks5vB85qWHjAusB2bDSNNw8JlYnZK6M0k7qAOH+/Doo15E7vdzQhUtQEEC9lQoA+qrnU8bTC8PjAJiXkl18GzLkP7bl9Ew4T3LbRXm3Mil6YwY3cqZguv792niOs11cDTpFLZi6aUysBIkKeNRo25lF+pxnf+83i9QCPCXTWFnlfTGUeKcL9+vt85gmGaABRKrbBrZAgMBAAECggEAI1tKQZ7UHoU2TGixhiC8aGZBWHRs9hnYO1PiGDst+CcFAyk6hcaSpdb3eSM1rcXcEPiCyZa9tTk3fzQYa3cDhUnlvA7VRXtXfYGelVFEVdoymLBgijXgyGm0Wc4SXTPFJUco7U8o5DXVVktFkZaAuK7BQVj3ZaOaMJWTxItv2nf62jAMV9uNvI4g4OXi3oGuYML4RaPbvGiCkLZJ3l/+kZQnV0dUszU09GMoMiGtPIxdtMhd4V/E7HZJfZnZ+nx47gdDI+KHVlVrsNmj6OSPREkrgm1IbIwoSs/CiOg35AhZjqN2QoVYWjwY8tZFH5Bllw42kpAlTxVv7TpMLsD8LwKBgQDM6xAOv1HpUcamjyYhk7LI0W++iqwbTscwbdI5YCWARRyiWeif56eIjnx9Rg9XvnxMRtJZUh1F6rCqOVSU+Muhp5+agU8Ktv2c41pFQYqe4cJbI9ALurGcauY5b0wPQkhAyyqgXbqbcRxLstYR/KKQCjUqQjdeSArG6+fhMaJLnwKBgQDKPd3jDjXBWycJf0/Lf6ycVQQsymggAvbPgHssKc0xZpiOH6igHHFNZlQdyQ+p6ut1Av0lvdz1DErGYt02Ez+Esi1p6F8cJYLaKY7/G0+atEnWluVW8XVmemzg0PB2PsZHLQ/kgnoQcRP5K96/Xn+X1OHq4bdGtuCunflFvR+GhwKBgDGr8RKCEcrqxapuHKIa+UVwbxPS7XEZIXN9y22Y/r4fApfgD2Fjd9rEHy0GpIVyaRLcP/Ti0LG39+brSrNps4KV7Tw4h/5i6Qr0mVccUgu9Ua1h+vY85PyzdOcLMXapbHY4STbiQW+YdXFsAjQN9yHPN5/suRsjf2lEmcqei2alAoGBAJhndM2FSNcUBN/wU8aLyRzqKEJEqaDt+uY18Rw/yAShRvdbPiyiInPsWBk2ChrHEHbWMMR/RoJXqAXGPONiL+ykhPqZhQrl7azPwpXWE/AGStpuThdt0EXQnjnw2jSRa8P5Xk+aT7gSLrYH7E0UPlzBrRnezMl6SOjt3QpD0f0DAoGAflFFKA4tfIcLtFBYeDm1P+6B+n0hNS769IpeUfplYSFKoGNbSTEvicgFe/65kWLn94VIZ9g1acriCRJToW83+0U4C7UkOsKtUv/onVaj32HZA6L8fEcVKWBPiADnR+KjLkkc6lAc3T99a95ibdLhqlGGQLplzl8zmqLIieT1vNo=";

    private static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

    public static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    //公钥加密
    public static byte[] encrypt(byte[] plainText) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(publicKey_base64);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytes = cipher.doFinal(plainText);
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //私钥解密
    public static byte[] decrypt(byte[] ciphertext) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(privateKey_base64);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytes = cipher.doFinal(ciphertext);
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
