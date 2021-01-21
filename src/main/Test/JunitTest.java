import com.my.network.SSLUtil.SSLConfig;
import com.my.network.SSLUtil.SSLTrustWhich;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.*;

import com.my.network.study05.NetworkUtil;

public class JunitTest {

    @Test
    public void test13() {
        SSLConfig.set(SSLTrustWhich.TrustAll);
        String urlStr = "https://passport.iqiyi.com/apis/reglogin/mobile_login.action";
        String requestData = "qyidv2=DB423D7F5692E5BA57B5FEB972E29488&lon=113.128877&dfp=15ae4e7dcfdcc10eed8a0d2fc8d9b83b902938fe43ce77318efc84b90c457eb537&device_type=oppo&wsc_ldt=oppo&fromSDK=21&qd_sc=207476fe0e881e2e0d962e8cec58d364&wsc_lgt=&wsc_sid=4233&checkExist=1&v=1&app_lm=cn&wsc_sp=&verifyPhone=1&appVersion=8.10.0&wsc_imei=864387778247441&passwd=QPI96MovA9H%2FOhjMDNADSryrlpHyYwWXCBsXkDspXGfU%2FVl%2F3id5xgSx2KIXUDX9Q%2BNzdGlRMCff1Rz5D65nrg%3D%3D&imei=864387778247441&lang=zh_CN&hfvc=95&s3=unknow&wsc_st=8.10.0&wsc_cc=&slidetoken=&slide=&QC005=DB423D7F5692E5BA57B5FEB972E294881611162348274&wsc_ost=14&wsc_isc=406050902412656&qd_sg=864387778247441-8.10.0-1611162348274-&ptid=02023031010000000000&wsc_osl=zh&mac=2f4d26ca86adaabc20c2a8b974cc5733&area_code=86&email=18998432390&agenttype=163&wsc_sm=01-12-f8-45-62-46&wsc_tt=02&s2=other&s4=unknow&wsc_iip=&vcode=hk3f&app_version=8.10.0&device_id=864387778247441&fields=userinfo%2Cqiyi_vip%2Cqiyi_tennis_vip%2Cfun_vip%2Csport_vip&device_name=oppo&envinfo=eyJhYSI6IjgwMDgxMDAwMCIsImJnIjoiODY0Mzg3Nzc4MjQ3NDQxIiwiYmIiOiJhc3VzXC9hbmRyb2lkX3g4NlwveDg2OjUuMS4xXC9MTVk0N0lcLzguMy4xOTp1c2VyXC9yZWxlYXNlLWtleXMiLCJhayI6IiIsInFmIjoiNi4wIiwiZnUiOiJjb20ucWl5aS52aWRlby5jaGlsZCIsImtsIjoiMzIyYTY2OWMtMDkxMi00ZDI2LTI3ZmY1MGIzZGJmYjA4YTYiLCJnbyI6IjguMTAuMCIsIm9sIjoiIiwiYWIiOiJFSWlydUF0T0pJSnJ0MnRZRzc3K0FFM1BvUnJvWXRQNWI5VzBwRFlVZjJjZEJsYkc2KzMvS1g0RkVzTFZJYVE1Vy9ERkFibmI2ckIvemNLY2RZNG10dkczanI3a1Riems2bFkycEtGeFhLTThXUTRSRXVFU1ByOXdLRzE2cGtLdCtBNWFwRmpqTW8yTUYwdnhFd1pBZzliOU9VeCs3RFIzWnQ2Y3JMZklyMWl0a2V1b2w2Y2xDUGdTZCswUy8wUjl5bkVueWJuNjd1VVdrcUZ4WFhiR08zWTBTaEdJZkp4UVJwajE0VmRXenVHQnVlbzJ6SElPQnM3RFB0bEZBT3ZjQVVuS0RJYnJHem5DeFB0OWgrYXdBazNHWEJaMjlXaGxZYngzbER4eFBIdjNZQjM0RUJ0Q1ZmZXlJZTJsU3E0UmFRRFFQbmNkVTFCZzJpMkRNOEY2WjVUWkt0TXFuZHc0cGdna291UElweTJIRkNsdkRhZ2prR3ZnUDlhblBwWmdWZ3RvR05Eb21HVDdBVE0xYUxPVDdmeG9HbWJJeUhmZUZjSDlmZGErT2oxVGIrVW5RWTAzS2FkcWl3bUV3T0I1M2c2MHB1SjFiNUZQL1hJVHp4OWMwVldjNTVmcHNCcUxJNnY1SFphT1RmZ3U3VzNLblRQeDVpZ1Y2WkJqZFRoVGFZenJzRFhDb3pyYU5CeW55a3ZFY0txcWVha1dKUEJSdjk4NkVsd0FLelQ0Zkp1TEw0WFkxc21QRlF5dnNMakk5THVBODkrQkM4K1hCUm1SY1VNZVl4K01QR0JxQkVyelM5YlJHcVlhNWxoN083T3J5Ti85UUJyS0RGR2pJT3Fybjl6UjhVYU1MVDFkZ1crdGlxZVcrc1RyUU5lVlNWYk9uNHc4WUhTQUsxMEx5bDh6Z3lVUjJyMW1VU2ZyeTBmQzl3UG82TG8zVE9kZ0Jmb3c0SVo1T3NGV3YwcXBPQUdjRy9jbEp3cnU0a2RBa2cyMzQ1TVF6ZW1YMTRFSFcraDRUQkYyRDRleVp3MUh6ZEg1cGt1QlEzSlc1VER1R0oydlN2cEM1UlMwMEpIZGp5K1hrcWZ4OHdYZHMzUFl4ek5nSjZPTFUvZ2lNNXgwWkF2Z3ZKK28yanVmZVBWRU84aTU1S1NsbFFJVzhWZk1RSnNaSXBub0k2Tkwvb0RsU3I1bDRhaVJyVEFGenlXSzFILzM4cldJdjhXWDFsQ0ZsdUFIRUMvZzljWUprbVAvckY1cWovWUZnRmFlR3MyZ3V4T1JTbHE5TERZazdxTjhKTkpFTzdaQnU0bWRjZEoyT1pEZjVmL01sWnl3dElyVis1MlhwaGh5cFEvVmpYNEJyQnBVQ0M1QUFrY2Yva0RobDVDeXI2WDU4eGhDUUIxMzEyV1ZydkhVdmNvSm43a1ZtVUhzcE9IZDRnTm9xc2ZVby9GQnZZQ2ZZRk1mN0RYckZ1eHhPZWJPMDVHZ2pZNjNiR2VkRkVQUjErQVlPSzNaTDlrajYrMkJ2enhBNHlOMTRUUnUwc2VFcXdPOWpSWDBQNGs4MkZGa3NVZEhObVIzS1R3OTZ2dXBTem1vMEhtcVM0cVV4SlpsSW9FZFQ2b1I3czVVa3B0U09CNmV4UmhmMDBVKy9KQ1FHZ2p2S0F1ZmRPQnNOMllBcmZUT1ZCSnV0amI3TSt3Mk52K1BTMWhmTDBHWVZ2MDNTckl0aXF3MTdkVHVycDdua2JpRDFVZ1FrcHJXMi91dkF1RHBnSVlsdVIrQjNtTGdyNkNqR01mOERiZWN5TEZlbXN1aTc3UVlzNGg3bmcyUFFzdmczUkFZZXAzcGFucmtHZ1YydTJ4c0JCM255UkJJZis0UHJKZW9mekdDZkVZbTNoY3dvM0E4WklCT1MxaDB2QXJNQ1FrU3d6S2hzUm9RaHR6OXhONVlpWGdtem9FQTAyMUQvREM4Um5XdytWUTFmcElaaXlmdU5YNy96Sy80OG4rWlVocDM5cHRyTU9ESXQvQnFoZ001MlR5YXlIMGRUV3o2Z1VNaDdxWFRET3RBK25vdGoxc1l6QmZzS0ZtWEtPMDhkd0RhS2c2czdsbjJIY3ozdmNSQ0hvekVBNE1OMjVpL1k5Zzh6Q3VwT3pFNVBFWmlYTHV2ODhvUHZHYmZkQzlhaWZBVTdTcFhPYmVHZGJpTG02QT0ifQ%3D%3D&wsc_istr=864387778247441&wsc_ltt=&lat=29.356983&";
        System.out.println(requestData);
        String response = new NetworkUtil().doPost(urlStr, requestData);
        System.out.println("response:\n" + response);
    }

