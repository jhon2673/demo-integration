package com.springboot.service.impl;

import com.springboot.common.Page;
import com.springboot.dao.UserRepository;
import com.springboot.domain.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/24 14:20
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User readByName(String name) {
        return userRepository.readByName(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void batchSave(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public void update(User user) {
        // 由于userRepository更新是使用save实现，当_id相同时即为更新
        // 在这里我们需要根据id而不是_id来更新，因此不适用
        Query query = new Query(new Criteria("id").is(user.getId()));
        Update update = new Update().set("name", user.getName());
        mongoTemplate.updateMulti(query, update, User.class);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
