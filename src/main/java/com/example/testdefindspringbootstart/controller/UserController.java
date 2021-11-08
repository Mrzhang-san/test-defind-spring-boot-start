package com.example.testdefindspringbootstart.controller;

import com.example.testdefindspringbootstart.bean.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/user")
    public User userLogin(@RequestBody User user) {
        System.out.println(user.getCreateTime().toString());
        System.out.println("用户登录");
        return user;
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("this is a simple test method..");
    }

}
