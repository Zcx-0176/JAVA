package com.zcx.talentrecruitmentsystem.service.impl;
/*
    留言service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.MessageBoard;
import com.zcx.talentrecruitmentsystem.mapper.MessageBoardMapper;
import com.zcx.talentrecruitmentsystem.service.MessageBoardService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {

    @Resource
    private MessageBoardMapper messageBoardMapper;

    @Override
    public int addMessage(MessageBoard messageBoard){
        return messageBoardMapper.insertMessage(messageBoard);
    }

    @Override
    public List<MessageBoard> getMessagesByUsername(String username){
        return messageBoardMapper.selectMessagesByUsername(username);
    }

    @Override
    public int replyMessage(Long id,String reply){
        return messageBoardMapper.replyMessage(id,reply);
    }

    @Override
    public int deleteMessageById(Long id){
        return messageBoardMapper.deleteMessageById(id);
    }
}
