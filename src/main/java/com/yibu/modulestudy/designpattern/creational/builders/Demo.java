package com.yibu.modulestudy.designpattern.creational.builders;

import com.yibu.modulestudy.designpattern.builders.demo1.build.CarBuilder;
import com.yibu.modulestudy.designpattern.builders.demo1.build.CarManualBuilder;
import com.yibu.modulestudy.designpattern.creational.builders.demo1.cars.Car;
import com.yibu.modulestudy.designpattern.creational.builders.demo1.cars.Manual;
import com.yibu.modulestudy.designpattern.creational.builders.demo1.director.Director;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.designpattern.builders
 * @author: 振振
 * @date: 2022-09-22 21:45
 **/
public class Demo {
    public static void main(String[] args) {
        // 主管：负责造车
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        // 主观造一辆【运动型】汽车
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("汽车造完:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\n汽车《使用手册》已生成:\n" + carManual.print());

        System.err.println("---");

        CarBuilder suvCarBuilder = new CarBuilder();
        director.constructSUV(suvCarBuilder);
        Car suvCar = suvCarBuilder.getResult();
        System.out.println("汽车造完:\n" + suvCar.getCarType());
        CarManualBuilder suvCarManualBuilder = new CarManualBuilder();
        director.constructSUV(suvCarManualBuilder);
        Manual suvCarManual = suvCarManualBuilder.getResult();
        System.out.println("\n汽车《使用手册》已生成:\n" + suvCarManual.print());


    }
}
