package com.example.testdefindspringbootstart;

import com.example.myspringbootstart.MyService;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.Resource;

@EnableSwagger2Doc
@EnableCaching//开启缓存功能
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
