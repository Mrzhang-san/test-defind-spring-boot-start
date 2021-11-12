package com.example.testdefindspringbootstart.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置跨域访问
 */
public class CORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许所有跨域访问
        registry.addMapping("/**");
    }
   /* @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                //.allowedOrigins("http://localhost")
                .allowedMethods("POST", "GET");
    }*/
}
