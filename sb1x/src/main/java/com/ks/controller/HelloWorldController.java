package com.ks.controller;

import com.ks.dto.SbUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }


    @RequestMapping("/getUser")
    public SbUser getUser() {
        SbUser user = new SbUser();
        user.setUserName("小明");
        user.setPassword("xxxx");
        return user;
    }


}