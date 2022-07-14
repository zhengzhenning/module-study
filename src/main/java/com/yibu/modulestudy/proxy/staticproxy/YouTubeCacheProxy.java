package com.yibu.modulestudy.proxy.staticproxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: module-study
 * @description:
 * @packagename: com.yibu.modulestudy.dynamicproxy.pattern
 * @author: 振振
 * @date: 2022-07-14 13:45
 **/

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private Map<String, Video> cachePopular = new HashMap<String, Video>();
    private Map<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCacheProxy() {
        // 实例化
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public Map<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("从缓存中检索视频列表....");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.err.println(String.format("从缓存中检索到视频:%s(%s)", video.getTitle(), video.getId()));
        }
        return video;
    }

    /**
     * 重置
     */
    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
