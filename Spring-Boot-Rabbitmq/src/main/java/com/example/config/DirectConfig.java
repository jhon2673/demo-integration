package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/1 10:39
 * @Version 1.0
 */
@Configuration
public class DirectConfig {
    final static String QUEUE_NAME = "q_test_01";

    @Bean
    public Queue Queue() {
        return new Queue(QUEUE_NAME);
    }
}
