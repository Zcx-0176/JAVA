package com.zcx.talentrecruitmentsystem.service.impl;
/*
    管理员service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.AdminInfo;
import com.zcx.talentrecruitmentsystem.entity.MemberApply;
import com.zcx.talentrecruitmentsystem.mapper.AdminInfoMapper;
import com.zcx.talentrecruitmentsystem.service.AdminInfoService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public int addAdmin(AdminInfo adminInfo){
        return adminInfoMapper.insertAdmin(adminInfo);
    }

    @Override
    public int deleteAdmin(Long id){
        return adminInfoMapper.deleteAdminById(id);
    }

    @Override
    public int updateAdmin(AdminInfo adminInfo){
        return adminInfoMapper.updateAdmin(adminInfo);
    }

    @Override
    public AdminInfo getAdminById(Long id){
        return adminInfoMapper.selectAdminById(id);
    }

    @Override
    public List<AdminInfo> getAllAdmins(){
        return adminInfoMapper.selectAllAdmins();
    }

    @Override
    public List<MemberApply> getAllApplies(){
        return adminInfoMapper.selectAllApplies();
    }

    @Override
    public int updateApplyStatus(Long id,Integer status){
        return adminInfoMapper.updateApplyStatus(id,status);
    }

    @Override
    public int updateEnterpriseVipStatus(String account,Integer isVip){
        return adminInfoMapper.updateEnterpriseVipStatus(account,isVip);
    }

    //真正的业务逻辑
    //修改申请状态。只有status为1时(申请允许)，才接着修改isVip属性
    @Override
    @Transactional
    public int auditApplyStatus(Long id,Integer status,String account){
        //先修改申请状态
        int updateApply = adminInfoMapper.updateApplyStatus(id,status);
        int updateVip = 0;
        //只有status为1才开通VIP
        if(status==1){
            // 先尝试更新【个人用户VIP】
            updateVip = adminInfoMapper.updateUserVipStatus(account, 1);

            // 如果个人更新失败 → 再尝试更新【企业VIP】
            if (updateVip == 0) {
                updateVip = adminInfoMapper.updateEnterpriseVipStatus(account, 1);
            }
        }
        // 两个都成功才返回成功
        if(status == 1){
            return (updateApply > 0 && updateVip > 0) ? 1 : 0;
        } else {
            return updateApply > 0 ? 1 : 0;
        }
    }


    //登录操作，即查账号
    @Override
    public AdminInfo getByAccount(String account,String password){
        AdminInfo adminInfo = adminInfoMapper.selectByAccount(account);

        if(adminInfo==null){
            return null;
        }
        if(!adminInfo.getPassword().equals(password)){
            return null;
        }
        return adminInfo;
    }

}
