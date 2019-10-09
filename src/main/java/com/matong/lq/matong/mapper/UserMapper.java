package com.matong.lq.matong.mapper;

import com.matong.lq.matong.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,pic_url) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified},#{pic_url}) ")
    public void insert(User user);
    @Select("select * from user where token=#{token}")
    public User selectUser(@Param("token") String token);
    @Insert("insert into user (account_id,name,gmt_create,gmt_modified,pic_url,password) values (#{account_id},#{name},#{gmt_create},#{gmt_modified},#{pic_url},#{password})")
    public void userRegister(User user);
    @Select("select * from user where name=#{name}")
    public User userLogin(@Param("name") String name);
}
