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
public class BufferedReaderProcessorTest {

    private static final Logger log = LoggerFactory.getLogger(BufferedReaderProcessor.class);

    /**
     * 环绕执行模式
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {

        String oneLine = this.processFile(BufferedReader::readLine);
        System.err.println("读1行:" + oneLine);


        String forthLine = this.processFile((BufferedReader br) -> br.readLine() + br.readLine() + br.readLine() + br.readLine());
        System.err.println("读4行:" + forthLine);

        System.err.println("读取所有：");
        this.processFile((BufferedReader br) -> {
            do {
                System.err.println(">>>>>> " + br.readLine());
            } while (br.read() != -1);
            return "读取完毕！";
        });

    }

    /**
     * @param bufferedReaderProcessor
     * @return
     * @throws IOException
     */
    private String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        // TODO try(){}自带资源关闭操作
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/java/com/yibu/modulestudy/lambda/demo3/BufferedReaderProcessorTest.java"))) {
            return bufferedReaderProcessor.process(bufferedReader);
        }
    }
}