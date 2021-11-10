package com.example.testdefindspringbootstart.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * asswordEncoder是一个密码解析器
 *
 */
public class MyPasswordEncoder implements PasswordEncoder {
     @Override
     public String encode(CharSequence rawPassword) {
         return rawPassword.toString();
     }
 
     @Override
     public boolean matches(CharSequence rawPassword, String encodedPassword) {
         return encodedPassword.equals(rawPassword);
     }
 }