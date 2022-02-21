package com.scu.group8.mailServer.dto;

import lombok.Data;

@Data
public class MailDto {
    private Integer mailId;
    private String senderEmailAddress;
    private String recipientEmailAddress;
    private String mailTitle;
    private String mailContent;
}
