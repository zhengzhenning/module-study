package com.yibu.modulestudy.lambda.demo3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.lambda.demo3
 * @author: 振振
 * @date: 2022-07-14 22:19
 **/
@FunctionalInterface
public interface BufferedReaderProcessor {

    /**
     * 处理BufferedReader流
     *
     * @param bufferedReader bR流对象
     * @return
     * @throws IOException
     */
    String process(BufferedReader bufferedReader) throws IOException;
}
