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
@Data
public class User {
    private int id;
    private String account_id;
    private String name;
    private String token;
    private String gmt_create;
    private String gmt_modified;
    private String pic_url;
    private String password;
}
