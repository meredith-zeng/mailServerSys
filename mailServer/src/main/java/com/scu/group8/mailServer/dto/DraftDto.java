package com.scu.group8.mailServer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DraftDto {
    private Integer mailId;
    private Integer ownerId;
    // 0: 草稿 1: 草稿已发送
    private Integer draftStatus;
    private String senderEmailAddress;
    private String recipientEmailAddress;
    private String mailTitle;
    private String mailContent;
}
