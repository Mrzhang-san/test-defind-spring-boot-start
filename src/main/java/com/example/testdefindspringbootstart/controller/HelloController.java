package com.example.testdefindspringbootstart.controller;

import com.example.testdefindspringbootstart.bean.User;
import com.example.testdefindspringbootstart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    /**
     *  template might not exist or might not be accessible by any of the configured Template Resolvers
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "line";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/hnhe")
    @ResponseBody
    public List<User> kucunData(Model model) {
        User user = new User("AAA", 10);
        User user1 = new User("AAA2", 101);
        User user2 = new User("AAA1", 103);
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        return list;
    }
}