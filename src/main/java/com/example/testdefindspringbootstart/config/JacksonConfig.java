package com.example.testdefindspringbootstart.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper(){

        ObjectMapper objectMapper = new ObjectMapper();
        // 自定义日期转换格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }
}
