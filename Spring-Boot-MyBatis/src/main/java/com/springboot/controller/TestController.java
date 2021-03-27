package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/14 19:07
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/index")
    public String index() {
        LOGGER.info("跳转到首页");

        return "jsp/index";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable String id) {
        LOGGER.info("跳转到详情:" + id);
        model.addAttribute("id", id);

        return "jsp/detail";
    }


}
