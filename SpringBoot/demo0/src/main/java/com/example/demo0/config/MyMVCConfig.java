package com.example.demo0.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 告诉 Spring：这是配置类
public class MyMVCConfig implements WebMvcConfigurer {

    // 你想加什么功能，就重写什么方法
    // 例1：加跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // ... 跨域配置
    }

    // 例2：加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // ... 拦截器配置
    }
}