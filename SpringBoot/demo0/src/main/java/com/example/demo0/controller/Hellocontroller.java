package com.example.demo0.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
