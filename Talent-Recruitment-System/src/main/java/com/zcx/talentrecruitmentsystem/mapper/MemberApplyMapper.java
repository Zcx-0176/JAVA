package com.zcx.talentrecruitmentsystem.mapper;
/*
    申请会员mapper接口，功能为企业用户申请会员和个人用户申请会员
 */
import com.zcx.talentrecruitmentsystem.entity.MemberApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberApplyMapper {
    //企业用户或个人用户提交会员申请，即往申请表里新增记录
    int insertMemberApply(MemberApply memberApply);
}
