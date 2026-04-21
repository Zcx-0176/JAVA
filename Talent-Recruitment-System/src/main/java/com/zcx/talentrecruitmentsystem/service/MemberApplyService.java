package com.zcx.talentrecruitmentsystem.service;

import com.zcx.talentrecruitmentsystem.entity.MemberApply;

/*
    申请会员service接口
 */
public interface MemberApplyService {
    //企业用户或个人用户提交会员申请，即往申请表里新增记录
    int addMemberApply(MemberApply memberApply);
}
