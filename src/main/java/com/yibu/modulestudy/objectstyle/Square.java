package com.yibu.modulestudy.objectstyle;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @program: module-study
 * @description: 正方形
 * @packagename: com.yibu.modulestudy.objectstyle
 * @author: 振振
 * @date: 2022-09-23 16:54
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Square extends Shape<Long> {

    private Long length;

    @Override
    public Long perimeter() {
        return 4 * length;
    }

    @Override
    public String draw() {
        return "画🟥🟥🟥🟥🟥🟥";
    }
}
