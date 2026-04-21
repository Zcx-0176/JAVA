package com.zcx.talentrecruitmentsystem.entity;
/*
    简历实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResume {
    private Long id;
    private Long userId;
    private String gender;
    private String idCard;
    private LocalDate birthDate;
    private String nation;
    private String politicalStatus;
    private String maritalStatus;
    private String nativePlace;
    private String currentCity;
    private String highestEducation;
    private String graduateSchool;
    private String department;
    private String major;
    private String educationType;
    private String schoolSystem;
    private String foreignLevel;
    private String jobCity;
    private String expectedPosition;
    private String skills;
    private String projectExperience;
    private String selfEvalution;
}
