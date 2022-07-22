package com.yibu.modulestudy.lambda.demo4;

import cn.hutool.core.io.LineHandler;
import cn.hutool.core.lang.func.Supplier2;
import com.google.common.base.Supplier;
import com.yibu.modulestudy.ModuleStudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = ModuleStudyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MethodReferenceTest {

    @Autowired
    private MethodReference methodReference;

    @Test
    public void test01() {

        Supplier<PeoplePO> handler = PeoplePO::new;
        PeoplePO peoplePO = handler.get();
        peoplePO.setName("振振");

        String eat = methodReference.eat(peoplePO, "甜甜圈🍩");
        System.err.println(eat);

    }

}