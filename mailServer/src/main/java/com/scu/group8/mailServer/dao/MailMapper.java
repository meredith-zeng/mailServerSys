package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.Mail;

public interface MailMapper {

    int insertSelective(Mail record);

    Mail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKeySelective(Mail record);

}