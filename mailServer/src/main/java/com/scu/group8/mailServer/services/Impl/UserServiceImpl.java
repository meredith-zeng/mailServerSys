package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.dao.UserMapper;
import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int login(User user) {
        return 0;
    }

    @Override
    public int logout(User user) {
        return 0;
    }

    @Override
    public int signUp(User user) {
        return 0;
    }
}
