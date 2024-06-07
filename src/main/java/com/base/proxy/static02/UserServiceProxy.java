package com.base.proxy.static02;

import com.base.proxy.UserService;

import java.util.Date;

public class UserServiceProxy implements UserService {
    private UserService target; // 被代理的对象

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    public void select() {
        before();
        target.select();    // 这里才实际调用真实主题角色的方法
        after();
    }

    public void update() {
        before();
        target.update();    // 这里才实际调用真实主题角色的方法
        after();
    }

    private void before() {     // 在执行方法之前执行
        System.out.printf("log start time [%s] %n", new Date());
    }

    private void after() {      // 在执行方法之后执行
        System.out.printf("log end time [%s] %n", new Date());
    }
}
