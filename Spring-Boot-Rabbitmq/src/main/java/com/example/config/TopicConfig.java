package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 15:47
 * @Version 1.0
 */
@Configuration
public class TopicConfig {
    final static String QUEUE_NAME = "topic.message";
    final static String QUEUE_NAME2 = "topic.messages";

    @Bean
    public Queue messageQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue messagesQueue() {
        return new Queue(QUEUE_NAME2);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue messageQueue, TopicExchange exchange) {
        return BindingBuilder.bind(messageQueue).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue messagesQueue, TopicExchange exchange) {
        return BindingBuilder.bind(messagesQueue).to(exchange).with("topic.#");
    }
}
