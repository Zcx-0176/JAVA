package com.zcx.talentrecruitmentsystem.controller;
/*
    已投递岗位控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.service.DeliveryRecordService;
import com.zcx.talentrecruitmentsystem.vo.DeliveryRecordVO;
import com.zcx.talentrecruitmentsystem.vo.JobPostWithDeliveryVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryRecordController {

    @Resource
    private DeliveryRecordService deliveryRecordService;

    //根据个人用户id查询，我投递了哪些岗位
    @GetMapping("/getByUserId")
    public Result getJobPostByUserId(Long id){
        List<JobPostWithDeliveryVO> list = deliveryRecordService.getJobPostByUserId(id);
        if(!list.isEmpty()){
            return Result.success("按个人用户id查询成功",list);
        }
        return Result.error("列表为空");
    }

    //根据企业id查询该企业收到的所有投递
    @GetMapping("/getByEnterpriseId")
    public Result getDeliByEnterpriseId(Long enterpriseId){
        List<DeliveryRecordVO> list = deliveryRecordService.getDeliByEnterpriseId(enterpriseId);
        if(!list.isEmpty()){
            return Result.success("按企业用户id查询成功",list);
        }
        return Result.error("列表为空");
    }

    //企业修改投递状态   0=待查看，1=已查看，2=已录用，3=已拒绝
    @PostMapping("/audit")
    public Result udtDeliveryStatus(
            @RequestParam Long id,
            @RequestParam Integer status,
            @RequestParam String userType
    ){
        int rows = deliveryRecordService.udtDeliveryStatus(id,status,userType);
        return rows>0 ? Result.success("修改投递状态成功") : Result.error("修改投递状态失败");
    }

    //用户投递
    // 投递岗位
    @PostMapping("/add")
    public Result addDelivery(Long userId, Long jobId) {
        int rows = deliveryRecordService.addDelivery(userId, jobId);
        return rows > 0 ? Result.success("投递成功") : Result.error("投递失败");
    }
}
