package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.Mail;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailMapperTest extends TestCase {
    @Autowired
    MailMapper mailMapper;

    @Test
    public void testInsertSelective() {
        Mail mail = new Mail();
        mail.setMailTitle("This is a title");
        mail.setMailContent("This is content");
        mailMapper.insertSelective(mail);
    }


    @Test
    public void testSelectByPrimaryKey() {
        Mail mail = mailMapper.selectByPrimaryKey(16);
        System.out.println(mail.getMailContent());
    }


    @Test
    public void testUpdateByPrimaryKeySelective() {
        Mail mail = new Mail();
        mail.setMailTitle("This is a title");
        mail.setMailContent("This is content");
        mail.setMailId(16);
        mailMapper.updateByPrimaryKeySelective(mail);
    }
}