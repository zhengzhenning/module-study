package com.yibu.modulestudy.dynamicproxy.java;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.dynamicproxy.java
 * @author: 振振
 * @date: 2022-07-14 10:37
 **/
public class InterfaceImpl implements Interface {
    @Override
    public void doSomething() {
        System.err.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.err.println(String.format("somethingElse:%s", arg));
    }
}
