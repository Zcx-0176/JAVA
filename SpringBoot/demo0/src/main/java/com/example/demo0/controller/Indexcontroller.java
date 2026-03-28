package com.example.demo0.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Indexcontroller {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("username", "张三");
        return "index";
    }
}
