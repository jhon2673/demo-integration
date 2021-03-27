package com.springboot.mapper;

import com.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/6 13:45
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    User findByUserName(String userName);
}
