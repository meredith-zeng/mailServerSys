package com.scu.group8.mailServer.services;

import com.scu.group8.mailServer.pojo.Mail;

import java.util.List;

public interface MailService {
    Mail selectMailById(int mailId);
    List<Mail> queryMails(List<Integer> mailIds);
}
