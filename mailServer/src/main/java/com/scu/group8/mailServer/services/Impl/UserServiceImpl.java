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
    public Result login(User user) {
        Result<User> result = new Result<>();
        User res = userMapper.selectByMailAddress(user.getUserEmailAddress());
        if (res == null){
            result.setIsSuccess("Email Address not exist", false);
            return result;
        }
        if (res.getUserPassword().equals(user.getUserPassword())){
            result.setIsSuccess("Login success", true);
        }else{
            result.setIsSuccess("Error password", false);
        }
        return result;
    }


    @Override
    public Result signUp(User user) {
        Result<User> result = new Result<>();
        User res = userMapper.selectByMailAddress(user.getUserEmailAddress());
        if (res != null){
            result.setIsSuccess("Email Address exist", false);
            return result;
        }
        if (userMapper.insert(user) == 1){
            result.setIsSuccess("Signup success", true);;
        }
        return result;
    }

    @Override
    public Result isLogin(HttpSession session) {
        Result result = new Result();
        User sessionUser = (User) session.getAttribute(UserController.SESSION_NAME);
        if (sessionUser == null){
            result.setIsSuccess("Don't login yet", false);
            return result;
        }
        User getUser = userMapper.selectByMailAddress(sessionUser.getUserEmailAddress());
        if (getUser == null || !getUser.getUserPassword().equals(sessionUser.getUserPassword())){
            result.setIsSuccess("User Info invalid", false);
            return result;
        }
        result.setIsSuccess("User login", true);
        return result;
    }

}
