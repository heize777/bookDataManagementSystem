package com.example.service;

import com.example.config.SpringConfig;
import com.example.model.User;
import com.example.utils.ProjectUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetPassword() {
        User user = userService.getPassword("1");
        System.out.println(user);
    }

    @Test
    public void testJwt() {
        User user = new User();
        user.setId(1);
        user.setUsername("zs");
        String token = ProjectUtil.generateJwt(user);
        System.out.println(token);
    }

}
