package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.dto.MailDto;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.services.MailService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceImplTest extends TestCase {
    @Autowired
    MailService mailService;

    @Test
    public void testSelectMailByMailId() {
        int mailId = 17;
        Result<Mail> result = mailService.selectMailByMailId(mailId);
        System.out.println(result.getData());

    }

    @Test
    public void testSendMail() {
        for(int i = 0; i < 5; i++){
            MailDto mailDto = new MailDto();
            mailDto.setMailContent("Content");
            mailDto.setMailTitle("Title");
            mailDto.setSenderId(i);
            mailDto.setSenderEmailAddress("laiyan9@outlook.com");
            mailDto.setRecipientEmailAddress("wfl@yahoo.com");
            Result result = mailService.sendMail(mailDto);
            System.out.println(result.getMessage());
        }
    }
}