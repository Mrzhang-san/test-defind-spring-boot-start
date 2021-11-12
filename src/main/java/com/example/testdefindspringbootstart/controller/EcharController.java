package com.example.testdefindspringbootstart.controller;

import com.example.testdefindspringbootstart.bean.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EcharController {

    @RequestMapping("/show")
    public List<Customer> showBar(){
        Customer customer = new Customer("张三", "123", 12);
        Customer customer1 = new Customer("李四", "456", 23);
        Customer customer2 = new Customer("王五", "789", 45);
        ArrayList<Customer> list = new ArrayList<>();

        list.add(customer);
        list.add(customer1);
        list.add(customer2);
        return list;
    }
    

}
