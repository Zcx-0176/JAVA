package com.zcx.talentrecruitmentsystem.service.impl;
/*
    岗位service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.JobPost;
import com.zcx.talentrecruitmentsystem.mapper.JobPostMapper;
import com.zcx.talentrecruitmentsystem.service.JobPostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Resource
    private JobPostMapper jobPostMapper;

    @Override
    public int addJobPost(JobPost jobPost){
        return jobPostMapper.insertJobPost(jobPost);
    }

    @Override
    public int deleteJobPost(Long id){
        return jobPostMapper.deleteJobPost(id);
    }

    @Override
    public int updateJobPost(JobPost jobPost){
        return jobPostMapper.updateJobPost(jobPost);
    }

    @Override
    public JobPost getJobPostById(Long id){
        return jobPostMapper.selectJobPostById(id);
    }

    @Override
    public List<JobPost> getJobPostsByEnterpriseId(Long enterpriseId){
        return jobPostMapper.selectJobPostsByEnterpriseId(enterpriseId);
    }

    @Override
    public List<JobPost> getJobBySkills(String skills){
        return jobPostMapper.selectJobBySkills(skills);
    }

    @Override
    public List<JobPost> getAllJobPosts() {
        return jobPostMapper.selectAllJobPosts();
    }

}
