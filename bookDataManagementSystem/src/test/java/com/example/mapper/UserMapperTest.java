package com.example.mapper;

import com.example.config.SpringConfig;
import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void testAdd() {
//        User user = new User("zs", "123456", "张三");
//        userMapper.add(user);
//    }

    @Test
    public void testSelect() {
        User user1 = userMapper.getUserInfo("admin");
        User user2 = userMapper.getPassword("admin");
        System.out.println(user1);
        System.out.println(user2);
    }
}
