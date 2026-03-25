package com.example.hello_world.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 有了这个接口，在浏览器上输入http://localhost:8080/hello 就会返回Hello World!
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
