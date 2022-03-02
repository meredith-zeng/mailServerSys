package com.scu.group8.mailServer.utils;

import com.scu.group8.mailServer.pojo.User;

import javax.servlet.http.HttpServletRequest;

public class Session {
    private static final String SESSION_NAME = "userInfo";

    public static User getUserInfo(HttpServletRequest request) {
        return (User)request.getSession().getAttribute(SESSION_NAME);
    }

    public static void setUserInfo(HttpServletRequest request, User user) {
        request.getSession().setAttribute(SESSION_NAME, user);
    }
}
