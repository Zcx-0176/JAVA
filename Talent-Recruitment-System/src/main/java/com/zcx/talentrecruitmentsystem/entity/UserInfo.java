package com.zcx.talentrecruitmentsystem.entity;
/*
    个人用户基本信息实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String account;
    private String username;
    private String email;
    private String password;
    private Integer isVip;
}
