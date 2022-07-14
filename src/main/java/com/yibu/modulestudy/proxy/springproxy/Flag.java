package com.yibu.modulestudy.proxy.springproxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: module-study
 * @description: 标记
 * @packagename: com.yibu.modulestudy.proxy.springproxy
 * @author: 振振
 * @date: 2022-07-14 18:13
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Flag {

    String name() default "";

}
