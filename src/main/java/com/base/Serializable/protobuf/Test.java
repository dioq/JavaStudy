package com.base.Serializable.protobuf;

import com.base.Serializable.protobuf.util.BytesHexUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //序列化
        PersonProtos.Person.Builder builder = PersonProtos.Person.newBuilder();
        builder.setId(1001)
                .setAge(25)
                .setName("dong")
                .setSex("man");
        PersonProtos.Person person = builder.build();
        byte[] bytes = person.toByteArray();
        System.out.println(Arrays.toString(bytes));
        String hexStr = BytesHexUtil.byteToHex(bytes);
        System.out.println(hexStr);

        try {
            //反序列化
            PersonProtos.Person decodePerson = PersonProtos.Person.parseFrom(bytes);
            System.out.println(decodePerson);

            //生成序列化文件
            OutputStream os = new FileOutputStream("src/main/resources/serialize/person");
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
