package com.example.emsmybatis.repository;

import com.example.emsmybatis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/*
 * 操作用户表
 * Repository接口作用：标记此接口为数据访问层组件，Spring 会自动生成实现类
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>  {
    //继承了JpaRepository<User, Integer>，获得基础CRUD 方法（如 save、findAll、findById）
    //自定义方法findByUsername
    //Spring Data JPA 会根据方法名自动生成 SQL 查询 SELECT * FROM user WHERE username = ?。
    User findByUsername(String username);
}
