package com.yibu.modulestudy.designpattern.creational.builders.demo1.components;

/**
 * @program: module-study
 * @description: 引擎
 * @packagename: com.yibu.modulestudy.designpattern.builders.demo1.components
 * @author: 振振
 * @date: 2022-09-22 21:39
 **/
public class Engine {
    private final double volume;
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on() {
        started = true;
    }

    public void off() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void go(double mileage) {
        if (started) {
            this.mileage += mileage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }
}
