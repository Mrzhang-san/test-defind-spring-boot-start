package com.example.testdefindspringbootstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/login")
    public void userLogin(){
        System.out.println("用户登录");
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("this is a simple test method..");
    }

}
