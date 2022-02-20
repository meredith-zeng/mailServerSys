package com.scu.group8.mailServer.pojo;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userEmailAddress;
    private String userPassword;
}