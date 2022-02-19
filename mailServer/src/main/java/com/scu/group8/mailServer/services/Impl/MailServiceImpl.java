package com.scu.group8.mailServer.services.Impl;

import com.scu.group8.mailServer.pojo.Mail;
import com.scu.group8.mailServer.services.MailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Override
    public Mail selectMailById(int mailId) {
        return null;
    }

    @Override
    public List<Mail> queryMails(List<Integer> mailIds) {
        return null;
    }
}
