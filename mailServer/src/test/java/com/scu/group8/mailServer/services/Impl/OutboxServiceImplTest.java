package com.scu.group8.mailServer.services.Impl;

import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.services.OutboxService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OutboxServiceImplTest extends TestCase {
    @Autowired
    OutboxService outboxService;

    @Test
    public void testQueryOutboxMail() {
        int ownerId = 1, page = 1, pageSize = 1;
        Result<PageInfo<MailVo>> list = outboxService.queryOutboxMail(ownerId, page, pageSize);
        System.out.println(list.getData());

    }
    @Test
    public void testDeleteOutboxMail() {
        int mailId = 22;
        outboxService.deleteOutboxMail(mailId);
    }
}