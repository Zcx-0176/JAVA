package com.zcx.talentrecruitmentsystem.mapper;
/*
    用户简历mapper
    根据毕业学校/用户id查询简历(企业查询人才，搜索简历)
    普通的简历CRUD
 */
import com.zcx.talentrecruitmentsystem.entity.UserResume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserResumeMapper {
    //企业根据毕业学校/用户id查询简历
    List<UserResume> selectResumeBySchoolOrUserId(
            @Param("graduateSchool") String graduateSchool,
            @Param("userId") Long userId
    );

    //新增简历
    int insertResume(UserResume userResume);

    //根据ID删除简历
    int deleteResumeById(Long id);

    //修改简历
    int updateResume(UserResume userResume);

    //根据id查询简历
    UserResume selectResumeById(Long id);

    //根据用户id查询简历
    UserResume selectResumeByUserId(Long userId);

    //查询所有简历
    List<UserResume> selectAllResumes();
}
