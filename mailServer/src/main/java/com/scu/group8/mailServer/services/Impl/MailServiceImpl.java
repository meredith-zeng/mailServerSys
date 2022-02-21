package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.dao.MailMapper;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.services.MailService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    MailMapper mailMapper;

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
}
