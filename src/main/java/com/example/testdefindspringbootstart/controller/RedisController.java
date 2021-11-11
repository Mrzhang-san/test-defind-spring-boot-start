package com.example.testdefindspringbootstart.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class RedisController {
    private static String CHANNEL = "message_space";
  /* private RedisTemplate<String,String> redisTemplate;

      public RedisController(RedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @GetMapping("/publish")
    public void publish(@RequestParam String message) {
        redisTemplate.convertAndSend(CHANNEL,message);

    }*/

}
