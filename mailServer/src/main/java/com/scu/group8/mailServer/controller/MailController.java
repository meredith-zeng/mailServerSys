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
    private InboxService inboxService;
    @Autowired
    private OutboxService outboxService;
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<PageInfo<MailVo>> insertDraft(@RequestParam Integer category, @RequestParam Integer page, @RequestParam Integer size, HttpServletRequest request) {
        Result<PageInfo<MailVo>> result;
        User user = Session.getUserInfo(request);
        if(category == 2) {
            result = inboxService.queryInboxMail(user.getUserId(), page, size);
        } else {
            result = outboxService.queryOutboxMail(user.getUserId(), page, size, category);
        }

        return result;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Result sendMail(@RequestBody MailDto mailDto, HttpServletRequest request) {
        User user = Session.getUserInfo(request);
        mailDto.setSenderId(user.getUserId());
        mailDto.setSenderEmailAddress(user.getUserEmailAddress());
        mailDto.setSendingTime(new Date());
        return mailService.sendMail(mailDto);
    }

    @RequestMapping(value = "/draft", method = RequestMethod.POST)
    public Result draftMail(@RequestBody MailDto mailDto, HttpServletRequest request){
        User user = Session.getUserInfo(request);
        mailDto.setSenderId(user.getUserId());
        mailDto.setSenderEmailAddress(user.getUserEmailAddress());
        return mailService.createOrUpdateDraft(mailDto);
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public Result readMail(@RequestBody MailDto mailDto) {
        return inboxService.readInboxMail(mailDto.getMailId());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result deleteMail(@RequestBody MailDto mailDto){
        Result result;
        if(mailDto.getCategory() == 2) {
            result = inboxService.deleteInboxMail(mailDto.getMailId());
        } else {
            result = outboxService.deleteOutboxMail(mailDto.getMailId());
        }
        return result;
    }
}
