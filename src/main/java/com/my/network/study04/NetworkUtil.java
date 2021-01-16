package com.my.network.study04;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.UUID;

/*
 * http 和 https
 * 通过阿布云设置代理
 * */
public class NetworkUtil {

    private Proxy proxy = null;

    public NetworkUtil() {
    }

    public NetworkUtil(boolean isSetProxy) {
        if (isSetProxy) {
            setProxy();
        }
    }

    private void setProxy() {
        // JDK 8u111版本后，目标页面为HTTPS协议，启用proxy用户密码鉴权
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");

        // 代理隧道验证信息
        String proxyUser = "HW5RE145V8V4756D";
        String proxyPass = "4B2FDEB625EBB5EE";

        // 代理服务器
        String proxyServer = "http-dyn.abuyun.com";
        int proxyPort = 9020;
        Authenticator.setDefault(new ProxyAuthenticator(proxyUser, proxyPass));

        // 创建代理服务器地址对象
        InetSocketAddress addr = new InetSocketAddress(proxyServer, proxyPort);
        // 创建HTTP类型代理对象
        this.proxy = new Proxy(Proxy.Type.HTTP, addr);
    }

    //统一 判断是否要加SSL协议、代理地址
    private synchronized HttpURLConnection configSSLAndProxy(String urlStr) throws IOException {
        HttpURLConnection connection = null;
        URL url = new URL(urlStr);
        if (this.proxy != null) { //有代理就设置,没有就不设置(会走系统代理)
            if (url.getProtocol().toLowerCase().equals("https")) {//判断是http还是https
                //https.setHostnameVerifier(DO_NOT_VERIFY); //不验证域名是否和证书域名相等
                connection = (HttpsURLConnection) url.openConnection(this.proxy);
            } else {
                connection = (HttpURLConnection) url.openConnection(this.proxy);
            }
        } else {
            if (url.getProtocol().toLowerCase().equals("https")) {//判断是http还是https
                //https.setHostnameVerifier(DO_NOT_VERIFY); //不验证域名是否和证书域名相等
                connection = (HttpsURLConnection) url.openConnection();
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }
        }

        // 设置IP切换头
        connection.setRequestProperty("Proxy-Switch-Ip", "yes");

        connection.setConnectTimeout(8000);//连接最大时间
        connection.setReadTimeout(8000);//读取最大时间
        connection.setConnectTimeout(50000);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("User-Agent", "Android Client Agent");
        connection.setUseCaches(false);

        return connection;
    }

    /**
     * GET 请求
     *
     * @param urlStr 请求接口
     */
    public String doGet(String urlStr) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            connection = configSSLAndProxy(urlStr);

