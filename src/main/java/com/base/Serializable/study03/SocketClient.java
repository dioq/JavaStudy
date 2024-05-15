package com.base.Serializable.study03;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * 将一个对象序列化后，将二进制数据通过socket传到 服务端。
 * */
public class SocketClient {

    public static void main(String[] args) {
        try {
            new SocketClient().test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test() throws IOException {
        System.out.println("Socket 客户端");
        // 构建一个对象
        User user = new User("陈本布衣", "123456", 100);
        Menu menu = new Menu(1, "菜单1", "/menu1");
        Menu menu2 = new Menu(2, "菜单2", "/menu2");
        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        menus.add(menu2);
        user.setMenus(menus);

        // 与服务端建立连接
        Socket client = new Socket("127.0.0.1", 9527);
        ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
        // 往服务写数据
        os.writeObject(user);
        os.close();
    }
}
