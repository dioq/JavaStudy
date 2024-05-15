package com.base.network_proxy.study02;

import com.base.network_proxy.study02.proxy.ProxyUtil;

public class Main {

    public static void main(String[] args) {
        if (ProxyUtil.proxy_check()) {
            System.out.println("代理设置成功,可以进行其他工作");
        } else {
            System.out.println("代理设置 失败!");
        }
    }

}
