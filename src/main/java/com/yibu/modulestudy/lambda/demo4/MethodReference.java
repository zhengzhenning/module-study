package com.yibu.modulestudy.lambda.demo4;

import org.springframework.stereotype.Component;

/**
 * @program: module-study
 * @description: 方法引用
 * @packagename: com.yibu.modulestudy.lambda.demo4
 * @author: 振振
 * @date: 2022-07-22 17:20
 **/
public interface MethodReference {

    /**
     * 吃东西
     *
     * @param food
     * @return
     */
    String eat(PeoplePO peoplePO, String food);

    /**
     * 听音乐
     *
     * @param music
     * @return
     */
    String listener(PeoplePO peoplePO, String music);

    /**
     * 看电影
     *
     * @param film
     * @return
     */
    String look(PeoplePO peoplePO, String film);
}
