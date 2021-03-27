package com.example.module.fanout;

import com.example.module.topic.TopicSender;
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
@RequestMapping("/fanout")
public class FanoutTest {

    @Autowired
    private TopicSender topicSender;

    @RequestMapping("/send")
    public String send() {
        topicSender.send("fanoutExchange", "", "hi, fanout message!");

        return "send success!";
    }
}
