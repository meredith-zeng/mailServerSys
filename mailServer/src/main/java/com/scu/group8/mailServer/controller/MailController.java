package com.scu.group8.mailServer.controller;

import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.dto.MailDto;
import com.scu.group8.mailServer.pojo.User;
import com.scu.group8.mailServer.services.*;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.utils.Session;
import com.scu.group8.mailServer.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private DraftService draftService;
    @Autowired
    private InboxService inboxService;
    @Autowired
    private OutboxService outboxService;
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<PageInfo<MailVo>> insertDraft(@RequestParam Integer category, @RequestParam Integer page, @RequestParam Integer size, HttpServletRequest request) {
        Result<PageInfo<MailVo>> result = new Result<>();
        User user = Session.getUserInfo(request);
        if(category == 2) {
            result = inboxService.queryInboxMail(user.getUserId(), page, size);
        } else if(category == 1) {
            result = outboxService.queryOutboxMail(user.getUserId(), page, size);
        } else if(category == 0) {
        }

        return result;
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public Result<String> readMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        User user = Session.getUserInfo(request);
        return inboxService.readInboxMail(mailDto.getMailId());
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Result<String> sendMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        User user = Session.getUserInfo(request);
        mailDto.setSenderId(user.getUserId());
        mailDto.setSenderEmailAddress(user.getUserEmailAddress());
        mailDto.setSendingTime(new Date());
        return mailService.sendMail(mailDto);
    }

    @RequestMapping(value = "/draft", method = RequestMethod.POST)
    public Result insertDraft(@RequestBody MailDto mailDto, HttpServletRequest request){
        Result result;
        User user = Session.getUserInfo(request);
        mailDto.setSenderId(user.getUserId());
        if(mailDto.getMailId() != null) {
            result = draftService.updateDraft(mailDto);
        } else {
            result = draftService.insertDraft(mailDto);
        }
        return result;
    }

    @RequestMapping(value = "/deleteInbox", method = RequestMethod.POST)
    public Result deleteInboxMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        Result result;
        result = inboxService.deleteInboxMail(mailDto.getMailId());
        return result;
    }

    @RequestMapping(value = "/deleteOutbox", method = RequestMethod.POST)
    public Result deleteOutboxMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        Result result;
        result = outboxService.deleteOutboxMail(mailDto.getMailId());
        return result;
    }
}
