package com.base.uuid;

import java.util.UUID;

public class Study01 {
    public static void main(String[] args) {
       String uuid =  UUID.randomUUID().toString().replace("-", "").toUpperCase();
       System.out.println(uuid);
    }
}
