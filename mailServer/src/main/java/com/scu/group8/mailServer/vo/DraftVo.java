package com.scu.group8.mailServer.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DraftVo {
    private Integer mailId;
    private Integer ownerId;
    private Integer draftStatus;
    private String senderEmailAddress;
    private String recipientEmailAddress;
    private String mailTitle;
    private byte[] mailContent;
    private Date createTime;
    private Date updateTime;
}
