package com.springboot.controller;

import com.springboot.annotation.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/5 10:47
 * @Version 1.0
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Log("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) {
        logger.info("执行方法一");
    }

    @Log("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        logger.info("执行方法二");
        Thread.sleep(2000);
    }

    @Log("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) {
        logger.info("执行方法三");
    }
}