    @Test
    public void test12() {
        String uriStr = "http://www.anant.club:8848/getTest";
        try {
            URI uri = new URI(uriStr);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11() {
        Student stu = new Student();
        stu.name = "name1";
        stu.age = 18;
        System.out.println(stu.hashCode());
        System.out.println("000 ---> " + stu.toString());
        test11_2(stu);
        System.out.println("001 ---> " + stu.toString());
    }

    public void test11_2(Student stu) {
        System.out.println(stu.hashCode());
        System.out.println("111 : " + stu.toString());
        stu.age = 20;
        System.out.println("222 : " + stu.toString());
    }

    @Test
    public void test10() {
        String urlStr = "http://report.meituan.com";
        String req_id = UUID.randomUUID().toString();
        String refer_req_id = UUID.randomUUID().toString();
        long tm = System.currentTimeMillis();
        long seq = new Random().nextInt(1000) + 1000;
        String requestData = "[{\"buildid\":\"9611\",\"ch\":\"om_sd_wandoujia\",\"localId\":\"fd589dd48ede7a448ed5d3d4453797019e8d8e8d853842e1f0\",\"ct\":\"android\",\"union_id\":\"c647c95da1664ae89ba0381c29b03a56a159806775432156574\",\"dpid\":\"c647c95da1664ae89ba0381c29b03a56a159806775432156574\",\"sdk_ver\":\"4.8.2\",\"locate_city_id\":\"2\",\"imei\":\"865166024163019\",\"bht\":\"off\",\"msid\":\"8651660241630191610799366979\",\"dm\":\"SM-G9750\",\"sc\":\"960*540\",\"apn\":\"wifi\",\"lch\":\"dianping_nova\",\"imsi\":\"460001640623566\",\"android_id\":\"b35517406764bf51\",\"mno\":\"中国移动\",\"iccid\":\"89860081133720371180\",\"wifi\":\"on\",\"cityid\":\"1\",\"did\":\"865166024163019\",\"mac\":\"7D:C7:a0:EF:79:50\",\"sn\":\"00bcd90e\",\"version_code\":\"9611\",\"app\":\"9.6.12\",\"net\":\"WIFI\",\"os\":\"5.1.1\",\"osn\":\"ubuntu\",\"appnm\":\"dianping_nova\",\"brand\":\"samsung\",\"uid\":\"1653886869\",\"pushid\":\"0\",\"meid\":\"865166024163019\",\"category\":\"data_sdk_dianping_nova\",\"evs\":[{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"meishi_home\",\"val_act\":\"tap\",\"val_lab\":{\"title\":\"我爱吃\"},\"val_bid\":\"shopinfo_favoraddshop_tap\",\"element_id\":\"favoraddshop\",\"event_type\":\"click\",\"req_id\":" + "\"" + req_id + "\"" + ",\"refer_req_id\":" + "\"" + refer_req_id + "\"" + ",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":835}]}]";
        System.out.println(requestData);
        String response = new NetworkUtil().doPost(urlStr, requestData);
        System.out.println("response:\n" + response);
    }

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
