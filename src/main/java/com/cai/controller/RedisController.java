package com.cai.controller;

import com.cai.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	@Autowired
	RedisService redisService;

	@RequestMapping("get/{key}")
	public Object getString(@PathVariable("key")String key){
		return redisService.getString(key);
	}
	@RequestMapping("set/{key}/{value}")
	public Object setString(@PathVariable("key")String key,@PathVariable("value")String value){
		 redisService.setString(key,value);
		 return "success";
	}
}
