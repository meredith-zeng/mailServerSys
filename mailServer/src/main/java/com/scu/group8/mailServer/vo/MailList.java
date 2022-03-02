package com.scu.group8.mailServer.vo;

import lombok.Data;
import java.util.List;

@Data
public class MailList {
    private Integer total;
    private List<MailVo> list;
}