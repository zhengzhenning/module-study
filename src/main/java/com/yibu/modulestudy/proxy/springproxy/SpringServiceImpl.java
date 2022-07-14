package com.yibu.modulestudy.proxy.springproxy;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Service;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.proxy.springproxy
 * @author: 振振
 * @date: 2022-07-14 17:48
 **/
@Log4j2
@Service
public class SpringServiceImpl implements SpringService {

    @Flag(name = "doSomething")
    @Override
    public void doSomething() {
        log.info("SpringServiceImpl#doSomething...");
//        this.otherSomething("测试this调用是否会使切面失效....");
//        this.privateMethod("测试this调用私有方法");
    }

    @Flag(name = "privateMethod")
    private void privateMethod(String arg) {
        log.info("SpringServiceImpl#privateMethod:{}", arg);
    }


    @Flag(name = "otherSomething")
    @Override
    public void otherSomething(String arg) {
        log.info("SpringServiceImpl#otherSomething:{}", arg);
    }
}
