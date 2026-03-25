package com.example.demo_hello_world.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello1")
public class HelloController {
    @GetMapping("/hello2")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
