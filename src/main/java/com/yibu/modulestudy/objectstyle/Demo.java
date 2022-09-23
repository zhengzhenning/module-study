package com.yibu.modulestudy.objectstyle;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.objectstyle
 * @author: 振振
 * @date: 2022-09-23 16:57
 **/
public class Demo {

    public static void main(String[] args) {

        System.err.println("继承");

        Circle circle = Circle.builder().radius(5L).background("红色").build();
        Double circlePerimeter = circle.perimeter();
        System.err.println("[继承特性]圆的周长：" + circlePerimeter);
        System.err.println("[继承特性]圆的信息：" + circle);

        System.err.println("---");

        Square square = Square.builder().length(10L).background("蓝色").build();
        Long perimeter = square.perimeter();
        System.err.println("[继承特性]正方形周长：" + perimeter);
        System.err.println("[继承特性]正方形信息：" + square);

        System.err.println("===");

        System.err.println("多态");

        Shape<Object> shape = new Shape<>();
        System.err.println("[多态特性]圆的信息：" + shape.info(circle));
        System.err.println("[多态特性]多态获取正方形的信息：" + shape.info(square));
    }
}
