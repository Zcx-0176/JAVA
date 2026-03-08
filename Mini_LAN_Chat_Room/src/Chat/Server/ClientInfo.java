package Chat.Server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;
import java.net.InetAddress;

/**
 * 服务器端，客户端信息类，用于保存客户端信息】
 * 为什么要保存这些信息：
 *    1.name ：是唯一标识符，用于查找和移除
 *    2.address ：UDP广播时需要目标IP
 *    3.udpPort ：UDP广播时需要目标端口
 *    4.out ：TCP输出流，TCP私聊时直接写入输出流
 *    为什么要保存out，因为有了这个输出流，就可以免去每一次发送消息都要重新创建输出流
 *    所以直接保存这个out，每次从服务端来消息，直接调用getOut()方法获取输出流，直接写入输出流
 *    然后直接打印消息，方便快捷
 *    即getOut().println(message);
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfo {
    private String name;   //用户名
    private InetAddress address;  //客户端IP地址
    private int udpPort;   //UDP端口号
    private PrintWriter out;   //TCP输出流
}
