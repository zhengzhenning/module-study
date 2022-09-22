package com.yibu.modulestudy.designpattern.builders.components;

import com.yibu.modulestudy.designpattern.builders.cars.Car;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.designpattern.builders.components
 * @author: 振振
 * @date: 2022-09-22 21:40
 **/
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
