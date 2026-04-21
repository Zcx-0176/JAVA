package com.zcx.talentrecruitmentsystem.service;
/*
    管理员service接口
 */
import com.zcx.talentrecruitmentsystem.entity.AdminInfo;
import com.zcx.talentrecruitmentsystem.entity.MemberApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminInfoService {

    int addAdmin(AdminInfo adminInfo);

    int deleteAdmin(Long id);

    int updateAdmin(AdminInfo adminInfo);

    AdminInfo getAdminById(Long id);

    List<AdminInfo> getAllAdmins();

    List<MemberApply> getAllApplies();

    int updateApplyStatus(
            @Param("id") Long id,
            @Param("status") Integer status
    );

    int updateEnterpriseVipStatus(
            @Param("account") String account,
            @Param("isVip") Integer isVip
    );

    //修改申请状态。只有status为1时(申请允许)，才接着修改isVip属性
    int auditApplyStatus(Long id,Integer status,String account);

    //登录操作，即查账号
    AdminInfo getByAccount(String account,String password);
}
