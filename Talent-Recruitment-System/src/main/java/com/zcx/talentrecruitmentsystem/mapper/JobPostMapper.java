package com.zcx.talentrecruitmentsystem.mapper;
/*
    岗位mapper接口
    基本的CRUD操作
    根据企业id查询该企业的所有岗位
 */
import com.zcx.talentrecruitmentsystem.entity.JobPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobPostMapper {
    //新增岗位
    int insertJobPost(JobPost jobPost);

    //删除岗位
    int deleteJobPost(Long id);

    //修改岗位信息
    int updateJobPost(JobPost jobPost);

    //根据id查询岗位
    JobPost selectJobPostById(Long id);

    //根据企业id查询该企业的所有岗位
    List<JobPost> selectJobPostsByEnterpriseId(Long enterpriseId);

    //用户根据skills模糊查询匹配的岗位
    List<JobPost> selectJobBySkills(String skills);

    //查询所有岗位
    List<JobPost> selectAllJobPosts();

}
