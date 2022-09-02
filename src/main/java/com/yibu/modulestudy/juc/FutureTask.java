package com.yibu.modulestudy.juc;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.juc
 * @author: 振振
 * @date: 2022-08-11 09:56
 **/
@Slf4j
public class FutureTask {


    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public List<LocationDTO> future() {
        Faker faker = Faker.instance(Locale.CHINA);

        List<@Nullable LocationDTO> locations = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            LocationDTO dto = LocationDTO.builder()
                    ._id(faker.idNumber().invalid())
                    .build();
            locations.add(dto);
        }
        List<Callable<LocationDTO>> callableList = new ArrayList<>();
        String nulls = null;
        for (int i = 0; i < locations.size(); i++) {

        }
        locations.stream().forEach(location -> {
            callableList.add(new Callable<LocationDTO>() {
                @Override
                public LocationDTO call() throws Exception {
                    try {
                        location.setCarNumColor(generateCarID());
                        if (location.getCarNumColor().contains("京")) {
                            location.setAdcode(nulls.trim());
                        }
                    } catch (Exception e) {
                        log.error(">>>>>>>>>>>>>:{}", e.getMessage());
                        e.printStackTrace();
                    }
                    return location;
                }
            });
        });

        List<@Nullable LocationDTO> latestLocations = Lists.newArrayList();
        try {
            List<Future<LocationDTO>> futures = executorService.invokeAll(callableList);
            futures.forEach(future -> {
                try {
                    if (!future.isCancelled()) {
                        LocationDTO locationDTO = future.get();
                        latestLocations.add(locationDTO);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latestLocations;
    }

    // 车牌号的组成一般为：省份+地区代码+5位数字/字母
    private static String generateCarID() {

        char[] provinceAbbr = { // 省份简称 4+22+5+3
                '京', '津', '沪', '渝',
                '冀', '豫', '云', '辽', '黑', '湘', '皖', '鲁', '苏', '浙', '赣',
                '鄂', '甘', '晋', '陕', '吉', '闽', '贵', '粤', '青', '川', '琼',
                '宁', '新', '藏', '桂', '蒙',
                '港', '澳', '台'
        };
        String alphas = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890"; // 26个字母 + 10个数字

        Random random = new Random(); // 随机数生成器

        String carID = "";

        // 省份+地区代码+·  如 湘A· 这个点其实是个传感器，不过加上美观一些
        carID += provinceAbbr[random.nextInt(34)]; // 注意：分开加，因为加的是2个char
        carID += alphas.charAt(random.nextInt(26)) + "·";

        // 5位数字/字母
        for (int i = 0; i < 5; i++) {
            carID += alphas.charAt(random.nextInt(36));
        }
        return carID;
    }
}
