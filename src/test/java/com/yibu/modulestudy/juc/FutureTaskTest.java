package com.yibu.modulestudy.juc;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FutureTaskTest {

    @Test
    public void containNull(){
        ArrayList<String> strings = Lists.newArrayList("a", "b", "c", "d");
        boolean contains = strings.contains(null);
        Assertions.assertThat(contains).isFalse();
    }

    @Test
    public void test() {
        FutureTask futureTask = new FutureTask();
        List<LocationDTO> locationDTOS = futureTask.future();
        Assertions.assertThat(locationDTOS).isNotNull();
    }

}