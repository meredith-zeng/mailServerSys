package com.scu.group8.mailServer.services.Impl;

import com.github.pagehelper.PageHelper;
import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.services.MailService;
import com.scu.group8.mailServer.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Override
    public Result<Mail> selectMailByMailId(int mailId) {
        return null;
    }

    @Override
    public Result<List<Mail>> queryMails(List<Integer> mailIds, int page, int limit) {
        PageHelper.startPage(page, limit);
//        List<Article> articleList = articleDao.getArticleList();
//        PageInfo<Article> pageInfo = new PageInfo(articleList);
//        pageInfo.getTotal();

        return null;
    }
}
