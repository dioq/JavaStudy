package com.base.Serializable.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.base.Serializable.protobuf.util.FileUtils;

public class Test2 {
    public static void main(String[] args) {
        // 把序列化的二进制本地文件里的所有二进制数据加载到内存, 然后反序列化成 java类
        byte[] bytes = FileUtils.readBytes_from_localFile("src/main/resources/serialize/person");

        try {
            //反序列化
            PersonProtos.Person decodePerson = PersonProtos.Person.parseFrom(bytes);
            System.out.println(decodePerson);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
