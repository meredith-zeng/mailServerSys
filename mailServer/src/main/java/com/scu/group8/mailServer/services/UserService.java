package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.utils.Result;

public interface UserService {
    Result<User> login(User record);
    Result signUp(User record);
}
