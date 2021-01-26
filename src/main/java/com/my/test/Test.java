package com.my.test;

import java.net.URLEncoder;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.my.network.study05.NetworkUtil;
import org.json.JSONObject;

public class Test {

    private static String imei = "865166021440469";
    // 第一次安装app时生成的
    private static String kd = "b35517406764bf52";
    // 手机品牌
    private static String ds = "HD1901";
    private static String fd = "8838f2d3125b387f011a2c66860f5f53";

    private static String QC005 = imei + "678866";
    // imei + 系统版本号 + 时间戳
    private static String qd_sg = imei + "-7.10.0-1611243838531-";
    private static String aqyid = imei + "_" + kd + "_" + fd;

    private static String dfp = "";
    private static String envinfo_base64 = "";

    private static String email = "17683927310";
    private static String vcode = "4skf";
    private static String passwd = "Keh12wcgX5kJ0qdTkT2xqpcP%2B%2BTZrHtM5pay1kxBQrmidB4VTbsVVF0FCr9eAbSv3%2BB3ewsp2UhxG9N05Ez6ew%3D%3D";
    private static String passwd2 = "Keh12wcgX5kJ0qdTkT2xqpcP++TZrHtM5pay1kxBQrmidB4VTbsVVF0FCr9eAbSv3+B3ewsp2UhxG9N05Ez6ew==";

