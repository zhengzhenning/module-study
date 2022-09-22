package com.yibu.modulestudy.designpattern.builders.build;

import com.yibu.modulestudy.designpattern.builders.cars.CarType;
import com.yibu.modulestudy.designpattern.builders.cars.Manual;
import com.yibu.modulestudy.designpattern.builders.components.Engine;
import com.yibu.modulestudy.designpattern.builders.components.GPSNavigator;
import com.yibu.modulestudy.designpattern.builders.components.Transmission;
import com.yibu.modulestudy.designpattern.builders.components.TripComputer;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.designpattern.builders.build
 * @author: 振振
 * @date: 2022-09-22 21:42
 **/
public class CarManualBuilder implements Builder{
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

    public Manual getResult() {
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
