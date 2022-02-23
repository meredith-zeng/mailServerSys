package com.scu.group8.mailServer.services.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.dao.MailMapper;
import com.scu.group8.mailServer.dao.ReceivedMailMapper;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.services.InboxService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboxServiceImpl implements InboxService {
    @Autowired
    MailMapper mailMapper;

    @Autowired
    ReceivedMailMapper receivedMailMapper;

    @Override
    public Result<MailVo> queryInboxMail(int ownerId, int page, int pageSize) {
        Result result = new Result();
        PageHelper.startPage(page, pageSize);
        List<MailVo> mailVoList = receivedMailMapper.queryInboxMail(ownerId);
        if (mailVoList.isEmpty()){
            result.setResultFailed("Inbox is empty");
            return result;
        }
        PageInfo<MailVo> pageInfo = new PageInfo<>(mailVoList);
        result.setResultSuccess("Query inbox email success", pageInfo);
        return result;
    }

    @Override
    public Result readInboxMail(int mailId) {
        Result result = new Result();
        int readRes = receivedMailMapper.updateReadStatus(mailId);
        if (readRes == 0){
            result.setResultFailed("Read mail fail");
            return result;
        }
        MailVo mailVo = new MailVo();
        Mail mail = mailMapper.selectByPrimaryKey(mailId);
        BeanUtils.copyProperties(mail, mailVo);
        result.setResultSuccess("Read mail success", mailVo);
        return result;
    }

    @Override
    public Result deleteInboxMail(int mailId) {
        Result result = new Result();
        int deleteRes = receivedMailMapper.deleteMail(mailId);
        if (deleteRes == 0){
            result.setResultFailed("Delete mail fail");
        }
        result.setResultSuccess("Delete mail success", " ");
        return result;
    }
}
