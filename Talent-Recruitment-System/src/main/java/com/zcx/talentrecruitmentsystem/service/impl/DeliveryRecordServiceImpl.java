package com.zcx.talentrecruitmentsystem.service.impl;
/*
    已投递岗位service实现类
 */

import com.zcx.talentrecruitmentsystem.mapper.DeliveryRecordMapper;
import com.zcx.talentrecruitmentsystem.service.DeliveryRecordService;
import com.zcx.talentrecruitmentsystem.vo.DeliveryRecordVO;
import com.zcx.talentrecruitmentsystem.vo.JobPostWithDeliveryVO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Resource
    private DeliveryRecordMapper deliveryRecordMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    //key前缀
    private static final String DELIVERY_LIST_KEY = "user:delivery:list:";
    //缓存过期时间(2min)
    private static final long CACHE_EXPIPE = 2;


    //用户查询投递记录列表  - 加入List缓存
    @Override
    public List<JobPostWithDeliveryVO> getJobPostByUserId(Long userId){
        String key = DELIVERY_LIST_KEY + userId;
        List<JobPostWithDeliveryVO> list = (List<JobPostWithDeliveryVO>) (List<?>)redisTemplate.opsForList().range(key,0,-1);

        if(list != null && !list.isEmpty()){
            return list;
        }

        list = deliveryRecordMapper.selectJobPostByUserId(userId);
        if(list != null && !list.isEmpty()){
            //把从数据库查询到的数据全部右插加入缓存
            redisTemplate.opsForList().rightPushAll(key,list.toArray());
            //设置缓存过期时间
            redisTemplate.expire(key,CACHE_EXPIPE, TimeUnit.MINUTES);
        }

        return list;
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
    //企业修改投递状态后，把之前的用户投递记录缓存删除，下次查询自动重新构建新缓存
    //但是我的底层没有根据投递表的主键id查询用户ID的方法
    //所以正能等待缓存自动过期
    @Override
    public int udtDeliveryStatus(Long id,Integer status,String userType){
        if(userType==null || !userType.equals("enterprise")){
            return 0;
        }
        int rows = deliveryRecordMapper.updateDeliveryStatus(id,status);

        return rows;
    }


    //用户投递
    //用户新增投递  - 同步更新list缓存
    @Override
    public int addDelivery(Long userId, Long jobId) {
        int rows = deliveryRecordMapper.insertDelivery(userId, jobId);

        if(rows>0){
            String key = DELIVERY_LIST_KEY + userId;
            //删除旧缓存
            redisTemplate.delete(key);

            //查询最新列表
            List<JobPostWithDeliveryVO> newlist = deliveryRecordMapper.selectJobPostByUserId(userId);
            //重新写入缓存
            redisTemplate.opsForList().rightPushAll(key,newlist.toArray());
            redisTemplate.expire(key,CACHE_EXPIPE,TimeUnit.MINUTES);
        }
        return rows;
    }
}
