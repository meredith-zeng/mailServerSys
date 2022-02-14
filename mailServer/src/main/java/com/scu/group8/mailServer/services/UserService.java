package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.User;

import java.util.List;

public interface UserService {
    User selectUserById(int userId);
    List<User> allUser();
}
