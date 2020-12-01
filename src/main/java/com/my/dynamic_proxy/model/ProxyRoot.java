/**
 * Copyright 2020 json.cn
 */
package com.my.dynamic_proxy.model;

import java.util.List;

/**
 * Auto-generated: 2020-12-01 1:2:1
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class ProxyRoot {

    private String code;
    private String msg;
    private List<Obj> obj;
    private int errno;
    private List<String> data;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setObj(List<Obj> obj) {
        this.obj = obj;
    }

    public List<Obj> getObj() {
        return obj;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public int getErrno() {
        return errno;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

}