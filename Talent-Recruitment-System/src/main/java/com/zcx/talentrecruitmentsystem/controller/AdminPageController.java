package com.zcx.talentrecruitmentsystem.controller;
/*
    管理员各种功能的页面跳转控制器
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/page")
public class AdminPageController {

    //管理员首页
    @GetMapping("/index")
    public String index(){
        return "/admin/index";
    }

    //管理员列表界面
    @GetMapping("/list")
    public String list() {
        return "admin/list";
    }

    // 添加管理员页面
    @GetMapping("/add")
    public String add() {
        return "admin/add";
    }

    // 会员申请审核页面
    @GetMapping("/apply/list")
    public String applyList() {
        return "admin/apply";
    }



}
