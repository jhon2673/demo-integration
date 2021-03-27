package com.example.module.fanout;

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
public class FanoutSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送者
     * @param exchangeName 交换机名
     * @param routingKey 路由名
     * @param msg 要送送的消息
     */
    public void send(String exchangeName, String routingKey, String msg) {
        LOGGER.info("要发送的内容：" + msg);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, "hello, " + msg);
    }
}
