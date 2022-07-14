package com.yibu.modulestudy.lambda.demo1;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.lambda.demo1
 * @author: 振振
 * @date: 2022-07-14 20:49
 **/
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
