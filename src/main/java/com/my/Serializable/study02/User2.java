package com.my.Serializable.study02;

import java.io.Serializable;

public class User2 implements Serializable {
    private static final long serialVersionUID = -1075319199295234057L;
    public User1 user1 = new User1();

    public String user2name = "";

    @Override
    public String toString() {
        return "User2{" +
                "user1=" + user1 +
                ", user2name='" + user2name + '\'' +
                '}';
    }
}
