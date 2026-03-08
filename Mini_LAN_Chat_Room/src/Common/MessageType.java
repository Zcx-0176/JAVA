package Common;
/**
 * 消息类型枚举类
 * 定义客户端和服务器之间通信的消息类型
 */
public enum MessageType {
    JOIN,   //用户加入
    EXIT,   //用户退出
    MESSAGE,   //普通聊天信息
    LIST,   //获取在线用户列表
    PRIVATE,   //私聊信息
    ERROR   //错误信息
}
