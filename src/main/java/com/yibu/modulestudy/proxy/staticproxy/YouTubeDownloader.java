package com.yibu.modulestudy.proxy.staticproxy;

import java.util.Map;

/**
 * @program: module-study
 * @description: 媒体下载应用 - Client
 * @packagename: com.yibu.modulestudy.dynamicproxy.pattern
 * @author: 振振
 * @date: 2022-07-14 14:04
 **/
public class YouTubeDownloader {

    private ThirdPartyYouTubeLib api;

    public YouTubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    /**
     * 渲染视频列表
     *
     * @param videoId
     */
    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Video page (imagine fancy HTML)");
        System.out.println("ID: " + video.getId());
        System.out.println("Title: " + video.getTitle());
        System.out.println("Video: " + video.toString());
        System.out.println("-------------------------------\n");
    }

    /**
     * 渲染流行视频
     */
    public void renderPopularVideos() {
        Map<String, Video> list = api.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.getId() + " / Title: " + video.getTitle());
        }
        System.out.println("-------------------------------\n");
    }
}
