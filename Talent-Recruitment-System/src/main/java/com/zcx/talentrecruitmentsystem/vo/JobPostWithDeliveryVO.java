package com.zcx.talentrecruitmentsystem.vo;
/*
    存储岗位表和已投递岗位表的联查信息，只给接口返回和前端展示用，没有数据库表对应
    在用户id下看到当前用户投递了哪些公司
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostWithDeliveryVO {
    private Long id;
    private String jobName;
    private Long enterpriseId;
    private String targetEducation;
    private String skills;
    private String salary;
    private String workType;
    private String workLocation;
    private Integer jobStatus;

    private LocalDateTime deliveryTime;
    private Integer status;
}
