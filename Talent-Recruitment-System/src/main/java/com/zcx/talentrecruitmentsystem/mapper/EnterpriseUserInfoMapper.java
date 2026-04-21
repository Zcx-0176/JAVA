package com.zcx.talentrecruitmentsystem.mapper;
/*
    企业基本信息mapper接口，主要就是基本的CRUD操作，但是修改操作无法修改iSVip属性
 */
import com.zcx.talentrecruitmentsystem.entity.EnterpriseUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnterpriseUserInfoMapper {
    //新增企业
    int insertEnterprise(EnterpriseUserInfo enterpriseUserInfo);

    //根据ID删除企业
    int deleteEnterprise(Long id);

    //修改企业信息
    int updateEnterprise(EnterpriseUserInfo enterpriseUserInfo);

    //根据ID查询企业
    EnterpriseUserInfo selectEnterpriseById(Long id);

    //查询全部企业
    List<EnterpriseUserInfo> selectAllEnterprise();

    //登录操作，就是查账号
    EnterpriseUserInfo selectByAccount(String account);
}
