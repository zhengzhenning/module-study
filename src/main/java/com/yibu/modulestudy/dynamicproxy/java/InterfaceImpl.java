package com.yibu.modulestudy.dynamicproxy.java;

import lombok.extern.log4j.Log4j2;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.dynamicproxy.java
 * @author: 振振
 * @date: 2022-07-14 10:37
 **/
@Log4j2
public class InterfaceImpl implements Interface {
    @Override
    public void doSomething() {
        log.error("doSomething....");
    }

    @Override
    public void somethingElse(String arg) {
        log.error("somethingElse:%s", arg);
    }
}
