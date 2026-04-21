package com.zcx.talentrecruitmentsystem.mapper;
/*
    个人用户信息mapper
    简单的CRUD
 */
import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    //新增用户
    int insertUser(UserInfo userInfo);

    //删除用户
    int deleteUserById(Long id);

    //修改用户信息
    int updateUser(UserInfo userInfo);

    //根据Id查询用户
    UserInfo selectUserById(Long id);

    //查询所有用户
    List<UserInfo> selectAllUsers();

    //个人用户登录方法，即查账号
    UserInfo selectByAccount(String account);
}
