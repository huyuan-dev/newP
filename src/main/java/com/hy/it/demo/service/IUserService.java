package com.hy.it.demo.service;

import com.hy.it.demo.entity.User;

import java.util.Map;

public interface IUserService {
    /**
     * 根据用户名和密码查询数据
     * @param userName
     * @param password
     * @return
     */
    User queryUser(String userName,String password);

    Map<String, Object> SmsVerification(String phone);
}
