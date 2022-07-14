package com.yibu.modulestudy.proxy.staticproxy;

import java.util.Map;

/**
 * // 为了节省网络带宽，我们可以将请求结果缓存下来并保存一段时间。但你可能无
 * // 法直接将这些代码放入服务类中。比如该类可能是第三方程序库的一部分或其签
 * // 名是`final（最终）`。因此我们会在一个实现了服务类接口的新代理类中放入
 * // 缓存代码。当代理类接收到真实请求后，才会将其委派给服务对象。
 * @program: module-study
 * @description: 第三方视频源
 * @packagename: com.yibu.modulestudy.dynamicproxy.pattern
 * @author: 振振
 * @date: 2022-07-14 13:39
 **/
public interface ThirdPartyYouTubeLib {
    Map<String, Video> popularVideos();

    Video getVideo(String videoId);
}
