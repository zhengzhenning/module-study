package com.yibu.modulestudy.objectstyle;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @program: module-study
 * @description: 圆
 * @packagename: com.yibu.modulestudy.objectstyle
 * @author: 振振
 * @date: 2022-09-23 16:39
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Circle extends Shape<Double> {

    private Long radius;

    public static final Double PAI = 3.1415926;

    /**
     * 计算周长
     *
     * @return
     */
    @Override
    public Double perimeter() {
        return 2 * PAI * radius;
    }
}
