package com.example.emsmybatis.entity;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工实体类
 **/
//效果：创建该实体类对应的数据库表，数据库表名称小写
@Data   //作用：自动生成getter/setter，toString、equals、hashCode 等方法方法
@NoArgsConstructor
@AllArgsConstructor   //全参构造方法
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private Integer dept_id;
    private Department department;
}
