package com.zcx.talentrecruitmentsystem.service.impl;
/*
    企业基本信息service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.EnterpriseUserInfo;
import com.zcx.talentrecruitmentsystem.mapper.EnterpriseUserInfoMapper;
import com.zcx.talentrecruitmentsystem.service.EnterpriseUserInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseUserInfoServiceImpl implements EnterpriseUserInfoService {
    @Resource
    private EnterpriseUserInfoMapper enterpriseUserInfoMapper;

    @Override
    public int addEnterprise(EnterpriseUserInfo enterpriseUserInfo){
        return enterpriseUserInfoMapper.insertEnterprise(enterpriseUserInfo);
    }

    @Override
    public int deleteEnterprise(Long id){
        return enterpriseUserInfoMapper.deleteEnterprise(id);
    }

    @Override
    public int updateEnterprise(EnterpriseUserInfo enterpriseUserInfo){
        return enterpriseUserInfoMapper.updateEnterprise(enterpriseUserInfo);
    }

    @Override
    public EnterpriseUserInfo getEnterpriseById(Long id){
        return enterpriseUserInfoMapper.selectEnterpriseById(id);
    }

    @Override
    public List<EnterpriseUserInfo> getAllEnterprise(){
        return enterpriseUserInfoMapper.selectAllEnterprise();
    }

    //登录操作，就是查账号
    @Override
    public EnterpriseUserInfo getByAccount(String account,String password){
        //先根据传入的账号，找这个对象
        EnterpriseUserInfo enterpriseUserInfo = enterpriseUserInfoMapper.selectByAccount(account);

        //如果对象为null或者对象的密码跟传入的密码不符则登录失败
        if(enterpriseUserInfo==null){
            return null;
        }
        if(!enterpriseUserInfo.getPassword().equals(password)){
            return null;
        }
        return enterpriseUserInfo;
    }
}
