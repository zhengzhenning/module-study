package com.yibu.modulestudy.proxy.staticproxy;

import cn.hutool.core.util.IdUtil;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * // 服务连接器的具体实现。该类的方法可以向腾讯视频请求信息。请求速度取决于
 * // 用户和腾讯视频的互联网连接情况。如果同时发送大量请求，即使所请求的信息
 * // 一模一样，程序的速度依然会减慢。
 *
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.dynamicproxy.pattern
 * @author: 振振
 * @date: 2022-07-14 13:45
 **/
public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    /**
     * 模拟网络延迟
     */
    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        // 模拟网络延迟
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    private Map<String, Video> getRandomVideos() {
        System.out.print("Downloading populars... ");

        // 模拟网络延迟
        experienceNetworkLatency();

        Video video = Video.builder().id("a").title("神雕侠侣.avi").name("神雕侠侣").build();
        Video video2 = Video.builder().id("b").title("蜘蛛侠.mp4").name("蜘蛛侠").build();
        Video video3 = Video.builder().id("c").title("大金刚.mov").name("大金刚").build();
        Video video4 = Video.builder().id("d").title("我和我的祖国.avi").name("我和我的祖国").build();
        Video video5 = Video.builder().id("e").title("我和我的家乡.avi").name("我和我的家乡").build();

        List<Video> videos = Lists.newArrayList(video, video2, video3, video4, video5);
        Map<String, Video> maps = videos.stream().collect(Collectors.toMap(Video::getId, Function.identity(), (key1, key2) -> key2));

        System.out.print("Done!" + "\n");
        return maps;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        // 模拟网络延迟
        experienceNetworkLatency();
        Video video = Video.builder().id(IdUtil.simpleUUID()).name("some video title").build();

        System.out.print("Done!" + "\n");
        return video;
    }

    @Override
    public Map<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }
}
