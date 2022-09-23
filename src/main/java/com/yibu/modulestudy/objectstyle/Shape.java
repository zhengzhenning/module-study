package com.yibu.modulestudy.objectstyle;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @program: module-study
 * @description: 图形
 * @packagename: com.yibu.modulestudy.objectstyle
 * @author: 振振
 * @date: 2022-09-23 16:36
 **/
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Shape<T> {

    /**
     * 背景颜色
     */
    private String background;

    public <T extends Number> T perimeter() {
        return null;
    }

}
