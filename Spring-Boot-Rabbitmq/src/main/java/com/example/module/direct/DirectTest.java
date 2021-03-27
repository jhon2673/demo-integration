package com.example.module.direct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/1 17:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/direct")
public class DirectTest {

    @Autowired
    private Sender sender;

    @RequestMapping("send")
    public String send() {
        sender.send("pzh");
        return "send success!";
    }

}
