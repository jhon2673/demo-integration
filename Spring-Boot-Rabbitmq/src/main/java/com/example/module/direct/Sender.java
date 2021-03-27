package com.example.module.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 14:51
 * @Version 1.0
 */
@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private final static String QUEUE_NAME = "q_test_01";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        LOGGER.info("要发送的内容：" + msg);
        rabbitTemplate.convertAndSend(QUEUE_NAME, "hello, " + msg);
    }
}
