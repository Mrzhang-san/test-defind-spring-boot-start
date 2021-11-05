package com.example.testdefindspringbootstart.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 本节中的转换仅支持表单形式请求，不支持 application/json 的请求方式！
 */
@Configuration
public class MyDateFormatMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));

    }
}
