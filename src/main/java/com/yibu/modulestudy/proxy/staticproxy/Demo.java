package com.yibu.modulestudy.proxy.staticproxy;

/**
 * @program: module-study
 * @description: 验证代理模式
 * @packagename: com.yibu.modulestudy.dynamicproxy.pattern
 * @author: 振振
 * @date: 2022-07-14 14:06
 **/
public class Demo {

    public static void main(String[] args) {

        // 普通下载
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        long naive = test(naiveDownloader);
        System.err.println("----------------------------------------------------------");

        // 从缓存中下载
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());
        long smart = test(smartDownloader);


        System.err.println("===========================================================");
        System.err.println(String.format("naive time %s ms", naive));
        System.err.println(String.format("smart time %s ms", smart));

        System.err.println("===========================================================");
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");


    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("a");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("b");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("c");
        downloader.renderVideoPage("d");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}