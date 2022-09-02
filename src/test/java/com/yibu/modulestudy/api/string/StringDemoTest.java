package com.yibu.modulestudy.api.string;

import com.yibu.modulestudy.ModuleStudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = {ModuleStudyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StringDemoTest {


    @Test
    public void testSplit() {
        String text = null;
        String[] split = text.split(text);
        List<String> lists = Arrays.asList(split);
        lists.stream().forEach(System.out::println);
    }

    @Test
    public void testTirm() {
        String trim = "shjjs shakhakj hjkhjak hkahsk huw u ".trim();
        System.err.println(trim);
    }

}