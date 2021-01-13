package com.my.Serializable.study03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务端接收到 二进制数据,然后反序列化成对象
 * */
public class SocketServer {

    public static void main(String[] args) {
        try {
            new SocketServer().test();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void test() throws IOException, ClassNotFoundException {
        System.out.println("Socket 服务端");
        //服务端监听端口
        ServerSocket server = new ServerSocket(9527);
        Socket socket = server.accept();
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Object o = is.readObject();
        is.close();
        server.close();
        System.out.println("传过来的内容，请收下：\n" + o);
    }
}
