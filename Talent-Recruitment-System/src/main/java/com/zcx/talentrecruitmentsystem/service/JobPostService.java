package com.zcx.talentrecruitmentsystem.service;
/*
    岗位service接口
 */
import com.zcx.talentrecruitmentsystem.entity.JobPost;

import java.util.List;


public interface JobPostService {

    int addJobPost(JobPost jobPost);

    int deleteJobPost(Long id);

    int updateJobPost(JobPost jobPost);

    JobPost getJobPostById(Long id);

    //根据企业id查询该企业的所有岗位
    List<JobPost> getJobPostsByEnterpriseId(Long enterpriseId);

    //用户根据skills模糊查询匹配的岗位
    List<JobPost> getJobBySkills(String skills);

    //查询所有岗位
    List<JobPost> getAllJobPosts();

}
