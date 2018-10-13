package com.cai.controller;

import com.cai.bean.User;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {

    private static AtomicInteger count = new AtomicInteger(0);

    @RequestMapping("/test1")
    public Object test(User user){
        // 可以接收到 对象参数
        return user;
    }
    @RequestMapping("/test2")
    public Object test2(@RequestParam("user") User user){
        // 无法接收到对象参数
        return user;
    }
    @RequestMapping("/test3")
    public Object test3(@RequestParam("user")User user,String test){
        // 无法接受对象参数
        return test+user;
    }
    @RequestMapping("/test4")
    public Object test4(@ModelAttribute("user")User user){
        // 可以接收到对象参数
        return user;
    }
    @RequestMapping("/test5")
    public Object test5(User user,String test){
        // 都可以接收到
        return test+user;
    }
    @RequestMapping("/test6")
    public Object test6(@ModelAttribute("user")User user,String test){
        // 都可以接收到
        return test+user;
    }
    @RequestMapping("count")
    public Object count(){
        return count.addAndGet(1);
    }

 }
