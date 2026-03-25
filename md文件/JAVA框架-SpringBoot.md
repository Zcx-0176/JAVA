# <center><font face="仿宋" font color=bark>Spring Boot </font>
## <center><font face="楷体" size=5>zcx</font> 
## 一、什么是Spring
1. Spring是一个开源的Java开发框架，用于简化Java开发。
- Spring如何简化开发？
  - 1. 基于POJO的轻量级和最小侵入性编程
  - 2. 通过IOC、依赖注入(DI)和面向接口实现松耦合
  - 3. 基于切面(AOP)和惯例进行声明式编程
  - 4. 通过切面和模板减少样式代码
## 二、什么是SpringBoot
1. SpringBoot是一个javaWeb的开发框架，和SpringMVC类似，好处是：简化开发，约定大于配置，you can just run，能迅速的开发Web应用，几行代码开发一个http接口
2. Spring boot基于Spring开发，本身不提供Spring框架的特性及扩展功能，只是用于快捷、敏捷的开发新一代基于Spring框架的应用程序。
3. SpringBoot以**约定大于配置**的核心思想，默认帮我们进行了很多设置，多数SpringBoot应用只需要很少的Spring配置，同时他集成了大量的常用的第三方库配置(Redis,MongoDB,Jpa,RabbitMQ,Quartz),SpringBoot应用中这些第三方库可以说是零配置的**开箱即用**的。
4. SpringBoot可以说整合了所有框架
5. **主要优点**
   - 1. 为所有Spring开发者更快的入门
   - 2. 开箱即用，提供各种默认配置来简化项目配置
   - 3. 内嵌式容器简化Web项目
   - 4. 没有冗余代码生成和XML配置的要求
  
## 三、什么是微服务架构
1. 微服务是一种架构风格，他要求我们在开发一个应用的时候，这个应用必须构建成一系列小服务的组合，可以通过http的方式进行互通
2. 单体应用架构：一个代码库，包含所有功能模块，共享一个中心数据库，整个应用作为一个整体进行部署和扩展，技术栈相对单一，通信是进程内方法调用，速度快。但是他是一个整体，如果你要改动非常非常小的地方，也要重启全部整体，尤其是对于大型应用，不可能这样操作和开发，不过这个适合小型项目测试
3. 而微服务架构就是把项目的各个服务拆分，多个代码库，每个服务有自己的数据中心，每个服务可以独立部署和扩展，也可以使用适合自己开发的技术栈，服务间通过轻量级API通信，这样一个服务故障不会影响完整服务，也可以自由的扩展服务

