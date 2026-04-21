package com.zcx.talentrecruitmentsystem.entity;
/*
    已投递岗位实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRecord {
    private Long id;
    private Long userId;
    private Long jobId;
    private LocalDateTime deliveryTime;
    private Integer status;
}
