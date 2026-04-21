package com.zcx.talentrecruitmentsystem.service;

import com.zcx.talentrecruitmentsystem.vo.DeliveryRecordVO;
import com.zcx.talentrecruitmentsystem.vo.JobPostWithDeliveryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/*
    已投递的岗位service接口
 */
public interface DeliveryRecordService {

    //根据个人用户id查询,匹配id的所有岗位
    List<JobPostWithDeliveryVO> getJobPostByUserId(Long userId);

    //根据企业id查询该企业收到的所有投递
    List<DeliveryRecordVO> getDeliByEnterpriseId(Long enterpriseId);

    //修改投递状态   0=待查看，1=已查看，2=已录用，3=已拒绝
    int updateDeliveryStatus(Long id,Integer status);

    //只有企业用户才可以修改投递状态
    int udtDeliveryStatus(Long id,Integer status,String userType);

    //用户投递
    int addDelivery(Long userId, Long jobId);
}
