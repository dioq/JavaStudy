package com.my.Serializable.study02;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SerialTest {
    public static void main(String[] args) {
        try {
            new SerialTest().test();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test() throws IOException, InterruptedException, ClassNotFoundException {
        //序列化
        User user = new User("陈本布衣", "123456", 100);
        Menu menu = new Menu(1, "菜单1", "/menu1");
        user.setMenu(menu);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("F:\\tmp\\user.java"));
        os.writeObject(user);
        os.close();

        //先睡5秒
        TimeUnit.SECONDS.sleep(5);

        //反序列化
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("F:\\tmp\\user.java"));
        User o = (User) is.readObject();
        is.close();
        System.out.println(o);
        System.out.println("当前时间：" + new Date());
    }

}
