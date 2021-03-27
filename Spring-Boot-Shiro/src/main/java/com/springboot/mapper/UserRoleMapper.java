package com.springboot.mapper;

import com.springboot.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/11 20:02
 * @Version 1.0
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 根据用户名获取所有角色
     *
     * @param userName
     * @return
     */
    List<Role> findByUserName(String userName);

}
