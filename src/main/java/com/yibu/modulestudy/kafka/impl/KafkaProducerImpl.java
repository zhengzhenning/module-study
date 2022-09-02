package com.yibu.modulestudy.kafka.impl;

import com.yibu.modulestudy.kafka.KafkaProducer;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * @program: workflow-engine
 * @description: KAKFA 生产者
 * @packagename: com.wk.workflow.infrastructure.kafka.impl
 * @author: 振振
 * @date: 2022-04-28 16:05
 **/
@Component
public class KafkaProducerImpl implements KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerImpl.class);

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 发送同步消息
     *
     * @param topic
     * @param data
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public void sendSyncMessage(String topic, String data) throws ExecutionException, InterruptedException {
        SendResult<String, String> sendResult = kafkaTemplate.send(topic, data).get();
        RecordMetadata recordMetadata = sendResult.getRecordMetadata();
        log.info("发送同步消息成功!发送的主题为:{}", recordMetadata.topic());
    }

    /**
     * 发送普通消息
     *
     * @param topic
     * @param data
     */
    @Override
    public void sendMessage(String topic, String data) {
        if (StringUtils.isBlank(topic)) {
            log.info("topic未指定,未推送消息体:{}", data);
            return;
        }
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(success -> log.info("给{}发送消息成功!", topic), failure -> log.error("给{}发送消息失败!失败原因是:{}", topic, failure.getMessage()));
    }

    /**
     * 发送普通消息
     *
     * @param topic
     * @param key
     * @param data
     */
    @Override
    public void sendMessage(String topic, String key, String data) {
        if (StringUtils.isBlank(topic)) {
            log.info("topic未指定,未推送消息体:{}", data);
            return;
        }
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic,key, data);
        future.addCallback(success -> log.info("给{}发送消息成功!", topic), failure -> log.error("给{}发送消息失败!失败原因是:{}", topic, failure.getMessage()));
    }


}
