package com.springboot.service;

import com.springboot.bean.User;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/6 14:46
 * @Version 1.0
 */
public interface UserService {

    User findByUserName(String userName);
}
