package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.SentMail;

public interface SentMailMapper {

    int insertSelective(SentMail record);

    SentMail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKeySelective(SentMail record);

}