package com.yibu.modulestudy.collections;

import com.google.common.collect.Maps;
import com.yibu.modulestudy.ModuleStudyApplication;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@Log4j2
@SpringBootTest(classes = {ModuleStudyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MapDemoTest {

    @Test
    public void 测试重复KEY() {
        Map<@Nullable String, @Nullable Object> map = Maps.newLinkedHashMap();
        Map<@Nullable String, @Nullable Object> map1 = Maps.newLinkedHashMap();
        Map<@Nullable String, @Nullable Object> map2 = Maps.newLinkedHashMap();

        map1.put("a", "a");
        map1.put("b", "b");

        map2.put("a", "aa");
        map2.put("c", "c");

        map.putAll(map2);
        map.putAll(map1);

        log.info(map);

        // 结论：如果key同名，后一个会覆盖前一个
    }

}