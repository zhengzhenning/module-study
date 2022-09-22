package com.yibu.modulestudy.designpattern.builders.director;

import com.yibu.modulestudy.designpattern.builders.build.Builder;
import com.yibu.modulestudy.designpattern.builders.cars.CarType;
import com.yibu.modulestudy.designpattern.builders.components.Engine;
import com.yibu.modulestudy.designpattern.builders.components.GPSNavigator;
import com.yibu.modulestudy.designpattern.builders.components.Transmission;
import com.yibu.modulestudy.designpattern.builders.components.TripComputer;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.designpattern.builders.director
 * @author: 振振
 * @date: 2022-09-22 21:40
 **/
public class Director {
    /**
     * 造【运动型】汽车🚗
     * @param builder 构造器
     */
    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.运动型);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.MT_手动变速箱);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    /**
     * 造【城市型】汽车🚗
     * @param builder 构造器
     */
    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.城市型);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AMT_电控机械自动变速箱);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    /**
     * 造【SUV型】汽车🚗
     * @param builder 构造器
     */
    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.AT_液力自动变速箱);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
