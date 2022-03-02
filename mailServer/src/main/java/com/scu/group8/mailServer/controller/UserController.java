package com.scu.group8.mailServer.controller;

import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/signup",method= RequestMethod.POST)
    public Result<String> register(@RequestBody @Valid User user, BindingResult errors) {
        Result<String> result = new Result<>();
        // Error Handler
        if (errors.hasErrors()) {
            result.setResultFailed(errors.getFieldError().getDefaultMessage());
            return result;
        }
        return userService.signUp(user);
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Result<User> login(@RequestBody @Valid User user, BindingResult errors, HttpServletRequest request) {
        Result<User> result = new Result<>();
        if (errors.hasErrors()) {
            result.setResultFailed(errors.getFieldError().getDefaultMessage());
            return result;
        }
        result = userService.login(user);
        // set session
        if (result.isSuccess()) {
            Session.setUserInfo(request, result.getData());
        }
        return result;
    }

    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public Result<String> logout(HttpServletRequest request) {
        Result<String> result = new Result<>();
        Session.setUserInfo(request, null);
        result.setResultSuccess("Logout success", "");
        return result;
    }

    @RequestMapping(value="/info",method= RequestMethod.GET)
    public Result<User> getUserInfo(HttpServletRequest request) {
        Result<User> result = new Result<>();
        User user = Session.getUserInfo(request);

        if(user == null) {
            result.setResultFailed("Userinfo is null");
        } else {
            result.setResultSuccess("get user info success", user);
        }

        return result;
    }
}
