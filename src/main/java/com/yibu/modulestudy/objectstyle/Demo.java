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

        Circle circle = Circle.builder().radius(5L).background("红色").build();
        Double circlePerimeter = circle.perimeter();
        System.err.println(circlePerimeter);
        System.err.println(circle);

        System.err.println("===");

        Square square = Square.builder().length(10L).background("蓝色").build();
        Long perimeter = square.perimeter();
        System.err.println(perimeter);
        System.err.println(square);
    }
}
