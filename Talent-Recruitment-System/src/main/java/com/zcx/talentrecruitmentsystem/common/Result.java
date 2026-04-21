package com.zcx.talentrecruitmentsystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;   // 状态码：成功=200  失败=500
    private String msg;  // 提示语："登录成功"、"账号不存在"
    private Object data;  // 真实数据：用户对象、列表、null

    //成功 + 带消息 + 带数据
    public static Result success(String msg,Object data){
        return new Result(200,msg,data);
    }

    // 成功 + 只带消息（无数据）
    public static Result success(String msg){
        return new Result(200,msg,null);
    }

    // 失败 + 只带消息
    public static Result error(String msg) {
        return new Result(500, msg, null);
    }

}
