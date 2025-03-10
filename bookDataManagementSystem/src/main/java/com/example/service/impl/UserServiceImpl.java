package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean addUser(User user) {
        return userMapper.add(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.update(user);
    }

    @Override
    public User getUserInfo(String username) {
        return userMapper.getUserInfo(username);
    }

    @Override
    public User getPassword(String username) {
        return userMapper.getPassword(username);
    }
}
