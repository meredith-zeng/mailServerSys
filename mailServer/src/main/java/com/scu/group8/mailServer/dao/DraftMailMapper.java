package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.DraftMail;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.vo.DraftVo;

import java.util.List;

public interface DraftMailMapper {

    int insertSelective(DraftMail record);

    DraftMail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKey(DraftMail record);

    List<DraftVo> queryDraftByOwnerId(Integer ownerId);
}