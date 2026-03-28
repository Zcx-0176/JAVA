package com.example.employeemanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //作用：标记此类为控制器，处理 HTTP 请求并返回视图页面（Thymeleaf 模板）
public class IndexController {
    @GetMapping("/")  //作用：处理 GET 请求，路径为 /
    public String index(){
        return "index";     //返回值 "index"：对应 templates/index.html 模板文件，Spring MVC 会自动渲染此页面。
    }
}
