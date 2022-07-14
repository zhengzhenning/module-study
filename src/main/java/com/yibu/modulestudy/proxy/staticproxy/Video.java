package com.yibu.modulestudy.proxy.staticproxy;

import com.yibu.modulestudy.base.POJO;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @program: module-study
 * @description: Video
 * @packagename: com.yibu.modulestudy.dynamicproxy.pattern
 * @author: 振振
 * @date: 2022-07-14 13:40
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Video extends POJO {

    private String title;

}
