package com.hy.it.demo.service.impl;

import com.hy.it.demo.entity.User;
import com.hy.it.demo.mapper.UserMapper;
import com.hy.it.demo.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
   private UserMapper userMapper;
    /**
     * 根据用户名和密码查询数据
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User queryUser(String userName,String password) {
       User user=userMapper.getUser(userName,password);
        return user;
    }
}
