package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.DraftMail;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;

public interface InboxService {
    Result<MailVo> queryInboxMail(int ownerId, int page, int pageSize);
    Result readInboxMail(int mailId);
    Result deleteInboxMail(int mailId);
}