            connection.setRequestMethod("GET");
            //处理返回信息
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream(); //获取网络输入流 in
                reader = new BufferedReader(new InputStreamReader(in)); //转换成BufferedReader
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = response.toString();
            } else {
                result = connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

    /**
     * POST           restful接口        application/json
     *
     * @param urlStr 请求接口
     * @param param  参数
     */
    public String doPost(String urlStr, String param) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            connection = configSSLAndProxy(urlStr);

            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestMethod("POST");
            //--------------------------------
            connection.setDoOutput(true);//是否写入参数
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(param.getBytes());//把参数的二进制格式 直接写入到网络输出流outputStream中
            //--------------------------------
            //处理返回信息
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();//获取网络输入流 in
                reader = new BufferedReader(new InputStreamReader(in)); //转换成BufferedReader
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = response.toString();
            } else {
                result = connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

    /**
     * POST   普通表单提交 application/x-www-form-urlencoded
     *
     * @param urlStr 请求接口
     * @param param  参数
     */
    public String submitForm(String urlStr, String param) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            connection = configSSLAndProxy(urlStr);

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            //--------------------------------
            connection.setDoOutput(true);//是否写入参数
            connection.getOutputStream().write(param.getBytes());
            //--------------------------------
            //处理返回信息
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();//获取网络输入流 in
                reader = new BufferedReader(new InputStreamReader(in)); //转换成BufferedReader
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = response.toString();
            } else {
                result = connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

    //将参数 处理成form表单的特定格式
    public String getParams(HashMap<String, String> paramsMap) {
        String result = "";
        for (HashMap.Entry<String, String> entity : paramsMap.entrySet()) {
            result += "&" + entity.getKey() + "=" + entity.getValue();
        }
        return result.substring(1);
    }


    /**
     * POST 上传图片,如果文件是图片大多时候会有各种描述,二进制数据里掺杂有描述信息,需要用这个方法来上传。
     *
     * @param urlStr   上传接口
     * @param filePath 要上传的文件路径
     */
    public String uploadImage(String urlStr, String filePath) {
        System.out.println("============= 开始上传 =============");
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("待上传文件为空,请认真检查!");
            return null;
        }
        System.out.println("file length = " + file.length());
        System.out.println("file path = " + file.getAbsolutePath());
        String result = null;
        String BOUNDARY = UUID.randomUUID().toString().replace("-", "");
        String NewLine = "\r\n";//换行符

        HttpURLConnection connection = null;
        DataOutputStream bos = null;
        FileInputStream fis = null;
        DataInputStream bis = null;
        BufferedReader reader = null;
        try {
            connection = configSSLAndProxy(urlStr);

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "multipart/form-data; charset=utf-8; boundary=" + BOUNDARY);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setChunkedStreamingMode(1024 * 50);
            connection.connect();

            bos = new DataOutputStream(connection.getOutputStream());//网络输出流
            //---------------> 文件头描述信息
            bos.write(("--" + BOUNDARY).getBytes());//数据以--BOUNDARY开始
            bos.write(NewLine.getBytes());//换行
            String name = "file";//后台服务器根据这个名取到Request
            String content = String.format("Content-Disposition: form-data; name=%s; filename=%s", name, file.getName());
            bos.write(content.getBytes());
            bos.write(NewLine.getBytes());//换行
            bos.write(NewLine.getBytes());//换行
            //<--------------- 文件头描述信息
            fis = new FileInputStream(file);//建立待上传的本地文件的输入流
            bis = new DataInputStream(fis);//本地文件的输入流 转换成数据流
            byte[] buff = new byte[1024];
            int len = 0;
            //读取本地文件数据流bis中的数据  写进网络输出流bos
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            //---------------> 文件尾描述信息
            bos.write(NewLine.getBytes());//换行
            bos.write(("--" + BOUNDARY + "--").getBytes());//结束标志--BOUNDARY--
            bos.write(NewLine.getBytes());//换行
            //<--------------- 文件尾描述信息
            bos.flush();//把缓存在流中的数据刷出去(大部分情况下可以不要)

            //处理上传完图片后的返回数据
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();//获取网络输入流 in
                reader = new BufferedReader(new InputStreamReader(in)); //转换成BufferedReader
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = response.toString();
            } else {
                result = connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("============= 上传完成 =============");
        return result;
    }


    /**
     * POST 上传一个二进制文件,与上传图片的区别是不需要各种换行和描述。
     * 如果是图片,上传的二进制数据全是图片信息,把这些二进制数据后缀改成jpg/png就能直接以图片形式显示出来
     *
     * @param urlStr   上传接口
     * @param filePath 要上传的文件路径
     */
    public String uploadBinary(String urlStr, String filePath) {
        System.out.println("=============开始上传=============");
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("待上传文件为空,请认真检查!");
            return null;
        }
        System.out.println("file length = " + file.length());
        System.out.println("file path = " + file.getAbsolutePath());

        HttpURLConnection connection = null;
        DataOutputStream bos = null;
        FileInputStream fis = null;
        DataInputStream bis = null;
        BufferedReader reader = null;
        String result = null;
        try {
            connection = configSSLAndProxy(urlStr);

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "multipart/form-data; charset=utf-8");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setChunkedStreamingMode(1024 * 50);
            connection.connect();

            bos = new DataOutputStream(connection.getOutputStream());//网络输出流
            fis = new FileInputStream(file);//建立待上传的本地文件的输入流
            bis = new DataInputStream(fis);//本地文件的输入流 转换成数据流
            byte[] buff = new byte[1024];
            int len = 0;
            //读取  本地文件数据流bis中的数据  写进网络输出流bos
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            bos.flush();//把缓存在流中的数据刷出去(大部分情况下可以不要)

            //处理上传完文件后的返回数据
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();//获取网络输入流 in
                reader = new BufferedReader(new InputStreamReader(in)); //转换成BufferedReader
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = response.toString();
            } else {
                result = "http is failed.  " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("=============开始上传=============");
        return result;
    }

}
