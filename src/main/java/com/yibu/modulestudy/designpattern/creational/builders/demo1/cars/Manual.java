package com.yibu.modulestudy.designpattern.creational.builders.demo1.cars;

import com.yibu.modulestudy.designpattern.creational.builders.demo1.components.Engine;
import com.yibu.modulestudy.designpattern.creational.builders.demo1.components.GPSNavigator;
import com.yibu.modulestudy.designpattern.creational.builders.demo1.components.Transmission;
import com.yibu.modulestudy.designpattern.creational.builders.demo1.components.TripComputer;

/**
 * @program: module-study
 * @description: 手册
 * @packagename: com.yibu.modulestudy.designpattern.builders.demo1.cars
 * @author: 振振
 * @date: 2022-09-22 21:37
 **/
public class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;

    public Manual(CarType carType, int seats, Engine engine, Transmission transmission,
                  TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }


    public String print() {
        String info = "";
        info += "车辆类型: " + carType + "\n";
        info += "座位数💺（个）: " + seats + "\n";
        info += "发动机: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
        info += "变速箱: " + transmission + "\n";
        if (this.tripComputer != null) {
            info += "Trip Computer: Functional" + "\n";
        } else {
            info += "Trip Computer: N/A" + "\n";
        }
        if (this.gpsNavigator != null) {
            info += "GPS Navigator: Functional" + "\n";
        } else {
            info += "GPS Navigator: N/A" + "\n";
        }
        return info;
    }
}
