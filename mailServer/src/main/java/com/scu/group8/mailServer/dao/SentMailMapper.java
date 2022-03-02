package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.SentMail;
import com.scu.group8.mailServer.vo.MailVo;

import java.util.List;

public interface SentMailMapper {

    int insertSelective(SentMail record);

    SentMail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKeySelective(SentMail record);

    List<MailVo> queryOutboxMail(int ownerId);

    List<MailVo> queryDraftMail(int ownerId);
    
    int deleteOutboxMail(int mailId);

}