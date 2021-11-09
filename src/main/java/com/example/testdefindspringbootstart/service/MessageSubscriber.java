package com.example.testdefindspringbootstart.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class MessageSubscriber {

    private static String CHANNEL = "message_space";

    public MessageSubscriber(RedisTemplate redisTemplate) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        redisConnection.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                //接受消息的处理逻辑
                System.out.println("Receive message : " + message);
            }
        },CHANNEL.getBytes(StandardCharsets.UTF_8));

    }

}
