package com.zcx.talentrecruitmentsystem.controller;
/*
    个人用户基本信息控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import com.zcx.talentrecruitmentsystem.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    //新增用户  @RequestBody写在参数前面，是自动接收前端传入的JSON数据并转换为java对象
    @PostMapping("/add")
    public Result addUser(@RequestBody UserInfo userInfo){
        int rows = userInfoService.addUser(userInfo);
        return rows>0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    //删除用户  因为只需要传一个简单的id，不需要传复杂JSON，适合用该注解@GetMapping
    @GetMapping("/delete")
    public Result deleteUser(Long id){
        int rows = userInfoService.deleteUser(id);
        return rows>0 ? Result.success("删除成功") : Result.error("删除失败");
    }

    //修改用户信息
    @PostMapping("/update")
    public Result updateUser(@RequestBody UserInfo userInfo){
        int rows = userInfoService.updateUser(userInfo);
        return rows>0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    //根据ID查询用户
    @GetMapping("/getById")
    public Result getUserById(Long id){
        UserInfo userInfo = userInfoService.getUserById(id);
        if(userInfo!=null){
            return Result.success("按ID查找成功",userInfo);
        }
        return Result.error("按ID查找失败");
    }

    //查询所有用户
    @GetMapping("/list")
    public Result getAllUsers(){
        List<UserInfo> list = userInfoService.getAllUsers();
        if(!list.isEmpty()){
            return Result.success("查询所有用户成功",list);
        }
        return Result.error("所有用户为空");
    }

    //用户登录
    @PostMapping("/login")
    public Result login(String account,String password){
        UserInfo userInfo = userInfoService.getByAccount(account,password);
        if(userInfo!=null){
            return Result.success("登录成功",userInfo);
        }
        return Result.error("登录失败");
    }

}
