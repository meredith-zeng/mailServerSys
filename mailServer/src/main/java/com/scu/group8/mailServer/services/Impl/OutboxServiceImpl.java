package com.scu.group8.mailServer.services.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.dao.MailMapper;
import com.scu.group8.mailServer.dao.SentMailMapper;
import com.scu.group8.mailServer.services.OutboxService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutboxServiceImpl implements OutboxService {
    @Autowired
    SentMailMapper sentMailMapper;
    @Autowired
    MailMapper mailMapper;

    @Override
    public Result<PageInfo<MailVo>> queryOutboxMail(int ownerId, int page, int pageSize, int sendStatus) {
        Result<PageInfo<MailVo>> result = new Result<>();
        PageHelper.startPage(page, pageSize);
        List<MailVo> mailVoList;

        if(sendStatus == 0) {
            mailVoList = sentMailMapper.queryDraftMail(ownerId);
        } else {
            mailVoList = sentMailMapper.queryOutboxMail(ownerId);
        }

        PageInfo<MailVo> pageInfo = new PageInfo<>(mailVoList);
        result.setResultSuccess("Query outbox email success", pageInfo);
        return result;
    }

    @Override
    public Result deleteOutboxMail(int mailId) {
        Result result = new Result();
        int deleteRes = sentMailMapper.deleteOutboxMail(mailId);
        if (deleteRes == 0){
            result.setResultFailed("Delete outbox mail fail");
        }
        result.setResultSuccess("Delete outbox mail success", " ");
        return result;
    }


}
