package com.my.Serializable.study01;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//序列化和反序列化
public class SerialTest {

    public static void main(String[] args) {
        try {
            new SerialTest().test();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test() throws IOException, InterruptedException, ClassNotFoundException {
        /**
         * 基本步骤：
         * ① 对象实体类实现Serializable 标记接口
         * ② 创建序列化输出流对象ObjectOutputStream，该对象的创建依赖于其它输出流对象，通常我们将对象序列化为文件存储，所以这里用文件相关的输出流对象 FileOutputStream
         * ③ 通过ObjectOutputStream 的 writeObject()方法将对象序列化为文件
         */
        User user = new User("陈本布衣", "123456", 100);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("F:\\tmp\\user.java"));
        os.writeObject(user);
        os.close();


        //先睡5秒
        TimeUnit.SECONDS.sleep(5);

        /**
         * 基本步骤：
         * ① 创建输入流对象ObjectOutputStream。同样依赖于其它输入流对象，这里是文件输入流 FileInputStream
         * ② 通过 ObjectInputStream 的 readObject()方法，将文件中的对象读取到内存
         */
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("F:\\tmp\\user.java"));
        User o = (User) is.readObject();
        is.close();
        System.out.println(o);
        System.out.println("当前时间：" + new Date());
    }
}