## 四、第一个SpringBoot程序
1. 在Spring官网中，找到SpringBoot，在learn下找到Qiuckstart，点start.spring进去，创建SpringBoot项目，最后点击generate变成压缩包，然后IDEA打开解压后的文件，等待java环境安装完成，然后运行main方法，即主程序入口，然后再浏览器中输入localhost:8080，就可以看到SpringBoot的欢迎界面了，不过因为一开始程序什么都没有，所以浏览器会显示Whitelabel Error Page
2. 当然IDEA也集成了SpringBoot，所以也可以使用IDEA创建SpringBoot项目
3. SpringBoot可以运行对外提供服务的Web项目，以往javaSE只能写运行在本地的程序，但是SpringBoot内置了Tomcat服务器，网络通信，基础配置，使得主需要在其中写好业务逻辑，写接口就能对外输出，这就是SpringBoot干的事
### SpringBopt行业标准分层架构
- **核心入口：HelloWorldApplication.java，是整个项目的启动入口，点击运行按钮，就是执行这个main方法。**
- **@SpringBootApplication**是SpringBoot项目的核心注解，帮助我自动完成：自动扫描项目里的所有组件(如自己手动创建的Controller,Service,Repository,Dao)，自动配置所有依赖(如Tomcat，SpringMVC)，启动内置的Web服务器，让项目能被网络访问
- **创建controller包：专门负责接收网络请求，返回响应**
- **@RestController**是核心注解，告诉Spring这个类是一个接口控制器，作用是把这个类变成能处理网络请求的组件，Spring会自动扫描并管理他
- **@RequestMapping**是核心注解，**@RequestMapping("/hello")**这样写之后，在浏览器中输入localhost:8080/hello，就会返回hello()方法的返回值，即"Hello World"
- **创建service包：专门负责处理业务逻辑，调用底层数据**
- **创建dao包：专门负责处理数据，存数据**
- **创建pojo包：封装数据**
- 这就是之前说的分层架构，每一层，即每一个包都有自己专门负责的内容。
- IOC容器：在javaSE中需要new对象，但是SpringBoot不需要new就能运行，因为**SpringBoot核心特性：IOC**，Spring会自己创建、管理所有加了@RestController、@Service、@Repository、@Controller、@Component注解的类，并把对象放入IOC容器中，然后Spring会自动管理对象，比如Spring会自动调用对象的构造方法。
- **选中@RestController，使用快捷键ctrl+B，可以进去查看其源码，或者直接ctrl+鼠标左键，查看其源码**
- **pom.xml**内主要有四个部分
  - **项目元数据信息**：创建时驶入的Project Metadata部分，也就是Maven项目的基本元素，包括groupld,artifactId,version,name，description等
  - **parent**：继承SpringBoot的父类，继承父类的话，就可以使用SpringBoot的所有功能，继承spring-boot-starter-parent的依赖管理，控制版本与打包等内容
  - **dependencies**：项目具体依赖，包含了spring-boot-starter-web用于实现HTTP接口(该依赖中包含了SpringMVC)，spring-boot-starter-test用于编写单元测试的依赖包
  - **build**：构建配置部分，默认使用了spring-boot-starter-parent，就可以把SpringBoot应用打包成JAR来直接运行

- **如何打包jar包**：在IDEA最右侧的Maven侧边栏，找到项目，比如hello_world，然后点击生命周期Lifecycle，下拉展示找到package，双击package，就会把项目打包成jar包，然后就会在target目录下生成hello_world-0.0.1-SNAPSHOT.jar
- **如何运行jar包**：在target目录下找到jar包，双击运行，就会启动SpringBoot项目，然后访问localhost:8080/hello，就会返回"Hello World"。或者在文件资源管理器使用命令行：java -jar hello_world-0.0.1-SNAPSHOT.jar也可以直接运行
- **可以在resources目录下的application.properties文件，里面可以配置SpringBoot项目，比如端口号，数据库连接，缓存配置等等，这样，在打包成jar包后，就可以直接运行，不用再配置端口号了**
- 可以在resources目录下创建一个banner.txt，里面可以自定义启动时的欢迎界面，可以自己找喜欢的图标，这样，在打包成jar包后，就可以直接运行显示

## 五、原理初探
### **自动配置**
- **pom.xml**
  - spring-boot-dependencies:核心依赖在父工程中
  - 我们在写或者引入一些springboot依赖的时候，不需要指定版本，就因为有这些版本仓库
- **启动器**
  ```
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webmvc-test</artifactId>
            <scope>test</scope>
        </dependency>
  ```
  - 启动器说白了就是springboot的启动场景
  - 比如spring-boot-starter-web，他就会帮助我们自动导入web环境的所有依赖
  - springboot会将所有的功能场景，都变成一个个的启动器
  - 我们要使用什么功能，就只需要找到对应的启动器就可以了
- **主程序**
  ```
  @SpringBootApplication
  public class DemoHelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoHelloWorldApplication.class, args);
    }
    }
  ```
  - **@SpringBootApplication**：SpringBoot项目的核心注解，作用是把当前类标记为SpringBoot项目的启动类，即标记这个类为springboot的应用，并且启动类下的所有资源全都被导入
  - **SpringApplication.run(DemoHelloWorldApplication.class, args);是将springboot应用启动**

- **==自动配置一句话总结：SpringBoot 自动配置 = @EnableAutoConfiguration + 读取 META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports 文件 + 条件判断装配 Bean==** 简单说：SpringBoot 启动时，自动去加载配置类，满足条件就自动创建 Bean
- **核心流程**
  - 1. 开启自动配置：主类上的 @SpringBootApplication 包含了自动配置开关
  - 2. 加载配置类：读取固定文件里的所有自动配置类（比如 Redis、MyBatis、MVC 配置）
  - 3. 条件装配：判断环境是否满足，满足就自动创建 Bean，不满足就跳过

