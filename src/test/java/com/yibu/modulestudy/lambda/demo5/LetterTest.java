package com.yibu.modulestudy.lambda.demo5;

import com.yibu.modulestudy.ModuleStudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.function.Function;

@SpringBootTest(classes = ModuleStudyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LetterTest {


    @Test
    public void test() {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline
                = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.err.println(transformationPipeline.toString());
    }

}