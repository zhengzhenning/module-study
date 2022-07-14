package com.yibu.modulestudy.lambda.demo1;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.lambda.demo1
 * @author: 振振
 * @date: 2022-07-14 20:50
 **/
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "绿色".equals(apple.getColor());
    }
}
