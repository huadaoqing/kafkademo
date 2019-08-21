package com.example.demo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
/**
 * 项目名称: Rainbow Stone for subscribe_task
 * 包: com.migu.rstone.config
 * 类名称: KafkaConsumerConfig.java 
 * 类描述:消费者配置读取
 * 创建人: huadq 
 * 创建时间:2018/12/06
 */
@Configuration
@ConfigurationProperties
@Data
public class KafkaConsumerConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.consumer.groupId}")
    private String groupId;
    @Value("${spring.kafka.consumer.retries}")
    private String retries;
    @Value("${spring.kafka.consumer.batchSize}")
    private String batchSize;
    @Value("${spring.kafka.consumer.bufferMemory}")
    private String bufferMemory;
    @Value("${spring.kafka.consumer.heartbeatInterval}")
    private String heartbeatInterval;
    @Value("${spring.kafka.consumer.sessionTimeout}")
    private String sessionTimeout;
    @Value("${spring.kafka.consumer.maxPollRecords}")
    private String maxPollRecords;
    @Value("${spring.kafka.consumer.enableAutoCommit}")
    private String enableAutoCommit;
    @Value("${spring.kafka.consumer.concurrency}")
    private int currency;
    @Value("${spring.kafka.consumer.pollTimeout}")
    private String pollTimeout;
    @Value("${spring.kafka.consumer.autoOffsetReset}")
    private String autoOffsetReset;
    
    
}
