package com.yibu.modulestudy.proxy.springproxy;

import com.yibu.modulestudy.ModuleStudyApplication;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {ModuleStudyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
class SpringServiceTest {

    private final static Logger  log= LoggerFactory.getLogger(SpringServiceTest.class);

    @Autowired
    private SpringService springService;

    @Test
    void doSomething() {
        springService.doSomething();
        log.error("================");
        springService.otherSomething("😀");
    }
}