package com.my.network.study04;

import com.my.network.SSLUtil.SSLTrustWhich;
import org.json.JSONException;
import org.json.JSONObject;
import com.my.network.SSLUtil.SSLConfig;

public class Test {

    public static void main(String[] args) {
        SSLConfig.set(SSLTrustWhich.TrustAll);
//        get_http_func();
//        get_https_func();
//        post_func();
        login();
    }

    public static void login() {
        String urlStr = "https://passport.iqiyi.com/apis/reglogin/mobile_login.action";
        String param = "qyidv2=68D55AA7B1AF719DB6CA7A4D7245272E&lon=106.822809&dfp=15459ee2a7f62a053382fbfffef141d6f63454ccc9b2d307ab7939c096cefc978b&device_type=oppo&wsc_ldt=oppo&fromSDK=21&qd_sc=524a806880b7fd7c459913872e70a527&wsc_lgt=&wsc_sid=4233&checkExist=1&v=1&app_lm=cn&wsc_sp=&verifyPhone=1&appVersion=8.10.0&wsc_imei=864668064626842&passwd=eAdcr2%2Bn%2BELkAoWZf46EJFWIJnKYUOh16R%2FMwzQCMCTE1XLgLI5Z1nevpCkdjmN7Eug9DOAOoChFEQ7fsIhaPQ%3D%3D&imei=864668064626842&lang=zh_CN&hfvc=95&s3=unknow&wsc_st=8.10.0&wsc_cc=&slidetoken=&slide=&QC005=68D55AA7B1AF719DB6CA7A4D7245272E1610735949146&wsc_ost=14&wsc_isc=404040402888422&qd_sg=864668064626842-8.10.0-1610735949146-&ptid=02023031010000000000&wsc_osl=zh&mac=6f731b041cf1762f60daf2cdeb02b327&area_code=86&email=13006632594&agenttype=163&wsc_sm=92-76-24-f6-37-59&wsc_tt=02&s2=other&s4=unknow&wsc_iip=&vcode=w6bg&app_version=8.10.0&device_id=864668064626842&fields=userinfo%2Cqiyi_vip%2Cqiyi_tennis_vip%2Cfun_vip%2Csport_vip&device_name=oppo&envinfo=eyJhYSI6IjgwMDgxMDAwMCIsImJnIjoiODY0NjY4MDY0NjI2ODQyIiwiYmIiOiJhc3VzXC9hbmRyb2lkX3g4NlwveDg2OjUuMS4xXC9MTVk0N0lcLzguMy4xOTp1c2VyXC9yZWxlYXNlLWtleXMiLCJhayI6IiIsInFmIjoiNi4wIiwiZnUiOiJjb20ucWl5aS52aWRlby5jaGlsZCIsImtsIjoiZDllNDI4NTMtNWYwMi1lNjhmLWY1NjY5OTEwZmE0YWJiMzgiLCJnbyI6IjguMTAuMCIsIm9sIjoiIiwiYWIiOiJUWDdxdkxmZk04UkJ3SkJkN3MzNjVoRGNuS0t5RXJsSE9XSW16OTlHVGdzNC95U0VBTS8zVktTaTMzbU90SlZsR0tPSjNXRkRNL285b3RTU1VKMWFhTGFpSENFUjgzVmx6N0NZc05uUVhFLzlyWEgyMStidGhnV3VxUWRXYUQvclgybnRDcGk3WXZ5ZXNJUy9yZHFPK1ZVdTJrZXZ0TkZmTnl1ZXRwbU9jamNiZnVLQ1UzOHlOdmZrRHM4VDIrVDhTRTRCVlU1ajN1SGxpclIrMlRodGhRdSs1cmFmSVYrSUhDK0JXZ1hDR3lUaHhKbm53RTVwN0N1Vm5jQWJPWXlvWXZmaHJObWtCWVJ2RjlUY2dHYWdGQVpTbHdlTTE4V1VZMFFEZkpXcFpveG1QRGt5dnFINUJObnJLVnZvYnJmRy9Oay9OL3hoRXBJaGxDamVzaHdSOVhnSkgvTnVrR05TclhQT3pna2RRcUVsVUx4VERPZnU0UkNkOWRMUnVza1V1ODRHUmVaamJ3YitJRzQ4ZEs5dnRjTVc5akdtQUN2OFlBNElrTmd4Y2djd1BzVkxJQzZHNGxCS0FKMXMzRkJQRzJpR3dSYk5TK251UXZhM1pYWW5TbEE2ckJBalVhdy9KeVU2ODNPcHRuNTdIUG16b3o2cWJYS1RKZHNDRFVBTExQNFBBWDhLYnk4QjBtZlRTY1dqdzhISkFtNGkvUElFT3lJbTlJczdqd1RRTVZVNisrM0Fya1lqajZSUWJhNENrQmh4OVBubVQ1MEszV1YrSHFHMUhlTHVXeks4RnpQODlHbEt3VmRHYTdXZXVRTHEwWkNlMlVnZDdSOVNkNFFIeitWYzdGanpoM0JmK2FBcmxvalNuR3NkNThXL1dRcVY1TmdKd2gzSFJzaDZ3MHJPTmxjd25hTTdFSUh5amhoQUFhZG1PeGxFMjBya1NiT2tuZ3dvTm5ZL3cvWVptcGxSWE02eEhiNW1ENE1xeVRJQlFsQW1xN2lGaDVoaVRKSUg4MHk1V1BnSTJ6SHg4aGhQL1ppNWlkbjE1QUxwNEdJMWpuL21lVWZqUk93NHFSKzBUeG5XcjlLRVQrWjY4VFV0SkRJbXpsMVFIYVB4Ykg2TmE0TWJsWmtueng2T3BUVXVPT0JnckN6Um83VlArMzBHTEhZODRLeUE5cXpmaHZCcVRBcXFEVVhrV2RFNkRjZ0MwWEpmeWtYY3ZhN05nRXNXTnVvVURpc2VqV3MwQ1BlSFlxRzdKS0RhSEdMczlzUndQVWdrc0MrWUM2eWVEc0hHelpWK21nRXB0bDNJbHM2QkNUcUpCbzNDVGpDTGc3N3pzSFNLMVRuRmFpS0tWeTYxWHU1ZnIxVkRkdVB6QjZqMUNHMDFLTk9LTUUrSGdCRW5ObXVZMlViMjZldFJCNnFOYUQxL1phK2dPUzFGajFlZklvQWl5SXRxWmlZSHNIU2FrVW9UeURudjJpT1E4T1JvOU4yTzd3MHJGK3NmZnh3Qk1mazlISEkvSkNqbFJNc2lUMkFOVXlQR2hsR1RpdDBUNGFmVFlicjBNL0l1V2lyRTIwTjFuNDZWTXhLS1dhK0V6b3F5SGRXclF5NDV4ZWpzOHFJblZYL05SdTJvRndYdmZZcVRWRm5SQUdmZEdDbTZnVjZKUTR1R0NPaVlVWjFyK0E0T1F4bDNhdEU1NHR0cTZkV1hSZENyclF6RjFLTmNFaWdSd2FqUHNlUHFKdVROQ2JvWTBzbXFLVzAzRng2QXI0R0x2VDNqc0RzSGhUYXJwOFgzb2FuVm5xV1MxMGhOblhvMXNOV1pZTmtUN0xDQmRzZ0pNWURIdUFXTUIxMlVlT1VCRytYUlZSSjNUS3g2N000d0VhSmNieFpjWG9YUHpUTUNUdXdVQytVMkptNXFPYkFRL0JKZTA1WnVhSEtPTFdsc2hSUXdlemFCLzJ1RCt6YkhUSjM4OG1nT041dGlhS2V3Qm43ampxZVdnT3ZmdnliMUFYbTBlQ2ptYTFiQVE4M2ovcDlISUhqSUdaMUFGVkZobDQ3alYwL3Z1SXc0MGcrazVMcEMzNHluS2tUWTdiL0tGV2Jodi81bkhWZm9KMVhNbFZMUWVZWlJpRFM5UFI1Yk4wdmovR1ozV25NOEYzWUJVV0RPSFZrR0lTRXNzcXdxQjRhUE5oOW9xL0ZKMGlUV2ZIR3JuNURMVWR6KyJ9&wsc_istr=864668064626842&wsc_ltt=&lat=39.690462&";
        String response = new NetworkUtil(true).submitForm(urlStr, param);
        System.out.println("login response:\n" + response);
    }

    public static void get_http_func() {
        NetworkUtil networkUtil = new NetworkUtil(true);
        String urlStr = "http://test.abuyun.com/";
//        String urlStr = "http://www.anant.club:8848/getTest";
        String result = networkUtil.doGet(urlStr);
        System.out.println(result);
    }

    public static void get_https_func() {
        String urlStr = "https://www.anant.club:8081/getssl";
        String response = new NetworkUtil(true).doGet(urlStr);
        System.out.println("get_tls_func response:\n" + response);
    }

    public static void post_func() {
        String urlStr = "https://www.anant.club:8081/postssl";
        JSONObject param_json = new JSONObject();
        try {
            param_json.put("username", "Dio");
            param_json.put("password", "13131313");
            param_json.put("argot", "You are geat!");
            param_json.put("num", 1111);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String requestData = param_json.toString();
        String response = new NetworkUtil(true).doPost(urlStr, requestData);
        System.out.println("post_tls_func response:\n" + response);
    }

}
