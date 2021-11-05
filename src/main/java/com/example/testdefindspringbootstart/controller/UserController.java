package com.example.testdefindspringbootstart.controller;

import com.example.testdefindspringbootstart.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public void userLogin(User user) {
        System.out.println(user.getCreateTime().toString());
        System.out.println("用户登录");
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("this is a simple test method..");
    }

}
