# 迷你局域网聊天室 (Mini LAN Chat Room)

基于 Java Socket 编程的局域网聊天室系统，支持多客户端并发通信、群聊、私聊、系统公告等功能。

## 📋 项目结构

### 环境要求
- JDK 1.8+
- IntelliJ IDEA 或 Eclipse

### 运行步骤

1. **启动服务器**
   运行 Chat.Server.ChatServer.main()
   - (服务器将监听 TCP 端口：8888，UDP 端口：9999)
2. 运行 Chat.Client.ChatClient.main()
   - 输入用户名后即可连接服务器
3. **多客户端测试**
    - 在 IDEA 中：点击 Run → Edit Configurations → Modify Options → Allow multiple instances
    - 启动多个客户端实例
## 💬 功能特性

### 客户端功能
- ✅ 用户登录（自定义或随机用户名）
- ✅ 公共聊天（所有人可见）
- ✅ 私聊功能（@用户名 消息）
- ✅ 查看在线用户列表（/list）
- ✅ 退出聊天室（/exit）
- ✅ 彩色消息显示（不同消息类型不同颜色）

### 服务器端功能
- ✅ 多客户端并发连接
- ✅ 系统公告广播
- ✅ 在线用户管理
- ✅ UDP 广播通知
- ✅ 控制台命令（/list 查看用户，/exit 关闭服务器）

## 🔧 核心技术与实现

### 1. TCP + UDP 双协议通信

#### TCP 通信（可靠传输）
- **用途**：客户端与服务器之间的聊天消息、控制命令
- **实现**：`Socket` / `ServerSocket` + `BufferedReader` / `PrintWriter`

#### UDP 通信（广播通知）
- **用途**：服务器向所有客户端广播系统消息、用户加入/退出通知
- **实现**：`DatagramSocket` + `DatagramPacket`

### 2. 多线程并发处理

#### 服务器端
- **主线程**：循环接受客户端连接 (`tcpsocket.accept()`)
- **ClientHandler 线程**：每个客户端一个独立线程处理通信
- **控制台线程**：处理管理员输入，发送系统公告

#### 客户端
- **主线程**：处理用户键盘输入
- **消息读取线程**：循环读取服务器消息并显示
- **UDP 接收线程**：监听 UDP 广播消息

### 3. 线程安全的集合

使用 `ConcurrentHashMap<String, ClientInfo>` 保存在线用户列表
- 支持高并发读写
- 避免 `ConcurrentModificationException`
## 📊 网络编程通用流程（可复用模式）


### 一、服务器端开发流程

#### 步骤 1: 定义通信协议

1. 确定端口号 
   - TCP_PORT = 8888 // 可靠数据传输 
   - UDP_PORT = 9999 // 广播通知
2. 定义消息格式 
   - "用户名：UDP 端口" // 客户端连接信息 
   - "@用户名 消息" // 私聊消息 
   - "/list" // 查询在线用户 
   - "/exit" // 退出聊天室

#### 步骤 2: 创建服务器套接字
1. 创建 TCP ServerSocket ServerSocket tcpSocket = new ServerSocket(TCP_PORT);
2. 创建 UDP DatagramSocket DatagramSocket udpSocket = new DatagramSocket(UDP_PORT);

#### 步骤 3: 启动辅助线程
- 控制台输入线程（管理员命令） startConsoleInputThread();

#### 步骤 4: 循环接受客户端连接
- >while(true) { Socket clientSocket = tcpSocket.accept(); // 阻塞等待连接
  // 为每个客户端创建独立处理器
  ClientHandler handler = new ClientHandler(clientSocket, ...);
  handler.start();  // 启动线程
  }

