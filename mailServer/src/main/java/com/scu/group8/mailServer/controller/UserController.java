package com.scu.group8.mailServer.controller;

import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.UserService;
import com.scu.group8.mailServer.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    public static final String SESSION_NAME = "userInfo";

    @Autowired
    private UserService userService;

    @RequestMapping(value="/signup",method= RequestMethod.POST)
    public Result<User> register(@RequestBody @Valid User user, BindingResult errors, HttpServletRequest request) {
        Result<User> result;
        // If there is an error in the verification, return the registration failure and error message
        if (errors.hasErrors()) {
            result = new Result<>();
            result.setResultFailed(errors.getFieldError().getDefaultMessage());
            return result;
        }
        // call signUp service
        result = userService.signUp(user);
        // If signUp is successful, set the session
        if (result.isSuccess()) {
            request.getSession().setAttribute(SESSION_NAME, result.getData());
        }
        return result;
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Result<User> login(@RequestBody @Valid User user, BindingResult errors, HttpServletRequest request) {
        Result<User> result;
        // If there is an error in the verification, return the login failure and error message
        if (errors.hasErrors()) {
            result = new Result<>();
            result.setResultFailed(errors.getFieldError().getDefaultMessage());
            return result;
        }
        result = userService.login(user);
        if (result.isSuccess()) {
            request.getSession().setAttribute(SESSION_NAME, result.getData().getUserId());
        }
        return result;
    }

    @RequestMapping(value="/isLogin",method= RequestMethod.GET)
    public Result<User> isLogin(HttpServletRequest request) {
        return userService.isLogin(request.getSession());
    }

    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public Result logout(HttpServletRequest request) {
        Result result = new Result();
        // User logout: The user information in the session can be set to null
        request.getSession().setAttribute(SESSION_NAME, null);
        result.setResultSuccess("Logout success", "");
        return result;
    }

    @RequestMapping(value="/info",method= RequestMethod.GET)
    public Result getUserInfo(HttpServletRequest request) {
        Result result = new Result();
        Object session = request.getSession().getAttribute(SESSION_NAME);

        if (session == null){
            result.setResultFailed("Userinfo is null");
            return result;
        }else {

            int sessionUserId = Integer.valueOf((Integer) session);
            return userService.selectUserById(sessionUserId);
        }

    }

}
