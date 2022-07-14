package com.yibu.modulestudy.proxy.springproxy;

import cn.hutool.core.date.StopWatch;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @program: module-study
 * @description: 切面
 * @packagename: com.yibu.modulestudy.proxy.springproxy
 * @author: 振振
 * @date: 2022-07-14 17:50
 **/
@Log4j2
@Aspect
@Component
public class AspectInterceptor {
    /**
     * 拦截规则：拦截springproxy包下的所有方法
     */
    @Pointcut("@annotation(Flag)")
    public void pointcut() {
        log.info("1. 切点@Pointcut：决定处理如权限校验、日志记录等在何处切入业务代码中（即织入切面）l");
        log.info("2. 切点分为execution方式和annotation方式。 ");
        log.info("3. execution:用路径表达式指定哪些类织入切面");
        log.info("4. annotation:指定被哪些注解修饰的代码织入切面");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("ProceedingJoinPoint#getThis:{}", proceedingJoinPoint.getThis().getClass().getName());
        log.info("ProceedingJoinPoint#getTarget:{}", proceedingJoinPoint.getTarget().getClass().getName());
        log.info("ProceedingJoinPoint#getArgs:{}", proceedingJoinPoint.getArgs());
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Flag annotation = method.getAnnotation(Flag.class);
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start(String.format("%s", annotation.name()));
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            stopWatch.stop();
            log.info("方法{}执行耗时:{}(ms)", method.getName(), stopWatch.getTotalTimeMillis());
        }

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("触发Pointcut规则，前置处理中....");
    }


    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("触发Pointcut规则，后置处理中....");
    }
}
