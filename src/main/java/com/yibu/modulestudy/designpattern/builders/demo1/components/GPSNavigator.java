package com.yibu.modulestudy.designpattern.builders.demo1.components;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.designpattern.builders.demo1.components
 * @author: 振振
 * @date: 2022-09-22 21:39
 **/
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        Faker faker = new Faker(Locale.CHINA);
        Address address = faker.address();
        this.route = address.fullAddress();
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
