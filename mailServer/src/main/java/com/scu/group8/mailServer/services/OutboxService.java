package com.scu.group8.mailServer.services;

import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;

public interface OutboxService {
    Result<PageInfo<MailVo>> queryOutboxMail(int ownerId, int page, int pageSize);
    Result deleteOutboxMail(int mailId);
}
