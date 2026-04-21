package com.zcx.talentrecruitmentsystem.service;

import com.zcx.talentrecruitmentsystem.entity.UserResume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
    简历service接口
 */
public interface UserResumeService {
    //企业根据毕业学校/用户id查询简历
    List<UserResume> getResumeBySchoolOrUserId(String graduateSchool,Long userId);

    //新增简历
    int addResume(UserResume userResume);

    //根据ID删除简历
    int deleteResumeById(Long id);

    //修改简历
    int updateResume(UserResume userResume);

    //根据id查询简历
    UserResume getResumeById(Long id);

    //根据用户id查询简历
    UserResume getResumeByUserId(Long userId);

    //查询所有简历
    List<UserResume> selectAllResumes();
}
