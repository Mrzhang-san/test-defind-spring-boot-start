package com.example.testdefindspringbootstart.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private int id;
    private String username;
    private String password;
    private int age;

    public Customer(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
