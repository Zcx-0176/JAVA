package com.zcx.talentrecruitmentsystem.controller;
/*
    会员申请控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.MemberApply;
import com.zcx.talentrecruitmentsystem.service.MemberApplyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberApply")
public class MemberApplyController {

    @Resource
    private MemberApplyService memberApplyService;

    //企业用户或个人用户提交会员申请，即往申请表里新增记录
    @PostMapping("/add")
    public Result addMemberApply(@RequestBody MemberApply memberApply){
        int rows = memberApplyService.addMemberApply(memberApply);
        return rows>0 ? Result.success("会员申请提交成功") : Result.error("会员申请提交失败");
    }
}
