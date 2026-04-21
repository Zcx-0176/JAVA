package com.zcx.talentrecruitmentsystem.controller;
/*
    留言控制类
 */

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.MessageBoard;
import com.zcx.talentrecruitmentsystem.service.MessageBoardService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageBoardController {

    @Resource
    private MessageBoardService messageBoardService;

    //发送留言：所有人通用
    @PostMapping("/add")
    public Result addMessage(@RequestBody MessageBoard messageBoard) {
        int rows = messageBoardService.addMessage(messageBoard);
        return rows > 0 ? Result.success("留言发送成功") : Result.error("发送失败");
    }

    //查询发送给当前用户名的所有留言
    @GetMapping("/getByUsername")
    public Result getMessagesByUsername(String username){
        List<MessageBoard> list = messageBoardService.getMessagesByUsername(username);
        if(!list.isEmpty()){
            return Result.success("查询给当前用户的所有留言成功",list);
        }
        return Result.error("留言列表为空");
    }

    //回复留言
    @PostMapping("/reply")
    public Result replyMessage(Long id,String reply){
        int rows = messageBoardService.replyMessage(id,reply);
        return rows>0 ? Result.success("回复成功") : Result.error("回复失败");
    }

    //删除留言
    @GetMapping("/delete")
    public Result deleteMessageById(Long id) {
        int rows = messageBoardService.deleteMessageById(id);
        return rows > 0 ? Result.success("删除成功") : Result.error("删除失败");
    }

}
