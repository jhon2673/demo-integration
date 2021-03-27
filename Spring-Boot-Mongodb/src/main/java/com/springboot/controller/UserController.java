package com.springboot.controller;

import com.springboot.common.ResultMsg;
import com.springboot.domain.User;
import com.springboot.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/24 14:36
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ResultMsg list() {
        List<User> userList;
        try {
            userList = userService.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(-1, "错误");
        }

        return new ResultMsg(0, "请求成功", userList);
    }

    @RequestMapping("/readByName")
    public ResultMsg read(String name) {
        User user;
        try {
            user = userService.readByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(-1, "错误");
        }
        return new ResultMsg(0, "请求成功", user);
    }

    @RequestMapping("/save")
    public ResultMsg save(@RequestBody User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(-1, "错误");
        }
        return new ResultMsg(0, "请求成功");
    }

    @RequestMapping("/batchSave")
    public ResultMsg batchSave() {
        try {
            userService.batchSave(generateUsers());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(-1, "错误");
        }
        return new ResultMsg(0, "请求成功");
    }

    @RequestMapping("/update")
    public ResultMsg update(User user) {
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(-1, "错误");
        }
        return new ResultMsg(0, "请求成功");
    }

    @RequestMapping("/delete")
    public ResultMsg delete(String id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(-1, "错误");
        }
        return new ResultMsg(0, "请求成功");
    }

    /**
     * 批量生产user
     *
     * @return userList
     */
    private List<User> generateUsers() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(1010 + i + "");
            user.setName(RandomStringUtils.random(3, new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'}));
            user.setPassword(RandomStringUtils.random(6, new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}));
            user.setSex(new Random().nextInt(2) + 1);
            user.setBirthday(new Date());
            user.setEmail(RandomStringUtils.random(5, new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}) + "@163.com");
            user.setStatus(new Random().nextInt(2));
            userList.add(user);
        }
        return userList;
    }
}