- **注解@SpringBootApplication**点进去，查看其源码，@SpringBootApplication = 下面 3 个注解的组合：
    - 1. @Configuration：标记为配置类
    - 2. @ComponentScan：扫描包下的组件
    - 3. @EnableAutoConfiguration：自动配置的核心开关
- **自动配置核心注解：**
   -   **@EnableAutoConfiguration**
       - 作用：开启自动配置功能
       - 底层：通过 @Import(AutoConfigurationImportSelector.class) 导入配置选择器
  - **AutoConfigurationImportSelector**
      - 关键方法：getAutoConfigurationEntry()
      - 作用：读取自动配置文件，加载所有预设的配置类
  - **条件注解(判断是否装配)，这些是自动装配的灵魂，满足条件才生效**
      - @ConditionalOnClass：类路径存在指定类才生效
      - @ConditionalOnMissingBean：容器没有这个 Bean 才生效（允许用户自定义覆盖）
      - @ConditionalOnProperty：配置文件有指定属性才生效
      - @ConditionalOnWebApplication：是 Web 环境才生效
- **==启动一句话总结：加载启动类、准备环境、创建容器、扫描加载 Bean、开启自动配置、启动内置服务器，最终启动整个 SpringBoot 应用。==**
   - 1. 传参：指定启动类，也就是包含main方法的类（配置入口）+ 命令行参数
   - 2. 执行：创建 Spring 应用上下文 → 自动配置 → 初始化 Bean
   - 3. 启动：启动 Tomcat 等内置容器，应用正式运行

## 六、SpringBoot配置
- **application.yml**：在resources目录下创建application.yaml文件，可以把原先的配置文件application.properties删除，用yml替换(注意：yaml和yml是一回事)
- **.yml是什么**
  - 1. 全称：YAML = YAML Ain't Markup Language
  - 2. 本质：配置文件格式，专门用来写配置
  - 3. 作用：替代 application.properties，更简洁、更易读、层级更清晰
  - 4. 后缀：
        .yml = 简写（推荐）
        .yaml = 全称（不常用）
  - 5. SpringBoot 自动识别：放在 resources 下就生效
- **yml三大核心语法**
  - 1. 键值对格式：key: value
    ==注意：冒号后面必须加空格！==
  - 2. 层级结构：用 2 个空格表示缩进（不能用 Tab）
  ```
  user:
    name: 张三
    age: 20
    address:
      city: 北京
      street: 中关村大街


  等价于：
  user.name = 张三
  user.address.city = 北京
  ```
  - 3. 大小写敏感
Name 和 name 是两个不同的键！
- **yml支持的数据类型**
  - 1. 字符串（最常用）
  ```
  str: 我是字符串
  ```
  - 2. 数字
  ```
  age: 20
  money: 99.8
  ```
  - 3. 布尔值
  ```
  flag: true
  show: false
  ```
  - 4. 空值null
  ```
  empty: null
  ```
  - 5. 数组(List)
  ```
  写法一：短横杠
  hobby:
  - 游泳
  - 跑步
  - 编程

  写法二：行内
  hobby: [游泳,跑步,编程]
  ```
  - 6. 对象(Map)
  ```
  person:
    name: 李四
    age: 25
  ```
- **SpringBoot中yml最常用功能**
  - 1. 端口号配置
  ```
  server:
    port: 8080
  ```
  - 2. 自定义配置
  ```
  my:
    name: 小明
    age: 18
    message: "hello world"

  在代码中读取：
  @Value("${my.name}")
  private String name;
  ```
  - 3. 引用配置
  ```
  app:
    name: myapp
    desc: ${app.name}是一个SpringBoot项目
  ```
  - 4. 多环境切换
     - 开发环境：application-dev.yml
     - 生产环境：application-prod.yml
     - 测试环境：application-test.yml
     - 主文件切换
     ```
      spring:
        profiles:
          active: dev  # 启用dev环境
     ```