package com.yibu.modulestudy.designpattern.builders.demo1.build;

import com.yibu.modulestudy.designpattern.builders.demo1.cars.Car;
import com.yibu.modulestudy.designpattern.builders.demo1.cars.CarType;
import com.yibu.modulestudy.designpattern.builders.demo1.components.Engine;
import com.yibu.modulestudy.designpattern.builders.demo1.components.GPSNavigator;
import com.yibu.modulestudy.designpattern.builders.demo1.components.Transmission;
import com.yibu.modulestudy.designpattern.builders.demo1.components.TripComputer;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.designpattern.builders.demo1.build
 * @author: 振振
 * @date: 2022-09-22 21:41
 **/
public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
