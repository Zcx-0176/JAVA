package com.zcx.talentrecruitmentsystem.service.impl;
/*
    申请会员service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.MemberApply;
import com.zcx.talentrecruitmentsystem.mapper.MemberApplyMapper;
import com.zcx.talentrecruitmentsystem.service.MemberApplyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberApplyServiceImpl implements MemberApplyService {

    @Resource
    private MemberApplyMapper memberApplyMapper;

    @Override
    public int addMemberApply(MemberApply memberApply){
        return memberApplyMapper.insertMemberApply(memberApply);
    }
}
