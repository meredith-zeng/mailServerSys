package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.dao.MailMapper;
import com.scu.group8.mailServer.dao.ReceivedMailMapper;
import com.scu.group8.mailServer.dao.SentMailMapper;
import com.scu.group8.mailServer.dao.UserMapper;
import com.scu.group8.mailServer.dto.MailDto;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.pojo.ReceivedMail;
import com.scu.group8.mailServer.pojo.SentMail;
import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.MailService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    MailMapper mailMapper;
    @Autowired
    ReceivedMailMapper receivedMailMapper;
    @Autowired
    SentMailMapper sentMailMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Result<Mail> selectMailByMailId(int mailId) {
        Result result = new Result();
        Mail mail = mailMapper.selectByPrimaryKey(mailId);
        if (mail == null){
            result.setResultFailed("Mail is not exist");
            return result;
        }

        MailVo mailVo = new MailVo();
        BeanUtils.copyProperties(mail, mailVo);
        result.setResultSuccess("Select mail success", mailVo);
        return result;
    }

    @Override
    @Transactional
    public Result sendMail(MailDto mailDto) {
        Result result = new Result();
        Mail mail = new Mail();
        BeanUtils.copyProperties(mailDto, mail);
        // Step1: add mail
        int mailInsertRes;
        if(mailDto.getMailId() != null) {
            mailInsertRes = mailMapper.updateByPrimaryKeySelective(mail);
        } else {
            mailInsertRes = mailMapper.insertSelective(mail);
        }
        if (mailInsertRes == 0){
            result.setResultFailed("Mail sent fail");
            return result;
        }

        // Step2: add receivedMail
        User recipientUser = userMapper.selectByMailAddress(mailDto.getRecipientEmailAddress());
        if(recipientUser != null) {
            ReceivedMail receivedMail = new ReceivedMail();
            receivedMail.setMailId(mail.getMailId());
            receivedMail.setReadStatus(0);
            receivedMail.setOwnerId(recipientUser.getUserId());
            receivedMail.setIsDeleted(0);
            receivedMail.setSentUserId(mailDto.getSenderId());
            int receivedMailInsertRes = receivedMailMapper.insertSelective(receivedMail);
            if (receivedMailInsertRes == 0){
                result.setResultFailed("Mail receive fail");
                return result;
            }
        }

        // Step3: add sentMail
        SentMail sentMail = new SentMail();
        sentMail.setMailId(mail.getMailId());
        sentMail.setReceivedUserId(recipientUser == null ? -1 : recipientUser.getUserId());
        sentMail.setIsDeleted(0);
        sentMail.setSendStatus(1);
        sentMail.setOwnerId(mailDto.getSenderId());
        int sentMailRes;
        if(mailDto.getMailId() != null) {
            sentMailRes = sentMailMapper.updateByPrimaryKeySelective(sentMail);
        } else {
            sentMailRes = sentMailMapper.insertSelective(sentMail);
        }

        if (sentMailRes == 0){
            result.setResultFailed("Mail sent fail");
        }
        result.setResultSuccess("Mail sent success");
        return result;
    }

    @Override
    @Transactional
    public Result createOrUpdateDraft(MailDto mailDto) {
        Result result = new Result();
        Mail mail = new Mail();
        BeanUtils.copyProperties(mailDto, mail);
        // add mail
        int mailInsertRes;
        if(mailDto.getMailId() != null) {
            mailInsertRes = mailMapper.updateByPrimaryKeySelective(mail);
        } else {
            mailInsertRes = mailMapper.insertSelective(mail);
        }

        if (mailInsertRes == 0){
            result.setResultFailed("Mail db fail");
            return result;
        }

        // add sentMail
        SentMail sentMail = new SentMail();
        sentMail.setMailId(mail.getMailId());
        if(mailDto.getRecipientEmailAddress() != null) {
            User recipientUser = userMapper.selectByMailAddress(mailDto.getRecipientEmailAddress());
            sentMail.setReceivedUserId(recipientUser.getUserId());
        }
        sentMail.setIsDeleted(0);
        sentMail.setSendStatus(0);
        sentMail.setOwnerId(mailDto.getSenderId());
        int sentMailRes;
        if(mailDto.getMailId() != null) {
            sentMailRes = sentMailMapper.updateByPrimaryKeySelective(sentMail);
        } else {
            sentMailRes = sentMailMapper.insertSelective(sentMail);
        }

        if (sentMailRes == 0){
            result.setResultFailed("SentMail db fail");
        }
        result.setResultSuccess("Draft db success");
        return result;
    }
}
