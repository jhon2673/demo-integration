package com.springboot.service.impl;

import com.springboot.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/18 10:13
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImplTest.class);

    @Autowired
    private MailService mailService;

    /**
     * 测试简单邮件
     */
    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1511149683qq.com", "这是一封简单邮件", "这是一封普通的SpringBoot测试邮件");
        LOGGER.info("简单邮件发送成功");
    }
}