package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.User;

public interface UserService {

    User selectUserById(int userId);
    int login(User user);
    int logout(User user);
    int signUp(User user);

}