#### 步骤 5: 客户端处理器实现
- >public class ClientHandler extends Thread { public void run() { try { 
// 1. 创建输入输出流 in = new BufferedReader(...); out = new PrintWriter(..., true);
  // 2. 解析客户端连接信息
  String connectInfo = in.readLine();
  parseUserInfo(connectInfo);

        // 3. 添加到在线列表
        onlineClients.put(username, clientInfo);
        
        // 4. 广播用户加入消息
        broadcastMessage("JOIN:" + username + " 加入聊天室");
        
        // 5. 循环处理客户端消息
        while((msg = in.readLine()) != null) {
            if("/exit".equals(msg)) break;
            else if("/list".equals(msg)) sendUserList();
            else if(msg.startsWith("@")) sendPrivateMessage(msg);
            else broadcastMessage(msg);
        }} finally {cleanup();  // 清理资源}}}
#### 步骤 6: 实现核心业务方法

### 三、客户端开发流程

#### 步骤 1: 连接服务器
- >Socket tcpSocket = new Socket(SERVER_IP, TCP_PORT); PrintWriter tcpOut = new PrintWriter(tcpSocket.getOutputStream(), true); BufferedReader tcpIn = new BufferedReader( new InputStreamReader(tcpSocket.getInputStream()) );

#### 步骤 2: 发送连接信息
- >String connectInfo = username + ":" + udpPort; tcpOut.println(connectInfo);

#### 步骤 3: 启动 UDP 接收线程
- >udpReceiver = new UDPReceiver(udpPort); udpReceiver.start(); // 监听广播消息

#### 步骤 4: 启动消息读取线程
- >new Thread(() -> { while((msg = tcpIn.readLine()) != null) { // 根据消息类型显示不同颜色 if(msg.startsWith("PRIVATE:")) { /* 绿色 / } else if(msg.startsWith("SYSTEM:")) { / 黄色 / } else if(msg.startsWith("ERROR:")) { / 红色 / } else { / 默认 */ } } }).start();

#### 步骤 5: 处理用户输入
- >Scanner scanner = new Scanner(System.in); while(true) { String input = scanner.nextLine().trim();
  if("/exit".equals(input)) {
  tcpOut.println("/exit");
  break;
  } else if("/list".equals(input)) {
  tcpOut.println("/list");
  } else if(input.startsWith("@")) {
  tcpOut.println(input);  // 私聊
  } else {
  tcpOut.println(input);  // 公聊
  }
  }

#### 步骤 6: 资源清理
- >private void cleanup() { udpReceiver.interrupt(); tcpOut.close(); tcpIn.close(); tcpSocket.close(); }

### 四、关键数据结构设计

#### ClientInfo 类（保存客户端信息）
- >class ClientInfo { private String name; // 用户名（唯一标识） private InetAddress address; // IP 地址（UDP 广播需要） private int udpPort; // UDP 端口（广播需要） private PrintWriter out; // TCP 输出流（私聊需要） }

**设计要点**：
- 保存 `out` 输出流：避免每次发送都重新创建
- 保存完整网络信息：支持 UDP 广播和 TCP 私聊

---

## 🎯 网络编程最佳实践

### 1. 资源管理原则
- **谁创建，谁关闭**：Socket、Stream 等资源的创建者负责关闭
- **finally 块清理**：确保异常情况下也能释放资源
- **优雅关闭**：先发送退出消息，再关闭连接

### 2. 并发处理原则
- **一个客户端一个线程**：避免阻塞其他客户端
- **线程安全集合**：使用 `ConcurrentHashMap`、`synchronized` 锁
- **避免死锁**：减少锁的嵌套使用

### 3. 协议设计原则
- **简单明了**：使用文本协议便于调试（如`/list`、`@user msg`）
- **可扩展性**：预留特殊命令（`/exit`、`/list`）
- **错误处理**：定义错误消息格式（`ERROR:xxx`）

### 4. 粘包/拆包处理
- **文本协议优势**：使用 `\n` 作为消息边界
- **readLine() 方法**：自动处理粘包问题
- **二进制协议**：需要自定义消息头（长度字段）

---

## 🔍 常见问题排查

### 问题 1: 客户端无法连接服务器
- 检查服务器是否启动
- 检查防火墙是否开放端口
- 确认 IP 地址和端口号正确

### 问题 2: 消息发送失败
- 检查输出流是否刷新（`PrintWriter` 构造时设置 `true`）
- 检查输入流是否阻塞
- 查看控制台错误信息

### 问题 3: UDP 广播收不到
- 检查 UDP 端口是否正确
- 确认防火墙允许 UDP 通信
- 检查 `DatagramSocket` 是否关闭

### 问题 4: 多线程数据不一致
- 使用 `ConcurrentHashMap` 代替 `HashMap`
- 使用 `synchronized` 关键字保护共享资源
- 避免在迭代过程中修改集合

---

## 🛠️ 扩展功能建议

### 功能扩展
- [ ] 文件传输功能
- [ ] 聊天记录保存
- [ ] 用户头像和签名
- [ ] 群组聊天室
- [ ] 表情包支持

### 技术优化
- [ ] 使用 NIO 提升并发性能
- [ ] 数据库持久化用户信息
- [ ] WebSocket 支持 Web 客户端
- [ ] SSL/TLS 加密通信
- [ ] 负载均衡支持多服务器

---

## 📝 学习路线

### 前置知识
1. Java 基础语法
2. 面向对象编程
3. 多线程编程
4. 集合框架

### 进阶学习
1. Java IO/NIO
2. 网络编程基础（TCP/UDP）
3. 设计模式（单例、工厂、观察者）
4. 并发编程实战

### 相关项目推荐
- 多人在线五子棋
- 分布式文件系统
- 即时通讯软件
- 网络游戏服务器

---



## 🎓 总结

本项目完整展示了 Java 网络编程的核心技术点：

✅ **TCP/UDP 双协议栈应用**  
✅ **多线程并发处理**  
✅ **C/S 架构设计模式**  
✅ **线程安全集合使用**  
✅ **网络资源管理规范**






