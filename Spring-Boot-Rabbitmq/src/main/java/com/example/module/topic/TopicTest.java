package com.example.module.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 15:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/topic")
public class TopicTest {

    @Autowired
    private TopicSender topicSender;

    @RequestMapping("/send1")
    public String send1() {
        topicSender.send("exchange", "topic.message", "hi, i am message 1");

        return "send1 success!";
    }

    @RequestMapping("/send2")
    public String send2() {
        topicSender.send("exchange", "topic.messages", "hi, i am message 2");

        return "send2 success!";
    }
}
