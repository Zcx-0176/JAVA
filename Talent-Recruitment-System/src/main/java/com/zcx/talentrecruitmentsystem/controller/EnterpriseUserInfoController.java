package com.zcx.talentrecruitmentsystem.controller;
/*
    企业用户基本信息控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.EnterpriseUserInfo;
import com.zcx.talentrecruitmentsystem.service.EnterpriseUserInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseUserInfoController {

    @Resource
    private EnterpriseUserInfoService enterpriseUserInfoService;

    //新增企业用户
    @PostMapping("/add")
    public Result addEnterprise(@RequestBody EnterpriseUserInfo enterpriseUserInfo){
        int rows = enterpriseUserInfoService.addEnterprise(enterpriseUserInfo);
        return rows>0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    //删除企业用户
    @GetMapping("/delete")
    public Result deleteEnterprise(Long id){
        int rows = enterpriseUserInfoService.deleteEnterprise(id);
        return rows>0 ? Result.success("删除成功") : Result.error("删除失败");
    }

    //修改企业信息
    @PostMapping("/update")
    public Result updateEnterprise(@RequestBody EnterpriseUserInfo enterpriseUserInfo){
        int rows = enterpriseUserInfoService.updateEnterprise(enterpriseUserInfo);
        return rows>0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    //根据id查询
    @GetMapping("/getById")
    public Result getEnterpriseById(Long id){
        EnterpriseUserInfo enterpriseUserInfo = enterpriseUserInfoService.getEnterpriseById(id);
        if(enterpriseUserInfo!=null){
            return Result.success("根据id查询成功",enterpriseUserInfo);
        }
        return Result.error("根据id查询失败");
    }

    //查询全部
    @GetMapping("/list")
    public Result getAllEnterprise(){
        List<EnterpriseUserInfo> list = enterpriseUserInfoService.getAllEnterprise();
        if(!list.isEmpty()){
            return Result.success("查询全部企业成功",list);
        }
        return Result.error("列表为空");
    }

    //登录操作
    @PostMapping("/login")
    public Result login(String account,String password){
        EnterpriseUserInfo enterpriseUserInfo = enterpriseUserInfoService.getByAccount(account,password);
        if(enterpriseUserInfo!=null){
            return Result.success("登录成功",enterpriseUserInfo);
        }
        return Result.error("登录失败");
    }
}
