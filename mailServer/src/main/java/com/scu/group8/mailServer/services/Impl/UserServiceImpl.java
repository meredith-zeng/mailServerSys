package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.dao.UserMapper;
import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import com.scu.group8.mailServer.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> login(User user) {
        Result<User> result = new Result<>();
        User res = userMapper.selectByMailAddress(user.getUserEmailAddress());
        if (res == null){
            result.setResultFailed("Email Address not exist");
            return result;
        }
        if (res.getUserPassword().equals(user.getUserPassword())){
            result.setResultSuccess("Login success", res);
        }else{
            result.setResultFailed("Error password");
        }
        return result;
    }


    @Override
    public Result signUp(User record) {
        Result result = new Result<>();
        if (userMapper.selectByMailAddress(record.getUserEmailAddress()) != null){
            result.setResultFailed("Email Address exist");
            return result;
        }

        int insertRes = userMapper.insert(record);
        if (insertRes == 0){
            result.setResultFailed("User signup failed");
        }
        return result;
    }
}
