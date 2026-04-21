package com.zcx.talentrecruitmentsystem.mapper;
/*
    管理员，企业，个人用户三方互通留言mapper
    基本就是根据某个参数CRUD
 */
import com.zcx.talentrecruitmentsystem.entity.MessageBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageBoardMapper {
    //发送留言：所有人通用
    int insertMessage(MessageBoard messageBoard);

    //查询发送给当前用户名的所有留言
    List<MessageBoard> selectMessagesByUsername(
            @Param("username") String username
    );

    //回复留言
    int replyMessage(
            @Param("id") Long id,
            @Param("reply") String reply
    );

    //删除留言
    int deleteMessageById(Long id);
}
