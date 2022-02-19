package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest{
@Autowired
UserService userService;

    @Test
    public void testSelectUserById() {
        User user = userService.selectUserById(1);
        System.out.println(user.getUserEmailAddress());
    }

    @Test
    public void testLogin() {
    }

    @Test
    public void testLogout() {
    }

    @Test
    public void testSignUp() {
    }
}