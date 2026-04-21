package com.zcx.talentrecruitmentsystem.vo;
/*
    存储岗位表和已投递岗位表的联查信息，只给接口返回和前端展示用，没有数据库表对应
    存储的是企业id下看到哪些用户投递了
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRecordVO {
    private Long id;
    private Long userId;
    private Long jobId;
    private LocalDateTime deliveryTime;
    private Integer status;
    private String jobName;
    private String username;
}
