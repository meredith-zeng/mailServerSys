package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.ReceivedMail;

public interface ReceivedMailMapper {

    int insertSelective(ReceivedMail record);

    ReceivedMail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKeySelective(ReceivedMail record);

}