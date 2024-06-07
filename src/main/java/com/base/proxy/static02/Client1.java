package com.base.proxy.static02;

import com.base.proxy.UserService;
import com.base.proxy.UserServiceImpl;

public class Client1 {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);

        proxy.select();
        proxy.update();
    }
}
