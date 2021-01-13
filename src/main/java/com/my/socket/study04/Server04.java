package com.my.socket.study04;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 在上面的例子中，服务端仅仅只是接受了一个Socket请求，并处理了它，然后就结束了，但是在实际开发中，一个Socket服务往往需要服务大量的Socket请求，
 * 那么就不能再服务完一个Socket的时候就关闭了，这时候可以采用循环接受请求并处理的逻辑：
 * */
public class Server04 {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 5200;
        ServerSocket server = new ServerSocket(port);
        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");

        //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        while (true) {
            Socket socket = server.accept();
            Runnable runnable = () -> {
                try {
                    // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    StringBuilder sb = new StringBuilder();
                    while ((len = inputStream.read(bytes)) != -1) {
                        // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                        sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
                    }
                    System.out.println("get message from client: " + sb);
                    inputStream.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            threadPool.submit(runnable);
        }

    }
}
