package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.services.InboxService;
import com.scu.group8.mailServer.utils.Result;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class InboxServiceImplTest{
    @Autowired
    InboxService inboxService;

    @Test
    public void testQueryInboxMail() {
        int ownerId = 3, page = 1, pageSize = 2;
        Result result = inboxService.queryInboxMail(ownerId, page, pageSize);
        System.out.println(result.getData());
    }
    @Test
    public void testReadInboxMail() {
        int mailId = 22;
        inboxService.readInboxMail(mailId);
    }
    @Test
    public void testDeleteInboxMail() {
        int mailId = 23;
        inboxService.deleteInboxMail(mailId);
    }
}