package com.cai.service.Impl;

import com.cai.bean.User;
import com.cai.mapper.UserMapper;
import com.cai.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Cacheable(cacheManager = "simpleCache")
	@Override
	public User getUserByName(String name) {
		return userMapper.findByName(name);
	}

	@Override
	public int addUser(String name, Integer age) {
		return userMapper.insert(name,age);
	}
}
