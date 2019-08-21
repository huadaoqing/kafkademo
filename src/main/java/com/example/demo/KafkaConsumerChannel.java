package com.example.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Listener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * 项目名称: Rainbow Stone for subscribe_task
 * 包: com.migu.rstone.config
 * 类名称: KafkaConsumerChannel.java 
 * 类描述:消费者服务通道 
 * 创建人: huadq 
 * 创建时间:2018/12/06
 */
@Configuration
@EnableKafka    
public class KafkaConsumerChannel {
    
    @Autowired
    private KafkaConsumerConfig consumerConfig;
    
    /**
     * 设置消费者监听内容工厂
     *
     * @return KafkaListenerContainerFactory
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> 
          kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, String> factory = null;
      factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(this.consumerFactory());
      factory.setConcurrency(consumerConfig.getCurrency());
      factory.getContainerProperties().setPollTimeout(Long.parseLong(consumerConfig.getPollTimeout()));
   //   factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
      
      return factory;
    }

    /**
     * 设置消费者连接工厂
     *
     * @return ConsumerFactory<String, String>
     */
    public ConsumerFactory<String, String> consumerFactory() {
      return new DefaultKafkaConsumerFactory<>(this.consumerConfigs());
    }

    /**
     * 设置消费者连接配置
     *  
     * @return Map<String, Object>
     */
    private Map<String, Object> consumerConfigs() {
      final Map<String, Object> propsMap = new ConcurrentHashMap<>();
      propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerConfig.getBootstrapServers());
      propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, consumerConfig.getGroupId());
      propsMap.put(ConsumerConfig.RETRY_BACKOFF_MS_CONFIG, consumerConfig.getRetries());
      propsMap.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG, consumerConfig.getBatchSize());
      propsMap.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG, consumerConfig.getBufferMemory());
      propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, consumerConfig.getEnableAutoCommit());
      propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000);
     // propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
      propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, consumerConfig.getAutoOffsetReset());
      propsMap.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, consumerConfig.getHeartbeatInterval());
      propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
      propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      return propsMap;
    }

    /**
     * 初始化消息监听器
     *
     * @return Listener
     */
    @Bean
    public Listener listener() {
    	Listener listener = new Listener();
    	//listener.setAckMode(AckMode.MANUAL_IMMEDIATE);
        return listener;
    }
}
