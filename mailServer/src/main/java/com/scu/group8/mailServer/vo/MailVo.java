package com.scu.group8.mailServer.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MailVo {
    private Integer mailId;
    private String senderEmailAddress;
    private String recipientEmailAddress;
    private String mailTitle;
    private String mailContent;
    private Date sendingTime;
    private Integer readStatus;

    private Date createTime;
    private Date updateTime;
}
