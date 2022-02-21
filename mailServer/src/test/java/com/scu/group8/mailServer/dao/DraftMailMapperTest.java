package com.scu.group8.mailServer.dao;

import com.scu.group8.mailServer.vo.DraftVo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DraftMailMapperTest extends TestCase {
    @Autowired
    DraftMailMapper draftMailMapper;

    @Test
    public void testQueryDraftByOwnerId() {
        List<DraftVo> res = draftMailMapper.queryDraftByOwnerId(1);
        System.out.println(res.size());
    }
}