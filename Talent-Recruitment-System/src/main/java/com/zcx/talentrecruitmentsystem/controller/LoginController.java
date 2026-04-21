package com.zcx.talentrecruitmentsystem.controller;
/*
    登录跳转控制器
 */
import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.AdminInfo;
import com.zcx.talentrecruitmentsystem.entity.EnterpriseUserInfo;
import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserInfoController userInfoController;

    @Autowired
    private EnterpriseUserInfoController enterpriseUserInfoController;

    @Autowired
    private AdminInfoController adminInfoController;

    //进入登录页面
    @GetMapping("/login")  //当有人访问这个路径时，页面给他返回login.html
    public String toLogin(){
        return "login";
    }

    //登录提交
    @PostMapping("/login")
    public String login(
            @RequestParam String account,
            @RequestParam String password,
            @RequestParam String role,
            Model model,
            HttpSession session
    ){
        Result result;

        switch(role){
            case "user":
                result = userInfoController.login(account,password);
                if(result.getCode()==200){
                    UserInfo userInfo = (UserInfo) result.getData();
                    session.setAttribute("loginUser",userInfo);
                    return "redirect:/user/page/index";
                }
                break;
            case "enterprise":
                result = enterpriseUserInfoController.login(account, password);
                if(result.getCode()==200){
                    EnterpriseUserInfo enterpriseUserInfo = (EnterpriseUserInfo) result.getData();
                    session.setAttribute("loginEnterprise",enterpriseUserInfo);
                    return "redirect:/enterprise/page/index";
                }
                break;
            case "admin":
                result = adminInfoController.login(account, password);
                if(result.getCode()==200){
                    AdminInfo adminInfo = (AdminInfo) result.getData();
                    session.setAttribute("loginAdmin",adminInfo);
                    return "redirect:/admin/page/index";
                }
                break;
        }
        //登录失败
        model.addAttribute("msg","账号或密码错误，请重试！");
        return "login";
    }

    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
