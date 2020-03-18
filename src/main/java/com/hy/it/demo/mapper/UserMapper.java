package com.hy.it.demo.mapper;

import com.hy.it.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 查询用户
     * @param name
     * @param password
     * @return
     */
    User getUser(@Param("userName") String name,@Param("password") String password);
}
