package com.yibu.modulestudy.lambda.demo1;

import com.yibu.modulestudy.base.POJO;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.lambda
 * @author: 振振
 * @date: 2022-07-14 20:44
 **/
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Apple extends POJO {

    private String color;
    private Integer weight;
}
