package com.yibu.modulestudy.kafka;

import java.util.concurrent.ExecutionException;

/**
 * @program: workflow-engine
 * @description: Kafka 生产者
 * @packagename: com.wk.workflow.infrastructure.kafka
 * @author: 振振
 * @date: 2022-04-28 15:56
 **/
public interface KafkaProducer {


    /**
     * 发送同步消息
     *
     * @param topic
     * @param data
     * @throws ExecutionException
     * @throws InterruptedException
     */
    void sendSyncMessage(String topic, String data) throws ExecutionException, InterruptedException;

    /**
     * 发送普通消息
     *
     * @param topic
     * @param data
     */
    void sendMessage(String topic, String data);

    /**
     * 发送普通消息
     * @param topic
     * @param key
     * @param data
     */
    void sendMessage(String topic, String key,String data);







}
