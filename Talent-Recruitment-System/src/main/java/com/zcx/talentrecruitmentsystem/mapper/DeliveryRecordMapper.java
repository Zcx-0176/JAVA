package com.zcx.talentrecruitmentsystem.mapper;
/*
    已投递的岗位mapper接口，
    主要方法为根据用户id查询该用户投递的所有岗位
    根据企业id查询哪些用户投递了该企业的岗位，并修改投递状态
 */

import com.zcx.talentrecruitmentsystem.vo.DeliveryRecordVO;
import com.zcx.talentrecruitmentsystem.vo.JobPostWithDeliveryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeliveryRecordMapper {
    //根据个人用户id查询,匹配id的所有岗位
    List<JobPostWithDeliveryVO> selectJobPostByUserId(Long userId);

    //根据企业id查询该企业收到的所有投递
    List<DeliveryRecordVO> selectDeliByEnterpriseId(Long enterpriseId);

    //修改投递状态   0=待查看，1=已查看，2=已录用，3=已拒绝
    int updateDeliveryStatus(
            @Param("id") Long id,
            @Param("status") Integer status
    );

    //用户投递功能
    int insertDelivery(@Param("userId") Long userId,
                       @Param("jobId") Long jobId);
}