    public static void main(String[] args) {
        try {
            dfp = get_dfp();
            get_qd_sc_param();
            login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void login() {
        String urlStr = "https://passport.iqiyi.com/apis/reglogin/mobile_login.action";
        Map<String, String> headers = new HashMap<>();
        headers.put("t", "580892911");
        headers.put("sign", "fde81cb0fd964aa6113fb252857c0414");

        String params = getLoginParams();
        String response = new NetworkUtil().submitForm(urlStr, params, headers);
        System.out.println("login : \n" + response);
    }

    private static String getLoginParams() {
        String qd_sc = getQd_sc();
        String param = "qyidv2=0A12915C2BC9FC9E01FBB1D0C73EE08C&lon=116.416636&dfp=" + dfp + "&device_type=" + ds + "&requestType=26&qd_sc=" + qd_sc + "&checkExist=1&app_lm=cn&verifyPhone=1&passwd=" + passwd + "&imei=" + imei + "&lang=zh_CN&s3=unknow&QC005=" + QC005 + "&aqyid=" + aqyid + "&qd_sg=" + qd_sg + "&ptid=02022001010000000000&mac=" + fd + "&email=" + email + "&agenttype=163&s2=other&s4=unknow&vcode=" + vcode + "&app_version=7.10.0&device_id=" + imei + "&device_name=" + ds + "&envinfo=" + envinfo_base64 + "&lat=39.922704&";
        return param;
    }

    //这里放生成的qd_sc
    private static String getQd_sc() {
        String qd_sc = "533051dc2c2c92d8df99a8aa360e46bb";
        return qd_sc;
    }

    private static String get_qd_sc_param() {
        String param = "QC005=" + QC005 + "&agenttype=163&app_lm=cn&app_version=7.10.0&aqyid=" + aqyid + "&checkExist=1&device_id=" + imei + "&device_name=" + ds + "&device_type=" + ds + "&dfp=" + dfp + "&email=" + email + "&envinfo=" + envinfo_base64 + "&imei=" + imei + "&lang=zh_CN&lat=39.922704&lon=116.416636&mac=" + fd + "&passwd=" + passwd2 + "&ptid=02022001010000000000&qd_sg=" + qd_sg + "&qyidv2=0A12915C2BC9FC9E01FBB1D0C73EE08C&requestType=26&s2=other&s3=unknow&s4=unknow&vcode=" + vcode + "&verifyPhone=1";
        System.out.println("get_qd_sc_param : \n" + param);
        return param;
    }

    private static String get_dfp() throws UnsupportedEncodingException {
        String envinfo = envinfo();
        envinfo_base64 = Base64.getEncoder().encodeToString(envinfo.getBytes());
        String siga = siga(envinfo_base64 + "ANDROID4.0");
        String siga2 = siga.toUpperCase();

        String params = "dim=" + envinfo_base64 + "&dfp=&plat=ANDROID&ver=4.0&sig=" + siga2 + "&";
        System.out.println("params : \n" + params);
        // 这里拼接很关键
//        aqyid = imei + "_" + kd + "_" + fd;
        //先写死，便于测试
        long req_sn = 1611266429846L;//System.currentTimeMillis();
        String urlStr = "https://cook.iqiyi.com/security/dfp/sign?aqyid=" + aqyid + "&pps=0&pu=&cupid_uid=" + imei + "&secure_p=GPhone_comic&app_lm=cn&app_t=cartoon&app_k=20160006339e5641f72a58ab5a39a048&app_v=7.10.0&req_times=0&req_sn=" + req_sn;
        System.out.println("urlStr : \n" + urlStr);
        Map<String, String> headers = new HashMap<>();
        headers.put("t", "580892911");
        headers.put("sign", "fde81cb0fd964aa6113fb252857c0414");
        String response = new NetworkUtil().submitForm(urlStr, params, headers);
        System.out.println("get_dfp() : \n" + response);
        JSONObject jsong = new JSONObject(response);
        JSONObject result = jsong.getJSONObject("result");
        String dfp = result.getString("dfp");
//        System.out.println("dfp : \n" + dfp);
        return dfp;
    }

    public static String siga(String str) {
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(new SecretKeySpec("eade56028e252b77f7a0b8792e58b9cc".getBytes(), instance.getAlgorithm()));
            return m8057a(instance.doFinal(str.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String m8057a(byte[] bArr) {
        final char[] f6164a = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int b = bArr[i] & 255;
            cArr[i * 2] = f6164a[b >>> 4];
            cArr[(i * 2) + 1] = f6164a[b & 15];
        }
        return new String(cArr);
    }

    public static String envinfo() {
        String orgin = "{\"kv\":\"WiFi\",\"kd\":\"" + kd + "\",\"fu\":\"com.qiyi.video\",\"ol\":\"\",\"se\":\"360704\",\"ot\":\"3564580\",\"ds\":\"" + ds + "\",\"fv\":\"OnePlus\",\"dn\":\"[114.114.114.114, 114.114.115.115]\",\"ju\":\"LYZ28N\",\"qf\":\"4.0\",\"yy\":\"1611254640406\",\"lw\":\"172.16.2.6\",\"eh\":\"360704\",\"py\":\"[x86, armeabi-v7a, armeabi]\",\"hl\":\"F3D4E5F2CF309F1BC9C1F2CFD415D07E\",\"mg\":\"4FB72B1C36687D726A07D9F0CB76F98B\",\"no\":\"D41D8CD98F00B204E9800998ECF8427E\",\"wj\":\"-403791872\",\"yt\":\"[1.5,960,540,240.0,240.0]\",\"mr\":\"360704\",\"mm\":\"595759595959\",\"gp\":\"\",\"hr\":\"yuyu,00:81:2d:c6:db:02\",\"kp\":\"70698\",\"wh\":\"OnePlus\",\"xm\":\"D41D8CD98F00B204E9800998ECF8427E\",\"ed\":\"1920\",\"la\":\"\",\"mw\":\"5.1.1\",\"wd\":\"aosp\",\"ce\":\"true\",\"ks\":\"2976198656\",\"ak\":\"\",\"tz\":\"android_x86\",\"fd\":\"" + fd + "\",\"wl\":\"" + ds + "\",\"zv\":\"02%3a00%3a00%3a00%3a00%3a00\",\"ul\":\"" + ds + "\",\"qd\":\"[00:81:2d:c6:db:02,\\\"yuyu\\\"]\",\"zs\":\"[]\",\"sy\":\"[5,100]\",\"kl\":\"bfab9fa9-fc1f-47f9-9915-a6082b485199\",\"xv\":\"460001640623566\",\"wa\":\"[GMT+08:00,Asia\\/Shanghai]\",\"sp\":\"15833714688\",\"ps\":\"756748\",\"go\":\"7.10.0\",\"jd\":\"102\",\"mo\":\"595951586157\",\"zc\":\"" + imei + "\",\"ae\":\"ANDROID\"}";
        return orgin;
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
//            return new String(Base64.encode(instance.doFinal(bytes), 2), "UTF-8");
            String result = Base64.getEncoder().encodeToString(instance.doFinal(bytes));
            return result;
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | UnsupportedEncodingException | InvalidKeySpecException | IllegalBlockSizeException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }
}
