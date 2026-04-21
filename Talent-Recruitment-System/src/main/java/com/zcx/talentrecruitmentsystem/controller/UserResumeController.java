package com.zcx.talentrecruitmentsystem.controller;
/*
    简历控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.UserResume;
import com.zcx.talentrecruitmentsystem.service.UserResumeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class UserResumeController {

    @Resource
    private UserResumeService userResumeService;

    //企业根据毕业学校/用户id查询简历
    @GetMapping("/getByCondition")
    public Result getResumeBySchoolOrUserId(String graduateSchool,Long userId){
        List<UserResume> list = userResumeService.getResumeBySchoolOrUserId(graduateSchool,userId);
        if(!list.isEmpty()){
            return Result.success("查询成功",list);
        }
        return Result.error("列表为空");
    }

    //新增简历
    @PostMapping("/add")
    public Result addResume(@RequestBody UserResume userResume) {
        int rows = userResumeService.addResume(userResume);
        return rows > 0 ? Result.success("简历添加成功") : Result.error("添加失败");
    }

    //根据ID删除简历
    @GetMapping("/delete")
    public Result deleteResumeById(Long id) {
        int rows = userResumeService.deleteResumeById(id);
        return rows > 0 ? Result.success("删除成功") : Result.error("删除失败");
    }

    //修改简历
    @PostMapping("/update")
    public Result updateResume(@RequestBody UserResume userResume) {
        int rows = userResumeService.updateResume(userResume);
        return rows > 0 ? Result.success("简历修改成功") : Result.error("修改失败");
    }

    //根据id查询简历
    @GetMapping("/getById")
    public Result getResumeById(Long id) {
        UserResume resume = userResumeService.getResumeById(id);
        if(resume!=null){
            return Result.success("查询成功",resume);
        }
        return Result.error("查询失败");
    }

    //根据用户id查询简历
    @GetMapping("/getByUserId")
    public Result getResumeByUserId(Long userId) {
        UserResume resume = userResumeService.getResumeByUserId(userId);
        if(resume!=null){
            return Result.success("查询成功",resume);
        }
        return Result.error("查询失败");
    }

    //查询所有简历
    @GetMapping("/list")
    public Result selectAllResumes() {
        List<UserResume> list = userResumeService.selectAllResumes();
        if(!list.isEmpty()){
            return Result.success("查询成功",list);
        }
        return Result.error("列表为空");
    }
}
