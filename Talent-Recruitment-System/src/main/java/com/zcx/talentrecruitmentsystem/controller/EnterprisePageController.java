package com.zcx.talentrecruitmentsystem.controller;
/*
    企业用户各种功能页面跳转器
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("enterprise/page")
public class EnterprisePageController {
    //跳转企业首页
    @GetMapping("/index")
    public String toEnterpriseIndex() {
        return "enterprise/index";
    }

    //企业注册/新增企业页
    @GetMapping("/register")
    public String toRegister() {
        return "enterprise/register";
    }

    //企业信息修改页
    @GetMapping("/update")
    public String toEnterpriseInfo() {
        return "enterprise/update";
    }

    //企业岗位列表页
    @GetMapping("/job/list")
    public String toJobList() {
        return "enterprise/job/list";
    }

    //新增岗位页
    @GetMapping("/job/add")
    public String toJobAdd() {
        return "enterprise/job/add";
    }

    //修改岗位页
    @GetMapping("/job/update")
    public String toJobUpdate() {
        return "enterprise/job/update";
    }

    //企业收到的投递记录列表
    @GetMapping("/delivery/list")
    public String toDeliveryList() {
        return "enterprise/delivery/list";
    }

    //简历查看页面
    @GetMapping("/resume/check")
    public String toResumeCheck() {
        return "enterprise/resume/check";
    }

    //企业会员申请页
    @GetMapping("/member/apply")
    public String toMemberApply() {
        return "enterprise/member/apply";
    }

    //企业留言/消息中心
    @GetMapping("/message/list")
    public String toMessageList() {
        return "enterprise/message/list";
    }

}
