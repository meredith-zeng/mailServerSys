package com.scu.group8.mailServer.services;

import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;

public interface InboxService {
    Result<PageInfo<MailVo>> queryInboxMail(int ownerId, int page, int pageSize);
    Result readInboxMail(int mailId);
    Result deleteInboxMail(int mailId);
}
