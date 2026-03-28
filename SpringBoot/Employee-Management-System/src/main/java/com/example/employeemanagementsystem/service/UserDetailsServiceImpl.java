package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.User;
import com.example.employeemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service  //作用：标记此类为业务逻辑层组件，Spring会将其纳入 IoC 容器管理。
          //实现UserDetailsService接口：Spring Security 用于加载用户信息的核心接口。
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    //重写Spring Security 的用户加载方法，从数据库查询用户并封装为 UserDetails
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        //从数据库查用户，调用 Repository 层查询用户。
        User user = userRepository.findByUsername(username);

        if(user == null){ //用户不存在时抛出异常，由 Security 处理为登录失败。
            throw new UsernameNotFoundException("用户不存在");
        }
        //构建 Spring Security 所需的 UserDetails 对象，包含用户名、密码和角色。
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
