package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.dao.UserMapper;
import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectUserById(int userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public List<User> allUser() {
        return userMapper.allUser();
    }
}