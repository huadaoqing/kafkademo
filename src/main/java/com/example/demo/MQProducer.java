package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 类描述: MQ消息生产
 * 创建人: baiqiufei
 * 创建时间: 2017/10/13 10:30
 */
@Component
public class MQProducer {

    private static final Logger LOG = LoggerFactory.getLogger(MQProducer.class);

//    public static final ExecutorService HTTPPOOL = Executors.newFixedThreadPool(2);

    @Autowired
    MQChannelFactory mqChannelFactory;

    /**
     * 发送MQ消息，支持异常重发
     * 
     * @param topic
     * @param data
     */
    public boolean send(String topic, String data){
        LOG.info("send mq info, topic={}, data={}", topic, data);
        try {
            this.mqChannelFactory.getProducerTemplate().send(topic, data.getBytes("utf-8"));
        } catch (Exception e) {
            LOG.warn("error when send mq info. topic={}, data={}, ", topic, data, e);
            return false;
        }
        return true;
    }

    /**
     * 发送MQ消息，支持按key值做partition分区
     * 
     * @param topic
     * @param key 
     * @param data
     */
    public boolean send(String topic, String key, String data){
        LOG.info("send mq info, topic={}, key={}, data={}", topic, key, data);
        try {
            this.mqChannelFactory.getProducerTemplate().send(topic, key, data.getBytes("utf-8"));
        } catch (Exception e) {
            LOG.warn("error when send mq info. topic={}, key={}, data={}, ", topic, key, data, e);
            return false;
        }
        return true;
    }
}
