package com.cai.controller;

import com.cai.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("show/{name}")
    public Object show(@PathVariable("name")String name){
        return userService.getUserByName(name);
    }
}
