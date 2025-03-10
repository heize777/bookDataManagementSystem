package com.example.service;

import com.example.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return Boolean
     * @description
     **/
    public Boolean addUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return Boolean
     * @description
     **/
    public Boolean updateUser(User user);

    /**
     * 获取用户信息
     * @param username
     * @return User
     * @description
     **/
    public User getUserInfo(String username);

    /**
     * 获取用户账户密码
     * @param username
     * @return User
     * @description
     **/
    public User getPassword(String username);
}
