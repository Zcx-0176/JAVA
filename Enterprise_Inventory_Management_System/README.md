# 企业级库存管理系统 (Enterprise Inventory Management System)

## 1. 项目目的
该项目主要目的是实践 Java 基础中的相关知识：
- **面向对象编程 (OOP)**：封装、继承、多态
- **集合框架**：ArrayList、HashMap、HashSet
- **常用 API**：String、File、IO 流等
- **异常处理**：自定义异常类
- **设计模式**：单例模式
- **文件操作**：IO 流读写数据

## 2. 项目架构

### 2.1 类设计

#### Product（商品类）
- **位置**：`src/entity/Product.java`
- **职责**：定义商品的基本属性和行为
- **属性**：
    - `id`：商品 ID（唯一标识）
    - `name`：商品名称
    - `category`：商品类别
    - `price`：商品价格
    - `quantity`：商品数量
- **方法**：
    - 构造方法（全参、无参）
    - Getter/Setter 方法（封装数据）
    - `calculateValue()`：计算商品总价值
    - `toString()`：重写，方便打印商品信息

#### InventoryException（自定义异常类）
- **位置**：`src/exception/InventoryException.java`
- **职责**：处理库存相关异常
- **继承**：`Exception` 类
- **特点**：提供有意义的异常信息，便于问题定位和用户提示

#### InventoryManager（库存管理类）
- **位置**：`src/manager/InventoryManager.java`
- **职责**：管理所有商品的增删改查操作
- **设计模式**：单例模式（确保系统只有一个实例）
- **数据结构**：
    - `HashMap<String, Product>`：存储商品，以商品 ID 为键
    - `ArrayList<String>`：记录操作日志
    - `HashSet<String>`：统计不重复的商品类别
- **核心功能**：
    - 添加商品
    - 删除商品
    - 修改商品信息
    - 查询商品（按 ID）
    - 显示所有商品
    - 记录操作日志

#### FileUtil（文件工具类）
- **位置**：`src/util/FileUtil.java`
- **职责**：负责所有文件 IO 操作
- **核心功能**：
    - `saveInventory()`：保存商品数据到文件（追加模式）
    - `loadInventory()`：从文件加载商品数据
- **文件路径**：`data/inventory.txt`（相对路径）

#### InventoryMain（主程序类）
- **位置**：`src/main/InventoryMain.java`
- **职责**：程序入口，处理用户交互
- **功能**：
    - 显示主菜单
    - 接收用户输入
    - 调用 InventoryManager 执行业务逻辑
    - 显示操作结果

### 2.2 数据文件
- **文件名**：`inventory.txt`
- **位置**：`data/` 目录下
- **格式**：每行一个商品，字段用 `|` 分隔
- **示例**：
- P001|笔记本电脑|电子产品|5999.0|10 
- P002|鼠标|电子产品|89.0|50 
- P003|办公桌|家具|1299.0|5

## 3. 核心功能

### 3.1 商品管理
- ✅ 添加新商品
- ✅ 删除商品
- ✅ 修改商品信息（名称、价格、数量等）
- ✅ 查询商品（支持按 ID查询）
- ✅ 显示所有商品列表

### 3.2 数据统计
- ✅ 统计商品总数
- ✅ 统计商品总价值
- ✅ 统计商品类别种类

### 3.3 持久化
- ✅ 启动时自动加载数据
- ✅ 操作后自动保存数据（追加模式）
- ✅ 文件不存在时自动创建

### 3.4 异常处理
- ✅ 商品不存在异常
- ✅ 数据格式错误异常
- ✅ 文件读写异常
- ✅ 输入验证异常

## 4. 技术要点

### 4.1 面向对象
- **封装**：私有属性 + 公有 getter/setter
- **继承**：InventoryException 继承 Exception
- **多态**：Object 类的 toString() 等方法重写

### 4.2 集合框架
- **HashMap**：快速查找商品（O(1) 时间复杂度）
- **ArrayList**：有序记录操作日志
- **HashSet**：去重统计商品类别

### 4.3 设计模式
- **单例模式**：InventoryManager 使用懒汉式单例

### 4.4 IO 流
- **FileWriter**：字符输出流（追加模式）
- **BufferedReader**：缓冲读取，提高效率
- **FileReader**：字符输入流

### 4.5 异常处理
- **try-catch-finally**：完善的异常捕获
- **自定义异常**：InventoryException 提供友好提示

## 5. 运行方式

### 5.1 环境要求
- JDK 1.8 或更高版本
- IDE（推荐 IntelliJ IDEA / Eclipse）

### 5.2 编译运行
- 在main下的InventoryMain.java文件中右键点击Run，即可编译运行

### 5.3 IDE 配置
1. 导入项目到 IDE
2. 设置工作目录为项目根目录
3. 运行 `InventoryMain.java`

## 6. 注意事项
- 确保工作目录设置为项目根目录，以便正确访问 `data/` 文件夹
- 商品 ID 必须唯一，不能重复
- 价格和数量必须为正数
- 文件采用追加模式保存，注意定期清理重复数据

## 7. 扩展建议
- [ ] 添加用户登录功能
- [ ] 支持批量导入/导出
- [ ] 添加库存预警功能
- [ ] 使用数据库替代文本文件
- [ ] 添加图形界面（Swing/JavaFX）
- [ ] 支持网络多用户访问


  
  
