package com.yibu.modulestudy.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.base
 * @author: 振振
 * @date: 2022-07-14 13:41
 **/
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class POJO {

    private String id;
    private String name;
    private Date createTime;
    private Date modifyTime;
}
