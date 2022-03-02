package com.scu.group8.mailServer.services.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.dao.DraftMailMapper;
import com.scu.group8.mailServer.dao.MailMapper;
import com.scu.group8.mailServer.dto.MailDto;
import com.scu.group8.mailServer.pojo.DraftMail;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.services.DraftService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.MailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DraftServiceImpl implements DraftService {
    @Autowired
    DraftMailMapper draftMailMapper;
    @Autowired
    MailMapper mailMapper;

    @Override
    @Transactional
    public Result insertDraft(MailDto mailDto) {
        Result result = new Result();
        Mail mail = new Mail();
        BeanUtils.copyProperties(mailDto, mail);
        int mailInsertRes = mailMapper.insertSelective(mail);
        if (mailInsertRes == 0){
            result.setResultFailed("Insert Draft fail");
            return result;
        }

        int mailId = mail.getMailId();
        DraftMail draftMail = new DraftMail();
        draftMail.setMailId(mailId);
        draftMail.setDraftStatus(0);
        draftMail.setOwnerId(mailDto.getSenderId());
        int draftInsertRes = draftMailMapper.insertSelective(draftMail);
        if (draftInsertRes == 0){
            result.setResultFailed("Insert Draft fail");
            return result;
        }
        result.setResultSuccess("Insert Draft success");
        return result;
    }

    @Override
    public Result updateDraft(MailDto mailDto) {
        Result result = new Result();
        Mail mail = new Mail();
        BeanUtils.copyProperties(mailDto, mail);
        int updateDraftRes = mailMapper.updateByPrimaryKeySelective(mail);
        if (updateDraftRes == 0){
            result.setResultFailed("Update Draft fail");
            return result;
        }
        result.setResultSuccess("Update Draft success");
        return result;
    }

    @Override
    public Result<PageInfo<MailVo>> queryDraftByOwnerId(int ownerId, int page, int pageSize) {
        Result<PageInfo<MailVo>> result = new Result<>();
        PageHelper.startPage(page, pageSize);
        List<MailVo> mailVoList = draftMailMapper.queryDraftByOwnerId(ownerId);
        PageInfo<MailVo> pageInfo = new PageInfo<>(mailVoList);
        result.setResultSuccess("Query draft email success", pageInfo);

        return result;
    }
}
