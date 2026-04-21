package com.zcx.talentrecruitmentsystem.entity;
/*
    留言实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBoard {
    private Long id;
    private String username;
    private String userType;
    private String content;
    private LocalDateTime createTime;
    private String reply;
}
