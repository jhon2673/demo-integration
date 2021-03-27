package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/24 10:48
 * @Version 1.0
 */
@Controller
@RequestMapping("/third")
public class ThirdController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdController.class);

    /**
     * 模拟第三方接口
     * @param request
     * @param dn
     * @param client_id
     * @param serviceCode
     * @param bookTime
     * @param rights
     * @param state
     * @param sig
     * @return
     */
    @RequestMapping("/openService")
    @ResponseBody
    public Map<String, Object> thirdService(HttpServletRequest request, String dn, String client_id, String serviceCode, String bookTime, String rights, String state, String sig) {
        LOGGER.info("第三方开通权益 dn:" + dn + " client_id:" + client_id + " serviceCode:" + serviceCode + " bookTime:" + bookTime + " rights:" + rights + " state:" + state + " sig:" + sig);

        Map<String, Object> map = new HashMap<>();
        try {
            LOGGER.info("第三方正在为您努力开通...");

            map.put("ret", 1);
            map.put("msg", "请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("ret", 2);
            map.put("msg", "请求失败");
        }

        return map;
    }
}
