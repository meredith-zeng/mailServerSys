package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.dto.DraftDto;
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
    public void testInsertDraft() {
        DraftDto draftDto = new DraftDto();
        draftDto.setOwnerId(1);
        draftDto.setDraftStatus(0);
        draftDto.setSenderEmailAddress("nakano1968@yahoo.com");
        draftDto.setMailTitle("It's a draft 2.20");
        draftDto.setMailContent("content");
        draftService.insertDraft(draftDto);
    }

    @Test
    public void testUpdateDraft() {
        DraftDto draftDto = new DraftDto();
        draftDto.setMailId(16);
        draftDto.setMailTitle("Go ahead");
        draftDto.setMailContent("Update test");
        draftDto.setRecipientEmailAddress("wfl@yahoo.com");
        draftService.updateDraft(draftDto);
    }

    @Test
    public void testSelectDraftByMailId() {
        int mailId = 16;
        System.out.println(draftService.selectDraftByMailId(mailId).getData());

    }

    @Test
    public void testQueryDraftByOwnerId() {
        int ownerId = 1, page = 2, pageSize = 1;
        draftService.queryDraftByOwnerId(ownerId, page, pageSize);
    }
}