package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.controller.UserController;
import com.scu.group8.mailServer.dao.UserMapper;
import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import com.scu.group8.mailServer.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> selectUserById(int userId) {
        Result<User> result = new Result<>();
        User res= userMapper.selectByPrimaryKey(userId);
        if (res != null){
            result.setResultSuccess("selectUserById success", res);
        }else {
            result.setResultFailed("selectUserById error");
        }
        return result;
    }

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
        if (userMapper.insert(record) == 1){
            result.setResultSuccess("Signup success", "");
        }
        return result;
    }

    @Override
    public Result isLogin(HttpSession session) {
        Result result = new Result();
        User sessionUser = (User) session.getAttribute(UserController.SESSION_NAME);
        if (sessionUser == null){
            result.setResultFailed("Don't login yet");
            return result;
        }
        User getUser = userMapper.selectByMailAddress(sessionUser.getUserEmailAddress());
        if (getUser == null || !getUser.getUserPassword().equals(sessionUser.getUserPassword())){
            result.setResultFailed("User Info invalid");
            return result;
        }
        result.setResultSuccess("User login", "");
        return result;
    }

}
