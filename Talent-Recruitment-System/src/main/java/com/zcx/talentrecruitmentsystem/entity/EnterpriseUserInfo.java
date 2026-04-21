package com.zcx.talentrecruitmentsystem.entity;
/*
    企业用户基本信息实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseUserInfo {
    private Long id;
    private String account;
    private String enterpriseName;
    private String address;
    private String introduction;
    private String mainBusiness;
    private String workTime;
    private String password;
    private Integer isVip;
}
