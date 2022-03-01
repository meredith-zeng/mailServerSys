package com.scu.group8.mailServer.controller;

import com.scu.group8.mailServer.dto.DraftDto;
import com.scu.group8.mailServer.dto.MailDto;
import com.scu.group8.mailServer.services.DraftService;
import com.scu.group8.mailServer.services.InboxService;
import com.scu.group8.mailServer.services.MailService;
import com.scu.group8.mailServer.services.OutboxService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.DraftVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MailController {
    public static final String SESSION_NAME = "userInfo";

    @Autowired
    private DraftService draftService;
    private MailService mailService;
    private InboxService inboxService;
    private OutboxService outboxService;

    //Draft Email
    @RequestMapping(value = "mail/draft", method = RequestMethod.POST)
    public Result<DraftVo> insertDraft(@RequestBody DraftDto draftDto, HttpServletRequest request){
        Result result;
        int ownerId = Integer.valueOf((Integer) request.getSession().getAttribute(SESSION_NAME));
        draftDto.setOwnerId(ownerId);
        result = draftService.insertDraft(draftDto);
        return result;
    }

    //Send Email
    @RequestMapping(value = "mail/send", method = RequestMethod.POST)
    public Result sendMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        Result result;
        int senderId = Integer.valueOf((Integer) request.getSession().getAttribute(SESSION_NAME));
        mailDto.setSenderId(senderId);
        result = mailService.sendMail(mailDto);
        return result;
    }

    //Delete Inbox Email
    @RequestMapping(value = "/mail/deleteInbox", method = RequestMethod.POST)
    public Result deleteInboxMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        Result result;
        result = inboxService.deleteInboxMail(mailDto.getMailId());
        return result;
    }

    //Delete Outbox Email
    @RequestMapping(value = "/mail/deleteOutbox", method = RequestMethod.POST)
    public Result deleteOutboxMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        Result result;
        result = outboxService.deleteOutboxMail(mailDto.getMailId());
        return result;
    }
}
