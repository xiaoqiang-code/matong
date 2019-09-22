package com.matong.lq.matong.ServiceImpl;

import com.matong.lq.matong.entity.User;
import com.matong.lq.matong.mapper.UserMapper;
import com.matong.lq.matong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/21 19:28
 * @Version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;

    @Override
    public void insert(String account_id, String name, String token, String gmt_create, String gmt_modified) {
        User user=new User();
        user.setAccount_id(account_id);
        user.setName(name);
        user.setToken(token);
        user.setGmt_create(gmt_create);
        user.setGmt_modified(gmt_modified);
        userMapper.insert(user);
    }
}