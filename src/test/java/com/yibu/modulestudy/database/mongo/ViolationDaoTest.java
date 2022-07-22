package com.yibu.modulestudy.database.mongo;

import com.yibu.modulestudy.ModuleStudyApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ModuleStudyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
class ViolationDaoTest {

    @Autowired
    private ViolationDao violationDao;

    @Test
    void count() {
        Long count = violationDao.count();
        Assertions.assertThat(count).isGreaterThan(0);
        System.err.println("count="+count);
    }
}