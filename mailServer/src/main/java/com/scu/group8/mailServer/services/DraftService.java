package com.scu.group8.mailServer.services;

import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.dto.MailDto;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;

public interface DraftService {
    Result insertDraft(MailDto mailDto);
    Result updateDraft(MailDto mailDto);

    Result<PageInfo<MailVo>> queryDraftByOwnerId(int ownerId, int page, int pageSize);
}
