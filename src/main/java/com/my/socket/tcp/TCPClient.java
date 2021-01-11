package com.my.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        String ip = "103.100.211.187";
        int port = 8848;

        try {
            Socket socket = new Socket(ip, port);

            String content = "这是一个java模拟客户端 - 10000";
            byte[] bsteam = content.getBytes("GBK");
            OutputStream os = socket.getOutputStream();
            os.write(bsteam);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
