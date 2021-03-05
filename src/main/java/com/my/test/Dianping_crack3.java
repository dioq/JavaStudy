package com.my.test;

import com.my.bytes.BytesHexUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

public class Dianping_crack3 {

    public static void main(String[] args) throws IOException {
        String postbody = "applogjson=[{\"app_type\":\"1\",\"element_id\":\"pageview\",\"event_type\":\"view\",\"shop_id\":\"124576618\",\"page_name\":\"shopinfo%3Fid%3D124576618\",\"refer_page_name\":\"shopinfo%3Fid%3D124576618\",\"request_id\":\"220c4bc0-8c1c-42f9-80f2-2ae509f8583b\",\"refer_request_id\":\"527a680f-a9cc-4345-aae8-412edb6159f9\",\"timestamp\":\"1614870192159\",\"city_id\":\"1\",\"locate_city_id\":\"7\",\"longitude\":\"22.6728638607066\",\"latitude\":\"113.80681561597275\",\"app_version\":\"7.8.0\",\"app_market\":\"om_sd_uc\",\"platform\":\"Android\",\"platform_version\":\"5.1.1\",\"manufacture\":\"HUAWEI\",\"model\":\"TAS-AL00\",\"mac\":\"00%3A81%3A87%3A5b%3A50%3A01\",\"imei\":\"865166024926258\",\"uuid\":\"df103360-c9c0-4f10-be0f-9e7e79317ce9\",\"userid\":\"1358016010\",\"dpid\":\"4069813693143497996\",\"network\":\"wifi\",\"log_id\":\"cdd77a82-cfe6-4c6e-97eb-ee1bbc27f230\"}]";
        InputStream inputStream = compress(postbody);
        int len = inputStream.available();
        byte[] buff = new byte[len];
        inputStream.read(buff,0,len);

        String hex_str = BytesHexUtil.byteToHex(buff);
        System.out.println("hex_str:\n" + hex_str);

//        FormInputStream formInputStream = new FormInputStream(inputStream);
        new FormInputStream();
    }

    public static InputStream compress(String string) throws IOException {
        byte[] source = string.getBytes("UTF-8");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(source);
        gzip.finish();
        gzip.close();
        byte[] result = bos.toByteArray();
        bos.close();

//        String hex_str = BytesHexUtil.byteToHex(result);
//        System.out.println("hex_str:\n" + hex_str);
        return new MApiFileInputStream(new ByteArrayInputStream(result));
    }

}
