package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.SentMail;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SentMailMapperTest extends TestCase {
@Autowired
SentMailMapper sentMailMapper;

    @Test
    public void testInsertSelective() {
        SentMail sentMail = new SentMail();
        sentMail.setMailId(20);
        sentMail.setOwnerId(3);
        sentMail.setReceivedUserId(1);
        sentMail.setIsDeleted(0);
        sentMailMapper.insertSelective(sentMail);
    }

    @Test
    public void testSelectByPrimaryKey() {
        SentMail sentMail = sentMailMapper.selectByPrimaryKey(16);
        System.out.println(sentMail);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        SentMail sentMail = new SentMail();
        sentMail.setMailId(16);
        sentMail.setOwnerId(3);
        sentMailMapper.updateByPrimaryKeySelective(sentMail);
    }

}