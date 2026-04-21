package com.zcx.talentrecruitmentsystem.entity;
/*
    岗位表实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {
    private Long id;
    private String jobName;
    private Long enterpriseId;
    private String targetEducation;
    private String skills;
    private String salary;
    private String workType;
    private String workLocation;
    private Integer jobStatus;
}
