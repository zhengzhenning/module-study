package com.yibu.modulestudy.lambda.demo2;

/**
 * @program: module-study
 * @description: Predicate
 * @packagename: com.yibu.modulestudy.lambda.demo2
 * @author: 振振
 * @date: 2022-07-14 21:25
 **/
public interface Predicate<T> {
    boolean test(T t);
}
