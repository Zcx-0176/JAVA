package com.zcx.talentrecruitmentsystem.controller;
/*
    岗位控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.JobPost;
import com.zcx.talentrecruitmentsystem.service.JobPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobPostController {

    @Resource
    private JobPostService jobPostService;

    //新增岗位
    @PostMapping("/add")
    public Result addJobPost(@RequestBody JobPost jobPost){
        int rows = jobPostService.addJobPost(jobPost);
        return rows>0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    //删除岗位
    @GetMapping("/delete")
    public Result deleteJobPost(Long id){
        int rows = jobPostService.deleteJobPost(id);
        return rows>0 ? Result.success("删除成功") : Result.error("删除失败");
    }

    //修改岗位
    @PostMapping("/update")
    public Result updateJobPost(@RequestBody JobPost jobPost){
        int rows = jobPostService.updateJobPost(jobPost);
        return rows>0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    //根据id查询岗位
    @GetMapping("/getById")
    public Result getJobPostById(Long id){
        JobPost jobPost = jobPostService.getJobPostById(id);
        if(jobPost!=null){
            return Result.success("按id查询成功",jobPost);
        }
        return Result.error("按id查询失败");
    }

    //根据企业id查询该企业的所有岗位
    @GetMapping("/getByEnterpriseId")
    public Result getJobPostsByEnterpriseId(Long enterpriseId){
        List<JobPost> list = jobPostService.getJobPostsByEnterpriseId(enterpriseId);
        if(!list.isEmpty()){
            return Result.success("按企业id查询岗位成功",list);
        }
        return Result.error("列表为空");
    }

    //用户根据skills模糊查询匹配的岗位
    @GetMapping("/searchBySkills")
    public Result getJobBySkills(String skills){
        List<JobPost> list = jobPostService.getJobBySkills(skills);
        if(!list.isEmpty()){
            return Result.success("用户根据skills模糊查询岗位成功",list);
        }
        return Result.error("列表为空");
    }

    @GetMapping("/list")
    public Result listAllJobs() {
        List<JobPost> list = jobPostService.getAllJobPosts();
        if(!list.isEmpty()){
            return Result.success("用户查询岗位成功",list);
        }
        return Result.error("列表为空");
    }
}
