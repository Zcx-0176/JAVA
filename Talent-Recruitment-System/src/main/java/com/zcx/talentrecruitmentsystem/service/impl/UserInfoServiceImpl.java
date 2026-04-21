package com.zcx.talentrecruitmentsystem.service.impl;
/*
    用个人用户基本信息Service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import com.zcx.talentrecruitmentsystem.mapper.UserInfoMapper;
import com.zcx.talentrecruitmentsystem.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //告诉Spring：这个类是业务层，会自动创建这个类的对象，放在Spring容器里，想用就用
public class UserInfoServiceImpl implements UserInfoService {

    @Resource   //告诉Spring 把下面的接口拿过来用，因为mapper注解使得MyBatis自动生成了实现类，Spring把它放进了容器，这个注解直接从容器内拿出来用
    private UserInfoMapper userInfoMapper;

    @Override   //重写接口
    public int addUser(UserInfo userInfo){
        return userInfoMapper.insertUser(userInfo);   //直接return就行是因为当前没有业务逻辑直接就是数据库操作
    }

    @Override
    public int deleteUser(Long id){
        return userInfoMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(UserInfo userInfo){
        return userInfoMapper.updateUser(userInfo);
    }

    @Override
    public UserInfo getUserById(Long id){
        return userInfoMapper.selectUserById(id);
    }

    @Override
    public List<UserInfo> getAllUsers(){
        return userInfoMapper.selectAllUsers();
    }

    //个人用户登录方法，即查账号
    @Override
    public UserInfo getByAccount(String account, String password){
        UserInfo user = userInfoMapper.selectByAccount(account);
        if(user==null){
            return null;
        }
        if(!user.getPassword().equals(password)){
            return null;
        }
        return user;
    }

}
