import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class JunitTest {

    @Test
    public void test01() {
        System.out.println("hello world!");
    }

    @Test
    public void test02() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Pixel 2L");
        System.out.println(headers.toString());
    }

    @Test
    public void test03() {
        String qd_sg = String.format("865166028633454-8.10.0-%d-", System.currentTimeMillis());
        System.out.println(qd_sg);
    }

    @Test
    public void test04() {
        String tt = "afafaf";
        System.out.println(tt.toUpperCase());
    }

    @Test
    public void test05() {
        String t1 = "{\"aa\":\"800810000\",\"bg\":\"867374874737747\",\"bb\":\"asus\\\\\\/android_x86\\\\\\/x86:5.1.1\\\\\\/LMY47I\\\\\\/8.3.19:user\\\\\\/release-keys\",\"ak\":\"\",\"qf\":\"6.0\",\"fu\":\"com.qiyi.video.child\",\"kl\":\"22f36f5d-2371-487a-9fa4-2b3a0ed3292c\",\"go\":\"8.10.0\",\"ol\":\"\",\"ab\":\"s6WQ+Sua5Bz33x7x4pUusyof8DXPwL0b\\/LN2lQnrxGH91\\/J7EB493+pG6luTY9Kl8gu7prBQHrnk+qhGdhKf0u0RzQob+1CBRYcsLXHlT+W+zyFNtL4shUubb7SPKa0\\/mZRbjp9v+y1aobJrcn4g7fEXv3NybX5QJofaWqU8XzkHL0S2LvflAq5zt\\/6x+3t0IXi2hM1xKY6ELIde2qdDnPvgCya1Yarv26YG1UiEvCFY5FWipeinlFwYGIPPFKn07zv5qOKa7HaRf5g52xyI\\/aUsaiU7PC1lQmII\\/YHFsQktkBU0sEL852W6I+HjWYVwcUUXIGPeXnM2xPoFxGN7SdaOep3qNmiKSSHeEZkLDZANVH6wKiQU\\/WxYWE+Li6yvQuYICsN9e8drNPhE649kKdIO6ld+1VVjdXGVkhs\\/bc1vaERw+GfLxLT5er\\/sPzahkDmLagswbrxwmT\\/eYiVh9LSzy65aY9dJSyZyLQBm9+8NcsDw977D8kOHEiFcFkmUYo2KGLqy7F29vK\\/WSj1my5kd8rPpjQE4STpQn+RTVGB4qJ6hs9gpeZ1V\\/AFe4IA0IqfAfrWSpyjExR+PplK9thmXiR\\/Q4prkQ\\/LQD5p5fz06PMf+ME2rqmLntPGnrOWgQZ+4Ybx6bxrfTCjRF72AVcPaFutDBH3eBtaS1N2mN2MYBT6Un06GbwPC+XfeKsavm7Mb\\/d8M\\/et65kQCoJbAMXNYOGHAraglAmAlDFcB5AmvKfXi9ksu6EpDHWxQUL2tyBo06jzQKTAqMEB3rEj2R1B1t8ZEj6A3\\/WwQHDeKqnIjOfIbPe74xSN6FMVjA3Q+uPXNm6Bieo4lV5Atiq05MNS8AQ48sEBoV8uUzj8cHqEW\\/jGrNQvZy5R4AAjGzKWJOYEJpBDUF2KPCKwQPnvo3mcOf786GUKcpKf2PKZcKryjDQHVuDx\\/2rAO9VWPm1f89iDB4sijWmd1qxc6W3IUnuEfkyhPNDifkzYuOBdfmiJ5byHjfKITUq6JimpQbNNyizvTyaRqgPJvDYZTUjHkmXwzBAmC6lAQ6T50sOsyztgxiSHZeN9RntPE2b7LQQXxS1XJ7sNrurS56wqcjpB9l\\/x7F1VhenF4Pksj89vxrnc345H\\/nsolnrlRrtud49sNcQWU7k1DYfAra4TZ1S\\/46\\/T83QCOQZ+Oo6+KyxcYay2zlkY0vr81OMK5\\/YRr7l0TH6mJIEWWsAazGfZLpceyCwejgktfLq4rEBFKX\\/9Z41ZA5m6SZlm5FgqY84SxCJvf7TOVFyKHf\\/bVFKEx+SBkux7hVODTPc+erAXfixI3iUsHoTk8z8jW35pfzbBMPmuOdC2R0SGaBK8NJJX4AfqkPqWDTck+vGDgZAMEmZlnA4pEfCqNswwhMzFmu6te6nNJF2VgtjCREatGzv5vYThLzBF3h7aHNYNSrsSD\\/9RIABjzTRtpKOQIrUYddPioB9l33l3DbkOX1tQ8qHQ\\/npm1N8O78vSUD\\/lDE+cQ6GcUD98l3WjIURVYxcWZ8mPKRmoo+QhZRXYqSLAYHqw3Lx2i6K1uuvaVku1iwpkfRjOgkCpDp3miyTFLyAn2JIMCgWZn0CWSbA3yhOUvE63216rkzKGE9mxXVMePAGWrAIkefkU=\"}";
        String t2 = Base64.getEncoder().encodeToString(t1.getBytes());
        System.out.println(t2);
    }

    @Test
    public void test06() {
//        String[] shedlue = new String[]{"0",};
        String sm = "";
        int num = new Random().nextInt(16);
        String num2 = Integer.toHexString(num);
        for (int i = 0; i < 6; i++) {
            int index1 = new Random().nextInt(16);
            String random1 = Integer.toHexString(index1);
            int index2 = new Random().nextInt(16);
            String random2 = Integer.toHexString(index2);
            if (i == 5) {
                sm += (random1 + random2);
            } else {
                sm += (random1 + random2) + "-";
            }
        }
        System.out.println(sm);
    }

    @Test
    public void test07() {
        String t = "==";
        String t2 = null;
        try {
            t2 = URLEncoder.encode(t, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(t2);
    }

    @Test
    public void test08() {
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.error("123");
    }

    @Test
    public void test09() {
//        String tt = "1213131";
//        new String(Base64.getEncoder().encode(instance.doFinal(bytes)));
        String result = m7333a("20160122sdf", new BigInteger(mo15568g()), new BigInteger("65537"));
        System.out.println(result);
    }

    public String m8057a(byte[] bArr) {
        final char[] f6164a = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int b = bArr[i] & 255;
            cArr[i * 2] = f6164a[b >>> 4];
            cArr[(i * 2) + 1] = f6164a[b & 15];
        }
        return new String(cArr);
    }

    public String mo15568g() {
        return "7030275091430684880455197983898536510502970284707709211601320194624399535289472259282643248491148705072503555764283431685757559494709977423553831916356709";
    }

    public static String m7333a(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(bigInteger, bigInteger2));
            Cipher instance = Cipher.getInstance("RSA/ECB/NoPadding");
            instance.init(1, generatePrivate);
            return new String(Base64.getEncoder().encode(instance.doFinal(bytes)));
//            return new String(Base64.encode(instance.doFinal(bytes), 2), "UTF-8");
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | UnsupportedEncodingException | InvalidKeySpecException | IllegalBlockSizeException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }
}
