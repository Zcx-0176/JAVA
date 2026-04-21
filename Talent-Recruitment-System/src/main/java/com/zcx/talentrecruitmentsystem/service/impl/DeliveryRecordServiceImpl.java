package com.zcx.talentrecruitmentsystem.service.impl;
/*
    已投递岗位service实现类
 */

import com.zcx.talentrecruitmentsystem.mapper.DeliveryRecordMapper;
import com.zcx.talentrecruitmentsystem.service.DeliveryRecordService;
import com.zcx.talentrecruitmentsystem.vo.DeliveryRecordVO;
import com.zcx.talentrecruitmentsystem.vo.JobPostWithDeliveryVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Resource
    private DeliveryRecordMapper deliveryRecordMapper;

    @Override
    public List<JobPostWithDeliveryVO> getJobPostByUserId(Long userId){
        return deliveryRecordMapper.selectJobPostByUserId(userId);
    }

    @Override
    public List<DeliveryRecordVO> getDeliByEnterpriseId(Long enterpriseId){
        return deliveryRecordMapper.selectDeliByEnterpriseId(enterpriseId);
    }
    //修改投递状态   0=待查看，1=已查看，2=已录用，3=已拒绝
    @Override
    public int updateDeliveryStatus(Long id,Integer status){
        return deliveryRecordMapper.updateDeliveryStatus(id,status);
    }

    //真正的业务逻辑
    //只有企业用户才可以修改投递状态
    @Override
    public int udtDeliveryStatus(Long id,Integer status,String userType){
        if(userType==null || !userType.equals("企业用户")){
            return 0;
        }
        return deliveryRecordMapper.updateDeliveryStatus(id,status);
    }

    //用户投递
    @Override
    public int addDelivery(Long userId, Long jobId) {
        return deliveryRecordMapper.insertDelivery(userId, jobId);
    }
}
