package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Insert("insert into user(username, password, create_time) values (#{username}, #{password}, now());")
    public Boolean add(User user);

    @Update("update user set nickname = #{nickname}, user_pic = #{userPic} where id = #{id};")
    public Boolean update(User user);


    @Select("select id, username, nickname, user_pic from user where username = #{username};")
    public User getUserInfo(String username);

    @Select("select id, username, password from user where username = #{username};")
    public User getPassword(String username);
}
