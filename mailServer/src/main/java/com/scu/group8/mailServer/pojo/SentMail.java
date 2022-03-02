package com.scu.group8.mailServer.pojo;

import lombok.Data;

@Data
public class SentMail {
    private Integer mailId;
    private Integer ownerId;
    private Integer receivedUserId;
    private Integer sendStatus;
    private Integer isDeleted;

}