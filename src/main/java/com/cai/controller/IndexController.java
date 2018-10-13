package com.cai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "www page";
    }

    @RequestMapping("/view")
    public Object view() {
        return "this is www index page";
    }

    @RequestMapping("/testEncoding")
    public Object encoding(){
        return "中文可以显示";
    }


}
