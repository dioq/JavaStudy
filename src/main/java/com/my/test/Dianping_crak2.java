package com.my.test;

import com.my.network.study05.NetworkUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Dianping_crak2 {
    private static String urlStr = "http://report.meituan.com/";
    private static int seq = 2140;
    private static String req_id = "";
    private static String refer_req_id = "";

    public static void main(String[] args) {
        req_id = UUID.randomUUID().toString().toUpperCase();
        refer_req_id = UUID.randomUUID().toString().toUpperCase();
        System.out.println(req_id);

        request1();
    }

    public static void request1() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; HD1900 Build/LYZ28N)");
        headers.put("Host", "report.meituan.com");

        String params = getLoginParams1();
        String response = new NetworkUtil().doPost(urlStr, params, headers);
        System.out.println("request1 : \n" + response);
        request2();
    }

    public static String getLoginParams1() {
        long tm = System.currentTimeMillis();
        String param = "[{\"buildid\":\"9611\",\"ch\":\"om_sd_wandoujia\",\"localId\":\"fd589dd48ede7a448ed5d3d4453797019e8d8e8d853842e1f0\",\"ct\":\"android\",\"union_id\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"dpid\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"sdk_ver\":\"4.8.2\",\"locate_city_id\":\"2\",\"imei\":\"865166021440469\",\"bht\":\"off\",\"msid\":\"8651660214404691612078475699\",\"dm\":\"HD1900\",\"sc\":\"960*540\",\"apn\":\"wifi\",\"lch\":\"dianping_nova\",\"imsi\":\"460001640623566\",\"android_id\":\"b35517406764bf51\",\"mno\":\"中国移动\",\"iccid\":\"89860081133720371180\",\"wifi\":\"on\",\"cityid\":\"1371\",\"did\":\"865166021440469\",\"mac\":\"7D:C7:a0:EF:79:50\",\"sn\":\"00bcd90e\",\"version_code\":\"9611\",\"app\":\"9.6.12\",\"net\":\"WIFI\",\"os\":\"5.1.1\",\"osn\":\"ubuntu\",\"appnm\":\"dianping_nova\",\"brand\":\"OnePlus\",\"uid\":\"1653886869\",\"pushid\":\"0\",\"meid\":\"865166021440469\",\"category\":\"data_sdk_dianping_nova\",\"evs\":[{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_act\":\"view\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_recommenddish_more_view\",\"element_id\":\"recommenddish_more\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_act\":\"view\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_recommenddish_more_view\",\"element_id\":\"recommenddish_more\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_act\":\"view\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_recommenddish_more_view\",\"element_id\":\"recommenddish_more\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_act\":\"view\",\"val_lab\":{\"biz_id\":\"word\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_recommenddish_user_view\",\"element_id\":\"recommenddish_user\",\"index\":\"0\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_act\":\"view\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_recommenddish_more_view\",\"element_id\":\"recommenddish_more\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_act\":\"view\",\"val_lab\":{\"biz_id\":\"word\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_recommenddish_user_view\",\"element_id\":\"recommenddish_user\",\"index\":\"0\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_food_shopaddressphone_view\",\"element_id\":\"food_shopaddressphone\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":4,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_headpic_view\",\"element_id\":\"headpic\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":4,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_reviewlist_view\",\"element_id\":\"reviewlist\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":4,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "}]},{\"buildid\":\"9611\",\"ch\":\"om_sd_wandoujia\",\"localId\":\"fd589dd48ede7a448ed5d3d4453797019e8d8e8d853842e1f0\",\"ct\":\"android\",\"union_id\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"dpid\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"sdk_ver\":\"4.8.2\",\"locate_city_id\":\"2\",\"imei\":\"865166021440469\",\"bht\":\"off\",\"msid\":\"8651660214404691612078475699\",\"dm\":\"HD1900\",\"sc\":\"960*540\",\"apn\":\"wifi\",\"lch\":\"dianping_nova\",\"imsi\":\"460001640623566\",\"android_id\":\"b35517406764bf51\",\"mno\":\"中国移动\",\"iccid\":\"89860081133720371180\",\"wifi\":\"on\",\"cityid\":\"1371\",\"did\":\"865166021440469\",\"mac\":\"7D:C7:a0:EF:79:50\",\"sn\":\"00bcd90e\",\"version_code\":\"9611\",\"app\":\"9.6.12\",\"net\":\"WIFI\",\"os\":\"5.1.1\",\"osn\":\"ubuntu\",\"appnm\":\"dianping_nova\",\"brand\":\"OnePlus\",\"uid\":\"1653886869\",\"pushid\":\"0\",\"meid\":\"865166021440469\",\"category\":\"data_sdk_meishi\",\"evs\":[{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_bid\":\"b_ZIadc\",\"element_id\":\"takeout_ai\",\"event_type\":\"view\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":0,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "}]}]";
        seq += 4;
        return param;
    }

    public static void request2() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; HD1900 Build/LYZ28N)");
        headers.put("Host", "report.meituan.com");

        String params = getLoginParams2();
        String response = new NetworkUtil().doPost(urlStr, params, headers);
        System.out.println("request2 : \n" + response);
        request3();
    }

    public static String getLoginParams2() {
        long tm = System.currentTimeMillis();
        String param = "[{\"buildid\":\"9611\",\"ch\":\"om_sd_wandoujia\",\"localId\":\"fd589dd48ede7a448ed5d3d4453797019e8d8e8d853842e1f0\",\"ct\":\"android\",\"union_id\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"dpid\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"sdk_ver\":\"4.8.2\",\"locate_city_id\":\"2\",\"imei\":\"865166021440469\",\"bht\":\"off\",\"msid\":\"8651660214404691612078475699\",\"dm\":\"HD1900\",\"sc\":\"960*540\",\"apn\":\"wifi\",\"lch\":\"dianping_nova\",\"imsi\":\"460001640623566\",\"android_id\":\"b35517406764bf51\",\"mno\":\"中国移动\",\"iccid\":\"89860081133720371180\",\"wifi\":\"on\",\"cityid\":\"1371\",\"did\":\"865166021440469\",\"mac\":\"7D:C7:a0:EF:79:50\",\"sn\":\"00bcd90e\",\"version_code\":\"9611\",\"app\":\"9.6.12\",\"net\":\"WIFI\",\"os\":\"5.1.1\",\"osn\":\"ubuntu\",\"appnm\":\"dianping_nova\",\"brand\":\"OnePlus\",\"uid\":\"1653886869\",\"pushid\":\"0\",\"meid\":\"865166021440469\",\"category\":\"data_sdk_dianping_nova\",\"evs\":[{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_favor_tap\",\"element_id\":\"favor\",\"event_type\":\"click\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":4,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "}]}]";
        seq++;
        return param;
    }


    public static void request3() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; HD1900 Build/LYZ28N)");
        headers.put("Host", "report.meituan.com");

        String params = getLoginParams3();
        String response = new NetworkUtil().doPost(urlStr, params, headers);
        System.out.println("request3 : \n" + response);
        request4();
    }

    public static String getLoginParams3() {
        long tm = System.currentTimeMillis();
        String param = "[{\"buildid\":\"9611\",\"ch\":\"om_sd_wandoujia\",\"localId\":\"fd589dd48ede7a448ed5d3d4453797019e8d8e8d853842e1f0\",\"ct\":\"android\",\"union_id\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"dpid\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"sdk_ver\":\"4.8.2\",\"locate_city_id\":\"2\",\"imei\":\"865166021440469\",\"bht\":\"off\",\"msid\":\"8651660214404691612078475699\",\"dm\":\"HD1900\",\"sc\":\"960*540\",\"apn\":\"wifi\",\"lch\":\"dianping_nova\",\"imsi\":\"460001640623566\",\"android_id\":\"b35517406764bf51\",\"mno\":\"中国移动\",\"iccid\":\"89860081133720371180\",\"wifi\":\"on\",\"cityid\":\"1371\",\"did\":\"865166021440469\",\"mac\":\"7D:C7:a0:EF:79:50\",\"sn\":\"00bcd90e\",\"version_code\":\"9611\",\"app\":\"9.6.12\",\"net\":\"WIFI\",\"os\":\"5.1.1\",\"osn\":\"ubuntu\",\"appnm\":\"dianping_nova\",\"brand\":\"OnePlus\",\"uid\":\"1653886869\",\"pushid\":\"0\",\"meid\":\"865166021440469\",\"category\":\"data_sdk_dianping_nova\",\"evs\":[{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"69239093\"},\"val_bid\":\"shopinfo_favor_tap\",\"element_id\":\"favor\",\"event_type\":\"click\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":4,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "}]}]";
        seq++;
        return param;
    }


    public static void request4() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; HD1900 Build/LYZ28N)");
        headers.put("Host", "report.meituan.com");

        String params = getLoginParams4();
        String response = new NetworkUtil().doPost(urlStr, params, headers);
        System.out.println("request4 : \n" + response);
    }

    public static String getLoginParams4() {
        long tm = System.currentTimeMillis();
        String param = "[{\"buildid\":\"9611\",\"ch\":\"om_sd_wandoujia\",\"localId\":\"fd589dd48ede7a448ed5d3d4453797019e8d8e8d853842e1f0\",\"ct\":\"android\",\"union_id\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"dpid\":\"6883bf8b4be841dfb539bf5f6e4c34bc0000000000000287317\",\"sdk_ver\":\"4.8.2\",\"locate_city_id\":\"2\",\"imei\":\"865166021440469\",\"bht\":\"off\",\"msid\":\"8651660214404691612078475699\",\"dm\":\"HD1900\",\"sc\":\"960*540\",\"apn\":\"wifi\",\"lch\":\"dianping_nova\",\"imsi\":\"460001640623566\",\"android_id\":\"b35517406764bf51\",\"mno\":\"中国移动\",\"iccid\":\"89860081133720371180\",\"wifi\":\"on\",\"cityid\":\"1371\",\"did\":\"865166021440469\",\"mac\":\"7D:C7:a0:EF:79:50\",\"sn\":\"00bcd90e\",\"version_code\":\"9611\",\"app\":\"9.6.12\",\"net\":\"WIFI\",\"os\":\"5.1.1\",\"osn\":\"ubuntu\",\"appnm\":\"dianping_nova\",\"brand\":\"OnePlus\",\"uid\":\"1653886869\",\"pushid\":\"0\",\"meid\":\"865166021440469\",\"category\":\"data_sdk_dianping_nova\",\"evs\":[{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"home\",\"val_act\":\"tap\",\"val_lab\":{\"title\":\"我爱吃\"},\"val_bid\":\"shopinfo_favoraddshop_tap\",\"element_id\":\"favoraddshop\",\"event_type\":\"click\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "}]}]";
        seq++;
        return param;
    }
}
