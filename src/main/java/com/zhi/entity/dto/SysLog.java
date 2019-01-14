package com.zhi.entity.dto;

import java.util.Date;

public class SysLog {

    private Long id;

    private String username; //用户名

    private String operation; //操作

    private String method; //方法名

    private String params; //参数

    private String ip; //ip地址

    private String createDate; //操作时间

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getOperation() {
        return operation;
    }

    public String getMethod() {
        return method;
    }

    public String getParams() {
        return params;
    }

    public String getIp() {
        return ip;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
