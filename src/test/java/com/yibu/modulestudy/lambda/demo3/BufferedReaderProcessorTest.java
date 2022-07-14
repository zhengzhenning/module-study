package com.yibu.modulestudy.lambda.demo3;

import com.yibu.modulestudy.ModuleStudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootTest(classes = ModuleStudyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
class BufferedReaderProcessorTest {

    private static final Logger log = LoggerFactory.getLogger(BufferedReaderProcessor.class);

    @Test
    public void test01() throws IOException {

        String oneLine = this.processFile((BufferedReader br) -> br.readLine());
        System.err.println(oneLine);

        String twoLine = this.processFile((BufferedReader br) -> br.readLine() + br.readLine());

    }

    private String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        // TODO try(){}自带资源关闭操作
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("BufferedReaderProcessorTest.java"))) {
            return bufferedReaderProcessor.process(bufferedReader);
        }
    }
}