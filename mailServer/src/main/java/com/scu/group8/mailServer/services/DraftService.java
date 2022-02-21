package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.dto.DraftDto;
import com.scu.group8.mailServer.pojo.DraftMail;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.DraftVo;

import java.util.List;

public interface DraftService {
    Result insertDraft(DraftDto record);
    Result updateDraft(DraftDto record);

    Result<DraftVo> selectDraftByMailId(int mailId);

    Result<List<DraftVo>> queryDraftByOwnerId(int ownerId, int page, int pageSize);
}
