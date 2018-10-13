package com.cai.service;

import com.cai.bean.User;

public interface UserService {
	User getUserByName(String name);

	int addUser(String name, Integer age);

}
