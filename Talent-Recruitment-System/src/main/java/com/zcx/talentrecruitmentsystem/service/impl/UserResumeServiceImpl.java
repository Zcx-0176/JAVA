package com.zcx.talentrecruitmentsystem.service.impl;
/*
    简历service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.UserResume;
import com.zcx.talentrecruitmentsystem.mapper.UserResumeMapper;
import com.zcx.talentrecruitmentsystem.service.UserResumeService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserResumeServiceImpl implements UserResumeService {

    @Resource
    private UserResumeMapper userResumeMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    private static final String RESUME_HASH_KEY = "resume:user:";

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
        int rows = userResumeMapper.updateResume(userResume);
        if(rows>0){
            String key = RESUME_HASH_KEY + userResume.getUserId();
            Map<String,Object> map = new HashMap<>();
            map.put("gender",userResume.getGender());
            map.put("skills", userResume.getSkills());
            map.put("graduateSchool", userResume.getGraduateSchool());
            map.put("birthDate", userResume.getBirthDate().toString());
            redisTemplate.opsForHash().putAll(key,map);
        }
        return rows;
    }

    @Override
    public UserResume getResumeById(Long id){
        return userResumeMapper.selectResumeById(id);
    }

    @Override
    public UserResume getResumeByUserId(Long userId){
        //根据用户id查询简历
        //使用Hash
        String key = RESUME_HASH_KEY + userId;

        //先从Redis中获取整个简历
        Map<Object,Object> resumeMap = redisTemplate.opsForHash().entries(key);
        if(!resumeMap.isEmpty()){
            UserResume userResume = new UserResume();
            userResume.setId(((Integer) resumeMap.get("id")).longValue());
            userResume.setUserId(((Integer) resumeMap.get("userId")).longValue());
            userResume.setGender((String) resumeMap.get("gender"));
            userResume.setIdCard((String) resumeMap.get("idCard"));
            userResume.setBirthDate(LocalDate.parse((String) resumeMap.get("birthDate")));
            userResume.setNation((String) resumeMap.get("nation"));
            userResume.setPoliticalStatus((String) resumeMap.get("politicalStatus"));
            userResume.setMaritalStatus((String) resumeMap.get("maritalStatus"));
            userResume.setNativePlace((String) resumeMap.get("nativePlace"));
            userResume.setCurrentCity((String) resumeMap.get("currentCity"));
            userResume.setHighestEducation((String) resumeMap.get("highestEducation"));
            userResume.setGraduateSchool((String) resumeMap.get("graduateSchool"));
            userResume.setDepartment((String) resumeMap.get("department"));
            userResume.setMajor((String) resumeMap.get("major"));
            userResume.setEducationType((String) resumeMap.get("educationType"));
            userResume.setSchoolSystem((String) resumeMap.get("schoolSystem"));
            userResume.setForeignLevel((String) resumeMap.get("foreignLevel"));
            userResume.setJobCity((String) resumeMap.get("jobCity"));
            userResume.setExpectedPosition((String) resumeMap.get("expectedPosition"));
            userResume.setSkills((String) resumeMap.get("skills"));
            userResume.setProjectExperience((String) resumeMap.get("projectExperience"));
            userResume.setSelfEvalution((String) resumeMap.get("selfEvalution"));
            return userResume;
        }
        //如果resumeMap为空，表明缓存未命中，那就需要查询数据库
        UserResume userResume = userResumeMapper.selectResumeByUserId(userId);
        if(userResume!=null){
            //如果在数据库中查询到了，就需要把它加入到缓存中，用Hash
            Map<String, Object> map = new HashMap<>();
            map.put("id", userResume.getId());
            map.put("userId", userResume.getUserId());
            map.put("gender", userResume.getGender());
            map.put("idCard", userResume.getIdCard());
            map.put("birthDate", userResume.getBirthDate().toString());
            map.put("nation", userResume.getNation());
            map.put("politicalStatus", userResume.getPoliticalStatus());
            map.put("maritalStatus", userResume.getMaritalStatus());
            map.put("nativePlace", userResume.getNativePlace());
            map.put("currentCity", userResume.getCurrentCity());
            map.put("highestEducation", userResume.getHighestEducation());
            map.put("graduateSchool", userResume.getGraduateSchool());
            map.put("department", userResume.getDepartment());
            map.put("major", userResume.getMajor());
            map.put("educationType", userResume.getEducationType());
            map.put("schoolSystem", userResume.getSchoolSystem());
            map.put("foreignLevel", userResume.getForeignLevel());
            map.put("jobCity", userResume.getJobCity());
            map.put("expectedPosition", userResume.getExpectedPosition());
            map.put("skills", userResume.getSkills());
            map.put("projectExperience", userResume.getProjectExperience());
            map.put("selfEvalution", userResume.getSelfEvalution());

            redisTemplate.opsForHash().putAll(key,map);
        }
        return userResume;
    }

    @Override
    public List<UserResume> selectAllResumes(){
        return userResumeMapper.selectAllResumes();
    }
}
