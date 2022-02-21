package com.scu.group8.mailServer.services.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scu.group8.mailServer.dao.DraftMailMapper;
import com.scu.group8.mailServer.dao.MailMapper;
import com.scu.group8.mailServer.dto.DraftDto;
import com.scu.group8.mailServer.pojo.DraftMail;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.services.DraftService;
import com.scu.group8.mailServer.utils.Result;
import com.scu.group8.mailServer.vo.DraftVo;
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
    public Result insertDraft(DraftDto record) {
        Result result = new Result();
        Mail mail = new Mail();
        BeanUtils.copyProperties(record, mail);
        int mailInsertRes = mailMapper.insertSelective(mail);
        if (mailInsertRes == 0){
            result.setResultFailed("Insert Draft fail");
            return result;
        }
        int mailId = mail.getMailId();
        DraftMail draftMail = new DraftMail();
        draftMail.setMailId(mailId);
        draftMail.setDraftStatus(0);
        draftMail.setOwnerId(record.getOwnerId());
        int draftInsertRes = draftMailMapper.insertSelective(draftMail);
        if (draftInsertRes == 0){
            result.setResultFailed("Insert Draft fail");
            return result;
        }
        result.setResultSuccess("Insert Draft success", "");
        return result;
    }

    @Override
    public Result updateDraft(DraftDto record) {
        Result result = new Result();
        Mail mail = new Mail();
        BeanUtils.copyProperties(record, mail);
        int updateDraftRes = mailMapper.updateByPrimaryKeySelective(mail);
        if (updateDraftRes == 0){
            result.setResultFailed("Update Draft fail");
            return result;
        }
        result.setResultSuccess("Update Draft success", "");
        return result;
    }


    @Override
    public Result selectDraftByMailId(int mailId) {
        Result result = new Result();
        Mail mail = mailMapper.selectByPrimaryKey(mailId);
        if(mail == null){
            result.setResultFailed("Draft is not exist");
            return result;
        }
        DraftMail draftMail = draftMailMapper.selectByPrimaryKey(mailId);
        DraftVo draftVo = new DraftVo();
        BeanUtils.copyProperties(mail, draftVo);
        BeanUtils.copyProperties(draftMail, draftVo);

        result.setResultSuccess("Select draft success", draftVo);
        return result;
    }

    @Override
    public Result<List<DraftVo>> queryDraftByOwnerId(int ownerId, int page, int pageSize) {
        Result result = new Result();
        PageHelper.startPage(page, pageSize);
        List<DraftVo> draftVoList = draftMailMapper.queryDraftByOwnerId(ownerId);
        if (draftVoList.isEmpty()){
            result.setResultFailed("Draft box is empty");
            return result;
        }
        PageInfo<DraftVo> pageInfo = new PageInfo<>(draftVoList);
        result.setResultSuccess("query draft success", pageInfo);
        return result;
    }
}
