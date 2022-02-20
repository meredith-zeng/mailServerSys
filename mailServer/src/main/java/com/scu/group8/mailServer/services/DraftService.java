package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.DraftMail;
import com.scu.group8.mailServer.utils.Result;

public interface DraftService {
    Result insertDraft(DraftMail record);
    Result updateDraft(DraftMail record);
    Result selectDraftByMailId(DraftMail record);
    Result queryDraftByOwnerId(DraftMail record, int page, int limit);
    Result deleteDraft(int mailId);
}
