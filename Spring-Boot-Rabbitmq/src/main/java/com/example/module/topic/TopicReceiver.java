package com.example.module.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 14:57
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicReceiver.class);

    @RabbitHandler
    public void receive(String str) {
        LOGGER.info("message接收到的消息：" + str);
    }
}
