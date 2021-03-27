package com.springboot.dao;

import com.springboot.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/24 14:15
 * @Version 1.0
 */
public interface UserRepository extends MongoRepository<User, String> {

    User readByName(String name);
}
