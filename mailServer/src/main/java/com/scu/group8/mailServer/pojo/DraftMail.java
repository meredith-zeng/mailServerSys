package com.scu.group8.mailServer.pojo;

import lombok.Data;

@Data
public class DraftMail {
    private Integer mailId;
    private Integer ownerId;
    private Integer draftStatus;

}