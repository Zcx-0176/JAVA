package com.zcx.talentrecruitmentsystem.service;

import com.zcx.talentrecruitmentsystem.entity.MessageBoard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
    留言service接口
 */
public interface MessageBoardService {
    //发送留言：所有人通用
    int addMessage(MessageBoard messageBoard);

    //查询发送给当前用户名的所有留言
    List<MessageBoard> getMessagesByUsername(String username);

    //回复留言
    int replyMessage(Long id,String reply);

    //删除留言
    int deleteMessageById(Long id);
}
