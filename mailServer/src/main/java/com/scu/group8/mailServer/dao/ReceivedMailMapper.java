package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.ReceivedMail;
import com.scu.group8.mailServer.vo.MailVo;

import java.util.List;

public interface ReceivedMailMapper {

    int insertSelective(ReceivedMail record);

    ReceivedMail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKeySelective(ReceivedMail record);

    int updateReadStatus(int mailId);

    int deleteMail(int mailId);

    List<MailVo> queryInboxMail(int ownerId);

}