package com.matong.lq.matong.service;

import com.matong.lq.matong.entity.User;

public interface UserService {
    public void insert(String account_id,String name,String token,String gmt_create,String gmt_modified,String pic_url);
    public User selectUser(String token);
    public void userRegister(String account_id,String name,String gmt_create,String gmt_modified,String pic_url,String password);
    public User userLogin(String name);
}
