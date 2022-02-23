package com.scu.group8.mailServer.services.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.dao.MailMapper;
import com.scu.group8.mailServer.dao.SentMailMapper;
import com.scu.group8.mailServer.pojo.SentMail;
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
    public Result<MailVo> queryOutboxMail(int ownerId, int page, int pageSize) {
        Result result = new Result();
        PageHelper.startPage(page, pageSize);
        List<MailVo> mailVoList = sentMailMapper.queryOutboxMail(ownerId);
        if (mailVoList.isEmpty()){
            result.setResultFailed("Outbox is empty");
            return result;
        }
        PageInfo<MailVo> pageInfo = new PageInfo<>(mailVoList);
        result.setResultSuccess("Query Outbox email success", pageInfo);
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
