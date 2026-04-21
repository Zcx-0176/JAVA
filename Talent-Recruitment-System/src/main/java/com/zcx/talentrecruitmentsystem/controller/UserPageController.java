package com.zcx.talentrecruitmentsystem.controller;
/*
    个人用户页面跳转控制器
 */

import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/page")
public class UserPageController {

    // 个人用户首页
    @GetMapping("/index")
    public String toUserIndex(HttpSession session, Model model) {
        // 👇 2. 从session中拿到登录用户
        UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");

        // 👇 3. 如果用户已登录，把userId存入Model，供前端使用
        if (loginUser != null) {
            model.addAttribute("userId", loginUser.getId());
        }

        return "user/index";
    }

    // 个人用户注册页
    @GetMapping("/register")
    public String toRegister() {
        return "user/register";
    }

    // 个人信息修改页
    @GetMapping("/update")
    public String toUserUpdate() {
        return "user/update";
    }

    // 查看我的简历页
    @GetMapping("/resume/my")
    public String toMyResume() {
        return "user/resume/my";
    }

    // 添加简历页（简历为空时显示）
    @GetMapping("/resume/add")
    public String toResumeAdd() {
        return "user/resume/add";
    }

    // 修改简历页（简历存在时显示）
    @GetMapping("/resume/update")
    public String toResumeUpdate() {
        return "user/resume/update";
    }

    // 岗位列表（所有岗位）
    @GetMapping("/job/list")
    public String toJobList() {
        return "user/job/list";
    }

    // 根据技能搜索匹配的岗位页
    @GetMapping("/job/search")
    public String toJobSearch() {
        return "user/job/search";
    }

    // 查看我已投递的岗位列表
    @GetMapping("/delivery/my")
    public String toMyDelivery() {
        return "user/delivery/my";
    }

    // 个人会员申请页
    @GetMapping("/member/apply")
    public String toMemberApply() {
        return "user/member/apply";
    }

    // 个人留言中心
    @GetMapping("/message/list")
    public String toMessageList() {
        return "user/message/list";
    }


}
