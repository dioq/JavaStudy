import com.my.network.study05.NetworkUtil;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

public class Dianping {

    //收藏
    @Test
    public void collection() {
        String urlStr = "http://report.meituan.com";
        String requestData = getParam();
        System.out.println(requestData);
        String response = new NetworkUtil().doPost(urlStr, requestData);
        System.out.println("response:\n" + response);
    }

    public String getParam() {
        String req_id = UUID.randomUUID().toString();
        String refer_req_id = UUID.randomUUID().toString();
        long tm = System.currentTimeMillis();
        long seq = new Random().nextInt(1000) + 1000;
        String param = "[{\"buildid\":\"9611\",\"ch\":\"om_sd_wandoujia\",\"localId\":\"fd589dd48ede7a448ed5d3d4453797019e8d8e8d853842e1f0\",\"ct\":\"android\",\"union_id\":\"c647c95da1664ae89ba0381c29b03a56a159806775432156574\",\"dpid\":\"c647c95da1664ae89ba0381c29b03a56a159806775432156574\",\"sdk_ver\":\"4.8.2\",\"locate_city_id\":\"2\",\"imei\":\"865166024163019\",\"bht\":\"off\",\"msid\":\"8651660241630191610799366979\",\"dm\":\"SM-G9750\",\"sc\":\"960*540\",\"apn\":\"wifi\",\"lch\":\"dianping_nova\",\"imsi\":\"460001640623566\",\"android_id\":\"b35517406764bf51\",\"mno\":\"中国移动\",\"iccid\":\"89860081133720371180\",\"wifi\":\"on\",\"cityid\":\"1371\",\"did\":\"865166024163019\",\"mac\":\"7D:C7:a0:EF:79:50\",\"sn\":\"00bcd90e\",\"version_code\":\"9611\",\"app\":\"9.6.12\",\"net\":\"WIFI\",\"os\":\"5.1.1\",\"osn\":\"ubuntu\",\"appnm\":\"dianping_nova\",\"brand\":\"samsung\",\"uid\":\"1653886869\",\"pushid\":\"0\",\"meid\":\"865166024163019\",\"category\":\"data_sdk_dianping_nova\",\"evs\":[{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"suggest\",\"val_lab\":{\"checkin_id\":\"0\",\"shop_id\":\"9823338\"},\"val_bid\":\"shopinfo_favor_tap\",\"element_id\":\"favor\",\"event_type\":\"click\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":4,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "},{\"nm\":\"mge\",\"val_cid\":\"shopinfo\",\"val_ref\":\"suggest\",\"val_act\":\"tap\",\"val_lab\":{\"title\":\"我爱吃\"},\"val_bid\":\"shopinfo_favoraddshop_tap\",\"element_id\":\"favoraddshop\",\"event_type\":\"click\",\"req_id\":\"" + req_id + "\",\"refer_req_id\":\"" + refer_req_id + "\",\"isauto\":1,\"nt\":1,\"tm\":" + tm + ",\"report_num\":0,\"lat\":\"39.915\",\"lng\":\"116.404\",\"seq\":" + seq + "]}]";
        return param;
    }
}
