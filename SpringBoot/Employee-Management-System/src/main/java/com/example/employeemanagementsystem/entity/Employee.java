package com.example.employeemanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 员工实体类
 **/
@Entity   //作用：标记此类为JPA实体类，对应数据库中的一张表
          //效果：创建该实体类对应的数据库表，数据库表名称小写
@Data   //作用：自动生成getter/setter，toString、equals、hashCode 等方法方法
@NoArgsConstructor    //无参构造方法
@AllArgsConstructor   //全参构造方法
public class Employee {
    @Id   //标记此属性为数据库表的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //指定主键生成策略，IDENTITY表示使用数据库自增主键
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}
