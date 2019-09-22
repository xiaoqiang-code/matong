package com.matong.lq.matong.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/21 19:12
 * @Version 1.0
 */
public class User {
    private int id;
    private String account_id;
    private String name;
    private String token;
    private String gmt_create;
    private String gmt_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(String gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
}
