package com.yibu.modulestudy.lambda.demo2;

import com.yibu.modulestudy.base.POJO;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.lambda.demo2
 * @author: 振振
 * @date: 2022-07-14 21:26
 **/
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Car extends POJO {
    private Integer weight;
}
