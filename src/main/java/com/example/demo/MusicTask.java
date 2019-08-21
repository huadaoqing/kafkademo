package com.example.demo;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;



/**
 * 项目名称: Rainbow Stone for subscribe_task
 * 包: com.migu.rstone.kafka
 * 类名称: MusicConsumer.java 
 * 类描述:音乐退订任务类
 * 创建人: huadq 
 * 创建时间:2018/12/06
 */
@Component
public class MusicTask {
	/**
	 * 音乐退订消息监听
	 * 
	 * @param cr record
	 * @param ack Acknowledgment
	 * @author 华道青
	 */
	@KafkaListener(topics = "rainbow-stone_subscribe")
	public void musicUnSubListen(ConsumerRecord<?, ?> cr, Acknowledgment ack) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		System.out.println(formatter.format(new Date(System.currentTimeMillis()))+":"+cr.partition()+":"+cr.offset());
		ack.acknowledge();
	}
}
