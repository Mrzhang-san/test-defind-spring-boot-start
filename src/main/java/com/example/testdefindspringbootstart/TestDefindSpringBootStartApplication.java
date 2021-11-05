package com.example.testdefindspringbootstart;

import com.example.myspringbootstart.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class TestDefindSpringBootStartApplication implements CommandLineRunner {
    @Resource
    private MyService myService;

    public static void main(String[] args) {
        SpringApplication.run(TestDefindSpringBootStartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 调用打招呼方法
        myService.sayHi();
    }

}
