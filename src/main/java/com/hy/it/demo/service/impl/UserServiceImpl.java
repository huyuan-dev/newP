package com.hy.it.demo.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hy.it.demo.conf.AliyunConfig;
import com.hy.it.demo.entity.User;
import com.hy.it.demo.mapper.UserMapper;
import com.hy.it.demo.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 短信验证码
     * @param phone
     * @return
     */
    @Override
    public Map<String, Object> SmsVerification(String phone) {
        //Map<String, Object> map = new HashMap<>();
        try {
            return AliyunConfig.sendSms(phone);

        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

}
