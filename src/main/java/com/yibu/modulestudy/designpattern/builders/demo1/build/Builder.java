package com.yibu.modulestudy.designpattern.builders.demo1.build;

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
public interface Builder {
    /**
     * 设置车辆类型
     * {@link CarType}
     *
     * @param type
     */
    void setCarType(CarType type);

    /**
     * 设置座椅💺数
     *
     * @param seats
     */
    void setSeats(int seats);

    /**
     * 设置车辆引擎
     *
     * @param engine
     */
    void setEngine(Engine engine);

    /**
     * 设置变速箱类型
     * {@link Transmission}
     *
     * @param transmission
     */
    void setTransmission(Transmission transmission);

    /**
     * 设置电子仪表盘
     * @param tripComputer
     */
    void setTripComputer(TripComputer tripComputer);

    /**
     * 设置GPS导航器
     * @param gpsNavigator
     */
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
