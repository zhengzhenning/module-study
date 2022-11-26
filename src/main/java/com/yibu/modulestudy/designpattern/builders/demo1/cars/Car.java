package com.yibu.modulestudy.designpattern.builders.demo1.cars;

import com.yibu.modulestudy.designpattern.builders.demo1.components.Engine;
import com.yibu.modulestudy.designpattern.builders.demo1.components.GPSNavigator;
import com.yibu.modulestudy.designpattern.builders.demo1.components.Transmission;
import com.yibu.modulestudy.designpattern.builders.demo1.components.TripComputer;

/**
 * @program: module-study
 * @description: 汽车
 * @packagename: com.yibu.modulestudy.designpattern.builders
 * @author: 振振
 * @date: 2022-09-22 21:36
 **/
public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission,
               TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}