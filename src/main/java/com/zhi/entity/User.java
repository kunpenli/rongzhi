package com.zhi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 用户类
 */
public class User {
    private String id; //
    @JsonIgnore
    private String name; // 名称
    private String phone; // 电话
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imgs; // 头像
    private String email; // 电子邮箱

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getImgs() {
        return imgs;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
