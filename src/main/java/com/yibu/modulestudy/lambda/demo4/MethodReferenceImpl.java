package com.yibu.modulestudy.lambda.demo4;

import org.springframework.stereotype.Component;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.lambda.demo4
 * @author: 振振
 * @date: 2022-07-22 17:21
 **/
@Component
public class MethodReferenceImpl implements MethodReference {
    /**
     * 吃东西
     *
     * @param food
     * @return
     */
    @Override
    public String eat(PeoplePO peoplePO, String food) {
        return String.format("%s吃%s", peoplePO.getName(), food);
    }

    /**
     * 听音乐
     *
     * @param music
     * @return
     */
    @Override
    public String listener(PeoplePO peoplePO, String music) {
        return String.format("%s听%s", peoplePO.getName(), music);
    }

    /**
     * 看电影
     *
     * @param film
     * @return
     */
    @Override
    public String look(PeoplePO peoplePO, String film) {
        return String.format("%s看%s", peoplePO.getName(), film);
    }
}
