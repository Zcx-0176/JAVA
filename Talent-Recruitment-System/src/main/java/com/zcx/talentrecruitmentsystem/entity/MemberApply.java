package com.zcx.talentrecruitmentsystem.entity;
/*
    会员注册表
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberApply {
    private Long id;
    private String account;
    private Integer identity;
    private LocalDateTime applyTime;
    private Integer status;
}
