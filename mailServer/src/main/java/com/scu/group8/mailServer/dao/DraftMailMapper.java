package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.DraftMail;
import com.scu.group8.mailServer.vo.MailVo;

import java.util.List;

public interface DraftMailMapper {

    int insertSelective(DraftMail record);

    DraftMail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKey(DraftMail record);

    List<MailVo> queryDraftByOwnerId(Integer ownerId);
}