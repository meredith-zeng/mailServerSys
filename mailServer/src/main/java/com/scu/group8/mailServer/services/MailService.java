package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.utils.Result;

import java.util.List;

public interface MailService {
    Result<Mail> selectMailByMailId(int mailId);
    Result<List<Mail>> queryMails(List<Integer> mailIds, int page, int limit);

}
