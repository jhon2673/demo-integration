package com.springboot.mapper;

import com.springboot.bean.Func;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/11 20:03
 * @Version 1.0
 */
@Mapper
public interface UserFuncMapper {

    /**
     * 根据用户名获取所有权限
     *
     * @param userName
     * @return
     */
    List<Func> findByUserName(String userName);
}
