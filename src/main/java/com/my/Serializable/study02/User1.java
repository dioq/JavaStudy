package com.my.Serializable.study02;

import java.io.Serializable;

public class User1 {
    private static final long serialVersionUID = -1075318769295234057L;
    public String name = "";
    public int gender = 0;
    public int age = 0;

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
