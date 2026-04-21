package com.zcx.talentrecruitmentsystem.controller;
/*
    管理员基本信息控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.AdminInfo;
import com.zcx.talentrecruitmentsystem.entity.MemberApply;
import com.zcx.talentrecruitmentsystem.service.AdminInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminInfoController {

    @Resource
    private AdminInfoService adminInfoService;

    //添加管理员
    @PostMapping("/add")
    public Result addAdmin(@RequestBody AdminInfo adminInfo){
        int rows = adminInfoService.addAdmin(adminInfo);
        return rows>0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    //删除管理员
    @GetMapping("/delete")
    public Result deleteAdmin(Long id){
        int rows = adminInfoService.deleteAdmin(id);
        return rows>0 ? Result.success("删除成功") : Result.error("删除失败");

    }

    //修改管理员信息
    @PostMapping("/update")
    public Result updateAdmin(@RequestBody AdminInfo adminInfo){
        int rows = adminInfoService.updateAdmin(adminInfo);
        return rows>0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    //根据id查询管理员
    @GetMapping("/getById")
    public Result getAdminById(Long id){
        AdminInfo adminInfo  = adminInfoService.getAdminById(id);
        if(adminInfo!=null){
            return Result.success("根据id查询成功",adminInfo);
        }
        return Result.error("根据id查询失败");
    }

    //查询所有管理员
    @GetMapping("/list")
    public Result getAllAdmin(){
        List<AdminInfo> list  = adminInfoService.getAllAdmins();
        if(list!=null){
            return Result.success("查询成功",list);
        }
        return Result.error("查询失败");
    }

    //查询所有会员申请记录
    @GetMapping("/apply/list")
    public Result getAllApplies(){
        List<MemberApply> list = adminInfoService.getAllApplies();
        if(!list.isEmpty()){
            return Result.success("会员申请记录如下",list);
        }
        return Result.error("会员申请记录为空");
    }

    //单独修改申请状态
    @GetMapping("/apply/updateStatus")
    public Result updateApplyStatus(Long id, Integer status) {
        int rows = adminInfoService.updateApplyStatus(id, status);
        return rows>0 ? Result.success("修改申请状态成功") : Result.error("修改申请状态失败");
    }

    //单独修改企业VIP状态
    @GetMapping("/enterprise/updateVip")
    public Result updateEnterpriseVipStatus(String account,Integer isVip){
        int rows = adminInfoService.updateEnterpriseVipStatus(account,isVip);
        return rows>0 ? Result.success("VIP状态修改成功") : Result.error("修改失败");
    }

    //审核会员申请，通过则自动开通vip，调用对应service的那个已经集成好的方法  @RequestParam只是接收简单参数而已，不写也行
    @PostMapping("/apply/audit")
    public Result auditApplyStatus(
            @RequestParam Long id,
            @RequestParam Integer status,
            @RequestParam String account
    ){
        int rows = adminInfoService.auditApplyStatus(id,status,account);
        return rows>0 ? Result.success("申请成功") : Result.error("申请失败");
    }

    //管理员登录
    @PostMapping("/login")
    public Result login(String account,String password){
        AdminInfo adminInfo = adminInfoService.getByAccount(account,password);
        if(adminInfo!=null){
            return Result.success("管理员登录成功",adminInfo);
        }
        return Result.success("管理员登录失败");
    }

}
