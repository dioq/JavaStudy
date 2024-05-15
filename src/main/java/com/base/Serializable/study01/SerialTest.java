package com.base.Serializable.study01;

import java.io.*;
import java.util.concurrent.TimeUnit;

//序列化和反序列化
public class SerialTest {
    /*
    序列化与反序列化
    1) 序列化能保存的元素
    a) 只能保存对象的非静态成员变量
    b) 不能保存任何成员方法和静态的成员变量(只是保存属性)
    c) 不保存 transient 成员变量
    d) 如果一个对象的成员变量是一个对象，这个对象的成员变量也会保存
    e) 串行化保存的只是变量的值，对于变量的任何修饰符，都不能保存

    2) 使用对象流把一个对象写到文件时不仅保证该对象是序列化的，而且该对象的成员对象也必须是可序列化的。

    3) 如果一个可序列化的对象包含对某个不可序列化的对象的引用，那么整个序列化操作将会失败，并且会抛出一个
    NotSerializableException。我们可以将这个引用标记为transient，那么对象仍然可以序列化。


    对象序列化注意事项
    1) 同一个对象多次序列化的处理
    a) 所有保存到磁盘中的对象都有一个序列化编号
    b) 序列化一个对象中，首先检查该对象是否已经序列化过

    c) 如果没有，进行序列化
    d) 如果已经序列化，将不再重新序列化，而是输出编号即可

    2) 如果不希望某些属性（敏感）序列化，或不希望出现递归序列
    a) 为属性添加 transient 关键字（完成排除在序列化之外）
    b) 自定义序列化（不仅可以决定哪些属性不参与序列化，还可以定义属性具体如何序列化）

    3) 序列化版本不兼容
    a) 修改了实例属性后,会影响版本号，从而导致反序列化不成功
    b) 解 决 方 案 ： 为 Java 对 象 指 定 序 列 化 版 本 号serialVersionUID
    **/
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
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/main/resources/serialize/user.java"));
        os.writeObject(user);
        os.close();


        //先睡5秒
        TimeUnit.SECONDS.sleep(5);

        /**
         * 基本步骤：
         * ① 创建输入流对象ObjectOutputStream。同样依赖于其它输入流对象，这里是文件输入流 FileInputStream
         * ② 通过 ObjectInputStream 的 readObject()方法，将文件中的对象读取到内存
         */
//        ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/main/resources/serialize/user.java"));
//        User o = (User) is.readObject();
//        is.close();
//        System.out.println(o);
//        System.out.println("当前时间：" + new Date());
    }
}