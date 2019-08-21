package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * 类描述: MQ工厂类 
 * 创建人: baiqiufei 
 * 创建时间: 2017/10/13 10:30
 */
@Component
@Getter
public class MQChannelFactory {

    /**
     * kafka模板对象。 使用spring默认模板
     */
    @Autowired
    private KafkaTemplate<String, byte[]> producerTemplate;
}
