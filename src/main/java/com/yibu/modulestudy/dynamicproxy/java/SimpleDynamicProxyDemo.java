package com.yibu.modulestudy.dynamicproxy.java;

import java.lang.reflect.Proxy;

/**
 * @program: module-study
 * @description: 一个简单的代理对象
 * @packagename: com.yibu.modulestudy.dynamicproxy.java
 * @author: 振振
 * @date: 2022-07-14 10:44
 **/
public class SimpleDynamicProxyDemo {

    public static void main(String[] args) {
        /**
         * 创建动态代理三要素 <br/>
         * 1. 类加载器
         * 2. 被代理的接口（不是类！不是类！不是类）
         * 3. 实现了 InvocationHandler 的处理器，具体
         */
        Interface proxyInstance = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader()
                , new Class[]{Interface.class}, new DynamicProxyHandler(new InterfaceImpl()));
        proxyInstance.doSomething();
        proxyInstance.somethingElse("做一些额外的事....");
    }
}
