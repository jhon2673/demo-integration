package com.springboot.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/24 9:11
 * @Version 1.0
 */
@Slf4j
public class GrabRedPacketTask implements Runnable {

    private RedisTemplate redisTemplate;

    private RedisScript<Integer> redPacketRedisScript;

    private CountDownLatch switchLatch;

    private CountDownLatch countLatch;

    private Integer userId;

    private List<String> keyList;

    public GrabRedPacketTask(RedisTemplate redisTemplate, RedisScript<Integer> redPacketRedisScript, CountDownLatch switchLatch, CountDownLatch countLatch, Integer userId, List<String> keyList) {
        this.redisTemplate = redisTemplate;
        this.redPacketRedisScript = redPacketRedisScript;
        this.switchLatch = switchLatch;
        this.countLatch = countLatch;
        this.userId = userId;
        this.keyList = keyList;
    }

    @Override
    public void run() {
        try {
            switchLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> argList = Lists.newArrayList(String.valueOf(userId));
        try {
            String result = redisTemplate.execute(redPacketRedisScript, keyList, argList).toString();
            switch (Integer.parseInt(result)) {
                case 0:
                    log.info("UserId:{} 已经抢到了红包，不能再抢.", userId);
                    break;
                case 1:
                    log.info("UserId:{} 眼疾手快，抢到了红包 !!!", userId);
                    break;
                case 2:
                    log.info("UserId:{} 手慢，没抢到红包.", userId);
                    break;
                default:
                    log.info("Illegal Result: {}", result);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countLatch.countDown();
        }
    }
}
