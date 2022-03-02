package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import com.scu.group8.mailServer.utils.Result;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest{
    @Autowired
    private UserService userService;

    @Test
    public void testLogin() {
        User user = new User();
        String emailArr = "nakano1968@yahoo.com";
        String rightPassword = "EscJo7fJ2k";
        String errorPassword = "123456";
        user.setUserEmailAddress(emailArr);
//        user.setUserPassword(rightPassword);
        user.setUserPassword(errorPassword);

        Result result = userService.login(user);
        System.out.println(result.getMessage());
    }

    @Test
    public void testSignUp() {
        User user = new User();
        String existEmailArr = "nakano1968@yahoo.com";
        String newEmailArr = "123@qq.com";
        String password = "123456";
//        user.setUserEmailAddress(existEmailArr);
        user.setUserEmailAddress(newEmailArr);
        user.setUserPassword(password);

        Result result = userService.signUp(user);
        System.out.println(result.getMessage());
    }
}