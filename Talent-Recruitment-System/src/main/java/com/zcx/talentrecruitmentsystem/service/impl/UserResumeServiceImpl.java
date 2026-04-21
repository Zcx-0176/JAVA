package com.zcx.talentrecruitmentsystem.service.impl;
/*
    简历service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.UserResume;
import com.zcx.talentrecruitmentsystem.mapper.UserResumeMapper;
import com.zcx.talentrecruitmentsystem.service.UserResumeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResumeServiceImpl implements UserResumeService {

    @Resource
    private UserResumeMapper userResumeMapper;

    @Override
    public List<UserResume> getResumeBySchoolOrUserId(String graduateSchool, Long userId){
        return userResumeMapper.selectResumeBySchoolOrUserId(graduateSchool,userId);
    }

    @Override
    public int addResume(UserResume userResume){
        return userResumeMapper.insertResume(userResume);
    }

    @Override
    public int deleteResumeById(Long id){
        return userResumeMapper.deleteResumeById(id);
    }

    @Override
    public int updateResume(UserResume userResume){
        return userResumeMapper.updateResume(userResume);
    }

    @Override
    public UserResume getResumeById(Long id){
        return userResumeMapper.selectResumeById(id);
    }

    @Override
    public UserResume getResumeByUserId(Long userId){
        return userResumeMapper.selectResumeByUserId(userId);
    }

    @Override
    public List<UserResume> selectAllResumes(){
        return userResumeMapper.selectAllResumes();
    }
}
