package com.zcx.talentrecruitmentsystem.service;

import com.zcx.talentrecruitmentsystem.entity.UserInfo;

import java.util.List;

/*
    个人用户基本信息service接口
 */
public interface UserInfoService {

    //每个方法名跟mapper接口差不多
    int addUser(UserInfo userInfo);

    int deleteUser(Long id);

    int updateUser(UserInfo userInfo);

    UserInfo getUserById(Long id);

    List<UserInfo> getAllUsers();

    //个人用户登录方法，即查账号
    UserInfo getByAccount(String account, String password);
}
