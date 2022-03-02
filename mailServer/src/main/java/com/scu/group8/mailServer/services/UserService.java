package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserService {

    Result<User> selectUserById(int userId);
    Result<User> login(User record);
    Result<String> signUp(User record);

}
