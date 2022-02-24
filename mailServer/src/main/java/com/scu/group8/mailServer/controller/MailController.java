package com.scu.group8.mailServer.controller;

import com.scu.group8.mailServer.dto.DraftDto;
import com.scu.group8.mailServer.services.DraftService;
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

    @RequestMapping(value = "/draft/insert", method = RequestMethod.POST)
    public Result<DraftVo> insertDraft(@RequestBody DraftDto draftDto, HttpServletRequest request){
        Result result;
        int userId = Integer.valueOf((Integer) request.getSession().getAttribute(SESSION_NAME));
        draftDto.setMailId(userId);
        result = draftService.insertDraft(draftDto);
        return result;
    }
}
