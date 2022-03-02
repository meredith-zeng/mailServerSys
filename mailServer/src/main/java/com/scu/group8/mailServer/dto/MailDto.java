package com.scu.group8.mailServer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MailDto {
    private Integer mailId;
    private Integer senderId;
    private String senderEmailAddress;
    private String recipientEmailAddress;
    private String mailTitle;
    private String mailContent;
    private Date sendingTime;

    private Integer category;
}
