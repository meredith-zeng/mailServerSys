package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;

public interface OutboxService {
    Result<MailVo> queryOutboxMail(int ownerId, int page, int pageSize);
    Result deleteOutboxMail(int mailId);
}
