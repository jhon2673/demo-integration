package com.springboot.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import com.springboot.annotation.RateLimiter;
import com.springboot.task.GrabRedPacketTask;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/16 20:31
 * @Version 1.0
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisScript<Integer> redPacketRedisScript;

    @RateLimiter(value = 5)
    @GetMapping("/test1")
    public Dict test1() {
        log.info("【test1】被执行了。。。。。");
        return Dict.create().set("msg", "hello,world!").set("description", "别想一直看到我，不信你快速刷新看看~");
    }

    @GetMapping("/test2")
    public Dict test2() {
        log.info("【test2】被执行了。。。。。");
        return Dict.create().set("msg", "hello,world!").set("description", "我一直都在，卟离卟弃");
    }

    @RateLimiter(value = 2, key = "测试自定义key")
    @GetMapping("/test3")
    public Dict test3() {
        log.info("【test3】被执行了。。。。。");
        return Dict.create().set("msg", "hello,world!").set("description", "别想一直看到我，不信你快速刷新看看~");
    }

    @RequestMapping("/grab")
    public String grab() {
        //红包List Key
        String redPacketKey = "rp-list-9527";
        //抢到红包的用户hash Key
        String gainUserKey = "rp-user-map-9527";

        //红包分发总金额
        Integer sum = 0;
        //红包实际被抢总金额
        AtomicReference<Integer> total = new AtomicReference<>(0);

        //门闩一：以便所有线程同时开始运行
        CountDownLatch switchLatch = new CountDownLatch(1);
        //门闩二：以便所有线程都能运行完成
        CountDownLatch countLatch = new CountDownLatch(10);

        // 创建一个可缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            // 先清空
            redisTemplate.delete(redPacketKey);
            redisTemplate.delete(gainUserKey);

            // 预先生成5个红包
            for (int i = 0; i < 5; i++) {
                int money = RandomUtil.randomInt(1, 10);
                sum += money;
                // 存入缓存
                redisTemplate.opsForList().rightPush(redPacketKey, money);
            }
            List<String> redPacketList = redisTemplate.opsForList().range(redPacketKey, 0, redisTemplate.opsForList().size(redPacketKey));
            log.info("共生成{}元的红包,金额分别为:{}", sum, redPacketList);

            //脚本执行所需的Key列表，也可以在脚本中直接写死
            List<String> keyList = Lists.newArrayList(redPacketKey, gainUserKey);
            log.info("=============开始抢红包=============");
            //有7个人抢红包,有些人抢了2次
            for (int i = 0; i < 10; i++) {
                //有些人手快，抢了多次
                int finalUserId = i % 7;
                //进行抢红包
                executorService.submit(new GrabRedPacketTask(redisTemplate, redPacketRedisScript, switchLatch, countLatch, finalUserId, keyList));
            }
            switchLatch.countDown();
            executorService.shutdown();
            countLatch.await();

            //显示抢红包情况
            log.info("=============抢红包结束=============");
            Map<String, String> gainUserMap = redisTemplate.opsForHash().entries(gainUserKey);
            gainUserMap.forEach((userId, money) -> {
                log.info("UserId:{},money:{}", userId, money);
                Integer now = total.get();
                total.compareAndSet(now, now + Integer.parseInt(money));
            });
            log.info("共生成{}元的红包,实际被抢红包总额{}元。", sum, total.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "finish";
    }
}
