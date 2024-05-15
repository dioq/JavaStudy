package com.base.socket.study03;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*
* 以先指定后续命令的长度，然后读取指定长度的内容做为客户端发送的消息。
* */
public class Server03 {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 5200;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes;
        // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
        while (true) {
            // 首先读取两个字节表示的长度
            int first = inputStream.read();
            //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
            if (first == -1) {
                break;
            }
            int second = inputStream.read();
            int length = (first << 8) + second;
            // 然后构造一个指定长的byte数组
            bytes = new byte[length];
            // 然后读取指定长度的消息即可
            inputStream.read(bytes);
            System.out.println("get message from client: " + new String(bytes, StandardCharsets.UTF_8));
        }
        inputStream.close();
        socket.close();
        server.close();
    }
}
