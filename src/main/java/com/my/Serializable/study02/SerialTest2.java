package com.my.Serializable.study02;

import com.my.Serializable.study01.User;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SerialTest2 {
    public static void main(String[] args) throws InterruptedException {
        User1 user1 = new User1();
        user1.name = "Dio";
        user1.gender = 1;
        user1.age = 18;

        User2 user2 = new User2();
        user2.user1 = user1;
        user2.user2name = "JOJO";

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("F:\\tmp\\user2.java"))) {
            os.writeObject(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //先睡5秒
        TimeUnit.SECONDS.sleep(5);


        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("F:\\tmp\\user2.java"))) {
            User2 o = (User2) is.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
