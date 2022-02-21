package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.pojo.ReceivedMail;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReceivedMailMapperTest extends TestCase {
@Autowired
ReceivedMailMapper receivedMailMapper;

    @Test
    public void testInsertSelective() {
        ReceivedMail receivedMail = new ReceivedMail();
        receivedMail.setMailId(100);
        receivedMail.setReadStatus(1);
        receivedMailMapper.insertSelective(receivedMail);
    }

    @Test
    public void testSelectByPrimaryKey() {
        ReceivedMail receivedMail = receivedMailMapper.selectByPrimaryKey(16);
        System.out.println(receivedMail);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        ReceivedMail receivedMail = new ReceivedMail();
        receivedMail.setMailId(16);
        receivedMail.setReadStatus(1);
        receivedMailMapper.updateByPrimaryKeySelective(receivedMail);
    }
}