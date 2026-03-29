package com.example.emsmybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration   //作用：标记此类为配置类，Spring 会在启动时加载此类中的 Bean 定义。
@EnableWebSecurity  //作用：启用 Spring Security 的 Web 安全功能，自动应用默认的安全配置。
public class SecurityConfig {
    @Bean
    //将方法返回的对象注册为 Bean，由 Spring 容器管理。
    //SecurityFilterChain：定义 HTTP 请求的安全过滤规则。
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                //授权请求配置
                .authorizeHttpRequests(auth ->auth
                        //登录页允许所有人访问
                        .requestMatchers("/login").permitAll()
                        //其他请求都需要登录后才能访问
                        .anyRequest().authenticated()
                )
                //表单登录配置
                .formLogin(form -> form
                        .loginPage("/login")  //自定义登录页面路径
                        .defaultSuccessUrl("/",true) //登录成功后跳转到首页
                        .permitAll()  //允许所有人访问登录页
                )
                .logout(LogoutConfigurer::permitAll);  //允许所有人登出
        return http.build();
    }

    // 密码编码器（开发环境用 NoOpPasswordEncoder，生产环境必须用 BCryptPasswordEncoder）
    @Bean
    //PasswordEncoder：定义密码加密 / 验证方式，NoOpPasswordEncoder 为明文密码（仅开发用）。
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
