package com.yibu.modulestudy.lambda.demo4;

import com.yibu.modulestudy.base.POJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.lambda.demo4
 * @author: 振振
 * @date: 2022-07-22 17:18
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PeoplePO extends POJO {

    private String desc;

}
