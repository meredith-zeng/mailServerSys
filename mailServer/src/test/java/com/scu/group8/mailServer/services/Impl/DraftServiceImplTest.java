package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.services.DraftService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DraftServiceImplTest extends TestCase {

    @Autowired
    DraftService draftService;

    @Test
    public void testQueryDraftByOwnerId() {
        int ownerId = 1, page = 1, pageSize = 2;
        draftService.queryDraftByOwnerId(ownerId, page, pageSize);
    }
}