package com.zcx.talentrecruitmentsystem.service;

import com.zcx.talentrecruitmentsystem.entity.EnterpriseUserInfo;

import java.util.List;

/*
    企业基本信息service接口
 */
public interface EnterpriseUserInfoService {

    int addEnterprise(EnterpriseUserInfo enterpriseUserInfo);

    int deleteEnterprise(Long id);

    int updateEnterprise(EnterpriseUserInfo enterpriseUserInfo);

    EnterpriseUserInfo getEnterpriseById(Long id);

    List<EnterpriseUserInfo> getAllEnterprise();

    //登录操作，就是查账号
    EnterpriseUserInfo getByAccount(String account,String password);
}
