package com.springboot.service;

import com.springboot.domain.User;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/24 14:19
 * @Version 1.0
 */
public interface UserService {

    List<User> list();

    User readByName(String name);

    void save(User user);

    void batchSave(List<User> users);

    void update(User user);

    void delete(String id);
}
