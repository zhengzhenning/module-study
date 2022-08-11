package com.yibu.modulestudy.api.string;

import com.yibu.modulestudy.ModuleStudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {ModuleStudyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public  class StringDemoTest {

    @Test
    public void testTirm(){
        String trim = "shjjs shakhakj hjkhjak hkahsk huw u ".trim();
        System.err.println(trim);
    }

}