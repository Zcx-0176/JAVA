package com.zcx.talentrecruitmentsystem.entity;
/*
    管理员基本信息实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfo {
    private Long id;
    private String account;
    private String adminName;
    private String gender;
    private Integer age;
    private String email;
    private String password;
}
