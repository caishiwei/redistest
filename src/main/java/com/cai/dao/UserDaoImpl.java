package com.cai.dao;

import com.cai.mapper.UserMapper;
import com.cai.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class UserDaoImpl {
    @Resource
    private UserMapper userMapper;
    @Cacheable()
    public User getUserByName(String name){
        return userMapper.findByName(name);
    }
}
