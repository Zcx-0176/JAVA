## 人才招聘系统

### 一、基本内容：
1. 分为三个模块：个人用户模块、企业用户模块、管理员模块
    - 个人用户：用户个人信息管理、密码修改、登出账号、修改简历、职位查询、求职管理、留言
    - 企业用户：企业信息管理、公司在招岗位管理、密码修改、登出账号、人才查询、留言
    - 管理员：管理员信息管理、会员审核、留言管理、密码修改、登出账号
2. 根据上述功能，需要暂时建立8个表
    - 个人用户基本信息表：存储个人用户的基本信息：主键id、账号名、姓名、邮箱、密码、是否为会员
    - 企业用户基本信息表：存储企业用户的基本信息：主键id、账号名、企业名、企业地点、企业介绍、主营业务、工作时间、密码、是否为会员
    - 个人用户简历表：存储每个用户的完整简历信息：主键id、用户id、性别、身份证号、出生日期、民族、政治面貌、婚姻状况、籍贯、目前所在城市、最高学历、毕业学校、院系、专业、学历类别、学制、外语水平、求职城市、预期应聘岗位、掌握技能、项目经历、自我评价
    - 岗位表：存储所有公司所有岗位表：主键id、岗位名称、企业id、目标学历、掌握技能、薪资、工作类别(实习、正式工)、工作地点、岗位状态
    - 已投递的岗位表：存储所有用户已经投递的岗位：主键id、个人用户id、岗位id、投递时间、投递状态
    - 会员注册表：主键id、申请账号的名字、申请人身份、申请时间、申请是否通过(这个字段更新后要同步更新对应的用户表或企业表的是否为会员字段)
    - 留言表：主键id、留言用户名、留言用户类型(个人用户 企业用户 管理员)、留言信息、留言时间、管理员回复
    - 管理员基本信息表：存储管理员基本信息：主键id、账号名、管理员名、性别、年龄、邮箱、密码
### 二、具体实现
1. 创建表
- 个人用户基本信息表
```
create table user_info(
	id bigint not null auto_increment comment '主键ID，自增',
	account varchar(50) not null unique comment '账号名，唯一不可重复',
	username varchar(30) not null comment '姓名',
	email varchar(100) unique comment '邮箱，唯一不可重复',
	password varchar(64) not null comment '密码',
	is_vip tinyint not null default 0 comment '是否为会员：0=非会员，1=会员',
	primary key(id)
)engine=InnoDB default charset = utf8mb4 comment='个人用户基本信息表';
```
- 企业用户基本信息表
```
create table enterprise_user_info(
	id bigint not null auto_increment comment '主键ID，自增',
	account varchar(50) not null unique comment '账号名，唯一不可重复',
	enterprise_name varchar(100) not null comment '企业名',
	address varchar(255) not null comment '企业地点',
	introduction text comment '企业介绍',
	main_business varchar(255) not null comment '主营业务',
	work_time varchar(100) comment '工作时间',
	password varchar(64) not null comment '密码',
	is_vip tinyint not null default 0 comment '是否为会员：0=非会员，1=会员',
	primary key(id)
)engine=InnoDB default charset = utf8mb4 comment='企业用户基本信息表';
```
- 个人用户简历表
```
create table user_resume(
	id bigint not null auto_increment comment '主键ID，自增',
	user_id bigint not null comment '关联个人用户表的主键ID',
	gender varchar(10) comment '性别：男/女',
	id_card varchar(18) unique comment '身份证号，18位唯一',
	birth_date date comment '出生日期',
	nation varchar(20) comment '民族',
	political_status varchar(20) comment '政治面貌：中共党员/群众/共青团员等',
	marital_status varchar(10) comment '婚姻状况：已婚/未婚/离异',
	native_place varchar(100) comment '籍贯',
	current_city varchar(50) not null comment '目前所在城市',
	highest_education varchar(20) not null comment '最高学历：大专/本科/硕士/博士等',
	graduate_school varchar(100) not null comment '毕业学校',
	department varchar(50) not null comment '院系',
	major varchar(50) not null comment '专业',
	education_type varchar(20) comment '学历类别：全日制/非全日制/成人教育等',
	school_system varchar(10) comment '学制：4年/3年/2年等',
	foreign_level varchar(30) comment '外语水平：CET-4/CET-6/TEM-8/流利等',
	job_city varchar(50) not null comment '求职城市：期望工作地点',
	expected_position varchar(100) not null comment '预期应聘岗位：Java开发/产品经理等',
	skills text comment '掌握技能：技术栈/专业技能',
	project_experience text comment '项目经历：项目名称、职责、技术栈、成果',
	self_evalution text comment '自我评价：个人优势/职业规划',
	primary key (id),
	constraint fk_resume_user_id foreign key (user_id) references user_info(id) on delete cascade
)engine=InnoDB default charset = utf8mb4 comment='个人用户简历信息表';
```
- 岗位表
```
create table job_post(
	id bigint not null auto_increment comment '主键ID，自增',
	job_name varchar(100) not null comment '岗位名称',
	enterprise_id bigint not null comment '企业ID，关联企业用户表的id',
	target_education varchar(50) comment '目标学历要求',
	skills text comment '掌握技能要求',
	salary varchar(50) not null comment '薪资：如 8k-12k、面议',
	work_type varchar(20) not null comment '工作类别：实习/正式工',
	work_location varchar(100) not null comment '工作地点',
	job_status tinyint not null default 1 comment '岗位状态：1=招聘中，0=已关闭',
	primary key (id),
	constraint fk_job_enterprise_id foreign key (enterprise_id) references enterprise_user_info(id) on delete cascade
)engine=InnoDB default charset = utf8mb4 comment='岗位信息表';
```
- 已投递的岗位表
```
create table delivery_record(
	id bigint not null auto_increment comment '主键ID，自增',
	user_id bigint not null comment '个人用户id，关联个人用户表',
	job_id bigint not null comment '岗位id，关联岗位表',
	delivery_time datetime not null default current_timestamp comment '投递时间',
	status tinyint not null default 0 comment '投递状态：0=待查看，1=已查看，2=已录用，3=已拒绝',
	primary key (id),
	constraint fk_delivery_user_id foreign key (user_id) references user_info(id) on delete cascade,
	constraint fk_delivery_job_id foreign key (job_id) references job_post(id) on delete cascade
)engine=InnoDB default charset = utf8mb4 comment='已投递岗位表';
```
- 会员注册表
```
create table member_apply(
	id bigint not null auto_increment comment '主键ID，自增',
	account varchar(50) not null comment '申请账号的名字（个人/企业账号）',
	identity tinyint not null comment '申请人身份：1=个人用户，2=企业用户',
	apply_time datetime not null default current_timestamp comment '申请时间',
	status tinyint not null default 0 comment '申请状态：0=待审核，1=已通过，2=已拒绝',
	primary key (id)
)engine=InnoDB default charset = utf8mb4 comment='会员注册表';
```
- 留言表
```
create table message_board(
	id bigint not null auto_increment comment '主键ID，自增',
	username varchar(50) not null comment '留言用户名',
	user_type varchar(20) not null comment '用户类型：个人用户/企业用户/管理员',
	cotent text not null comment '留言信息',
	create_time datetime not null default current_timestamp comment '留言时间',
	reply text comment '回复',
	primary key (id)
)engine=InnoDB default charset = utf8mb4 comment='留言表';
```
- 管理员基本信息表
```
create table admin_info(
	id bigint not null auto_increment comment '主键ID，自增',
	account varchar(50) not null unique comment '账号名',
	admin_name varchar(30) not null comment '管理员名',
	gender varchar(10) comment '性别',
	age int comment '年龄',
	email varchar(100) unique comment '邮箱',
	password varchar(64) not null comment '密码',
	primary key (id)
)engine=InnoDB default charset = utf8mb4 comment='管理员基本信息表';
```

2. **在application.yaml中配置数据库**
```
server:
  #项目启动后访问的端口号
  #浏览器访问localhost:8080
  port: 8080

spring:
  #   数据库连接配置块
  datasource:
    #数据库连接地址+对应的数据的名
    #   url是找到并链接上MySQL的地址字符串
    #   jdbc:mysql:  告诉程序我要连MySQL，localhost:3306：本机，端口号3306，tanlent_rs用哪个库
    #   url后续跟的几个参数
    #   ？useUnicode=true  使用Unicode编码
    #   characterEncoding=utf8  字符集UTF-8，防止中文乱码
    #   serverTimezone=GMT%2B8  时区=东八区(中国时间)
    #   因为两者各自有自己的时区，两者时间不一样就会时间错乱，所以必须要url中强制制定时区
    #   MySQL安装时默认是UTC(世界标准时间)，而我所在中国为UTC+8，差了8h，驱动为了安全不允许自动猜测时区
    url: jdbc:mysql://localhost:3306/tanlent_rs?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
    username: root    # 数据库用户名
    password: 123456  # 数据库密码
    driver-class-name: com.mysql.cj.jdbc.Driver  #    MySQL驱动

#MyBatis通用配置
mybatis:
  #   项目的classpath下，也就是编译后的resources目录下找mapper文件夹下所有.xml文件
  #   这里是写SQL的地方，MyBatis需要找到xml执行SQL
  mapper-locations: classpath:mapper/*.xml
  #   这是MyBatis核心配置节点，下面的所有配置都是控制MyBatis运行规则的
  configuration:
    #   开启下划线<-->驼峰命名自动映射，即自动匹配实体类各个属性名映射对应数据库的表各个属性名
    #   这个配置是把数据库表的user_id属性转换为userId来与实体类的属性匹配
    #   即去下划线并把下划线后的第一个字母自动大写
    #   关了这个那就是严格匹配，不过如果实体类全小写开了这个也匹配不上
    #   实在想用全小写，就自己在xml中一一对应数据库的属性，或者用注解
    map-underscore-to-camel-case: true
    #   控制台打印SQL日志，把MyBatis执行的SQL语句，参数。查询结果，影响行数全都打印到IDE控制台
    #   便于开发调试，生产环境下建议关掉
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

3. **创建实体类**
- 实体类是数据库表在java里的镜像，用来封存数据，在Controller、Service、Mapper之间传递数据
   - 从数据库中查出来的数据->装进实体类
   - 从前端传过来的JSON->转成实体类
   - 业务层处理数据->用实体类存
- **数据库、实体类，数据类型对应表**
-  |             MySQL数据类型              |    java推荐类型     |              说明                         |
   |:----------------------------------:|:---------------:|:---------------------------------------:|  
   |                int                 |     Integer     |                  普通整数                   |
   |               bigint               |      Long       |                主键ID都用这个                 |
   |              tinyint               | Integer/Boolean |            0/1表示状态可用Bopolean            |
   |              smallint              |     Integer     |                   少用                    |
   |            decimal(m,n)            |   BigDecimal    |              金额、价格必须用这个精确               |
   |            double/float            |     Double      |                不精确、一般不用                 |
   | varchar(n) 、char(n) 、text/longtext |     String      |            所有字符串、用户名、手机号、内容             |
   |              datetime              |  LocalDateTime  |       日期 + 时间：2025-10-01 14:30:05       |
   |                date                |    LocalDate    |             只有日期：2025-10-01             |
   |               time                 |    LocalTime    |              只有时间：14:30:05              | 
   |              timestamp     |      LocalDateTime    | 日期 + 时间：2025-10-01 14:30:05  带时区 / 自动更新 |

4. **写Mapper(DAO)层**
- **DAO**:数据访问对象(Data Access Object)的简称，是软件架构中负责封装数据源(数据库、文件、外部API)访问的特定层次，属于持久层
- **核心目的**：将业务逻辑与数据访问逻辑解耦，让业务层(Service)不直接处理底层数据的存取细节
- **主要职责**：
   - **封装数据操作**：提供对单一实体的CRUD操作
   - **隔离数据源**：无论什么层什么架构，都通过统一的DAO接口调用，无需关心具体实现，更换数据库时，只需替换DAO，而业务代码无改动
   - **集中化数据逻辑**：所有SQL语句，NoDB查询，数据映射等，都集中在DAO层
   - **提供领域对象**：DAO层通常将查询结果封装成业务层能理解的领域对象(Domain Object)或实体类返回，而不是裸数据(ResultSet)

- **方法**：
   - **首先创建mapper包，在其下创建mapper接口，使用@mapper注解**
     - @mapper:标记这个接口是MyBatis映射接口，Spring启动时会扫描带这个注解的接口，MyBatis自动给他生成代理对象，放进Spring容器，那在service中就能直接使用@Resource注入使用
        
        - 代理对象：Spring动态生成的壳对象，长得跟原对象一样，能调用同样的方法，但内部包含着原对象
        - 代理对象能做增强逻辑，即开启事务，记录日志，权限校验，提交/回滚事务，记录结果
        - 为什么要用代理对象：因为Spring很多功能必须靠代理才能实现，如事务、缓存、异步、AOP切面，这些逻辑不能直接修改在别人的源码上，所以需要代理对象增加这些。
       
        - 容器：就是Spring的对象工厂和管家
        - 好处：
            - 统一创建、管理生命周期，即不需要自己new，不用管什么时候初始化和销毁
            - 自动依赖注入：要用到别的bean(被Spring管理的对象)，Spring自动帮我找，帮我注入
            - 统一享受Spring功能：事务、AOP、事件、生命周期回调等功能只有容器里的bean才有
            - 单例默认，节省资源：避免到处new重复对象
        
        - 什么是依赖注入：不让类自己new对象，而是别人给你送过来
            - 原先是a类里面new b()，如果要换个类new还得去a里面亲自改源码
            - 依赖注入则把a和b解耦，Spring把b造好，直接塞给a，a不关心b怎么来，就算不想要b，不用改a的任何代码，只要换合适的bean就行
            - 依赖注入的a里面不用自己new b()了
        
        - 什么能作为bean：可以被Spring创建对象，需要被Spring统一管理、复用、注入
        - 常见的能做bean的东西：
            - @Controller：处理接口
            - @Service：业务逻辑
            - @Mapper、@Repository：操作数据库
            - @Configuration:配置类
            - @Component：通用工具类
            - @Bean:这个注解标注的方法返回的对象(Redis、线程池、数据源等)
        - 为什么他们能做bean：他们是工具型、服务型对象，全局只需要一个，大家共用，他们不存在业务数据，不会互相干扰，所以可以单例，可以托管给Spring
        - 什么不应该做bean：
            - 存数据的实体类：每次查询都要new一个，每个人的数据不一样，做成单例bean会导致数据混乱，线程不安全
            - 临时用一次就丢的对象：某个方法临时new的计算对象，临时封装参数的对象，用完就销毁，Spring没必要管
            - 大量频繁创建的对象：如线程任务，消息封装体，每次请求都要新建的对象，交给Spring管理更为麻烦
        - 总之：负责干活的可以做bean，需要共用，只用一次的能做bean，负责装数据的，每次都要新的不呢能做bean
        - 没有其他逻辑增强时，bean就是源对象
        - 当有其他逻辑增强时，bean是代理对象
        - 综上，代理对象一定是bean
        
        - AOP：面向切面编程，在不改变原有代码的前提下，给方法统一加功能
        - 即解决代码重复，将业务逻辑代码和通用逻辑代码分离
        - AOP就是通用逻辑代码，比如需要计算每个方法的用时，这个就可以用AOP，避免每个方法都在源码写这些重复的功能，AOP会自动把上述逻辑织进去
        - 那么显而易见AOP是通过代理对象实现把通用逻辑织进各个方法的

    
   - 当mapper注解标红，首先看pom.xml有没有MySQL和MyBatis依赖
   ```
     <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
     </dependency>

     <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>4.0.1</version>
     </dependency>
  
    MySQL依赖：叫JDBC驱动，是 Java 程序和 MySQL 数据库之间的「翻译官」
               Java 代码是 .class 字节码，MySQL 数据库只会处理 SQL 指令，这个驱动就是把 Java 的请求翻译成 MySQL 能懂的语言，再把数据库的返回结果翻译成 Java 能处理的数据
                runtime是指在项目运行时需要，编译时不需要，因为项目代码里不会直接调用这个驱动的类。都是通过JDBC接口间接调用
    MyBatis依赖：是 MyBatis 和 Spring Boot 的「整合包」
                用来封装JDBC操作，不需要自己写繁琐的JDBC代码
                提供MyBatis核心功能：能用@Mapper、@Select 这些注解写 SQL，支持 XML 写复杂 SQL、动态 SQL，自动把数据库返回的结果映射成 Java 实体类，和 Spring 事务、Bean 管理无缝集成
   ```
   - 两种方式
   - **在mapper接口类中用各种指定注解实现**：使用@Select()、@Insert()等注解实现简单的CRUD操作
   - 缺点是：
     - SQL写在java代码里，杂乱且难以维护
     - 不支持复杂的动态SQL
     - 不支持多表复杂关联
     - 不支持复用SQL片段
     - 只适合简单表的简单CRUD操作
   - **自定义复杂查询 + MyBatis XML**：
     1. 在application.yaml中配置xml的路径(一开始的配置已经完成)
     2. 在mapper接口中只定义方法，不写实现
     3. 在XML中写复杂查询的SQL
- 如果不想每个 Mapper 都写@Mapper，可以在启动类统一扫描：@MapperScan("com.xxx.project.mapper") // 扫描Mapper包
- 一个实体类对应一个mapper接口，对应一个xml文件。用来专门操作这张表


- MyBatis封装了JDBC，JDBC是java访问数据库的唯一官方方式
- 因为不同的不同的数据库厂商的数据库底层通信协议完全不同，java不可能每一个数据库都要写一个专门的连接代码
- 所以Sun公司定义一套标准接口，然后各个数据库厂商自己写实现类(即驱动包)
- 这样java只需要：加载驱动，获取连接，发SQL，拿结果
- 这样java不管数据库是什么，统一用JDBC这套API就能操作所有数据库
- 不过因为原生JDBC调用起来非常麻烦：写一段查询需要加载驱动，获取连接，创建Statement，写SQL，执行，遍历ResultSet，一行一行手动封装对象，处理异常，关闭结果集，语句，连接
- 代码非常长，容易错，非常重复
- 所以使用MyBatis框架封装JDBC，将上述重复麻烦的事情全干了：自动管理连接，自动打开关闭资源，自动把ResultSet封装成实体类对象，统一处理异常，支持动态SQL，支持缓存，支持参数安全处理(防止SQL注入)
- 本质MyBatis就是简化增强版JDBC


- 在mapper中的接口中定义的方法
   - 若是CRUD操作，新增，删除，修改这三个方法返回值都是int，返回的是影响的行数。若返回1证明执行成功，返回0执行失败
   - 而查询返回值是对应的实体类类型，或List，Map集合，当然集合内的数据类型是对应实体类


- 在.xml中如何书写SQL
- 以管理员基本信息接口的CRUD为例
```
package com.zcx.talentrecruitmentsystem.mapper;
/*
    管理员基本信息mapper接口，主要声明基本的CRUD方法
 */
import com.zcx.talentrecruitmentsystem.entity.AdminInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminInfoMapper{
    //新增，删除，修改方法的返回值都是int，这是执行该方法后影响的行数
    //如果返回1 证明执行成功，若返回0证明执行失败
    //所以不用void做返回值
    //而查询是为了要拿到数据，所以返回对应的实体类对象、List集合、Map集合

    //新增管理员
    int insertAdmin(AdminInfo adminInfo);

    //根据Id删除管理员
    int deleteAdminById(Long id);

    //修改管理员信息
    int updateAdmin(AdminInfo adminInfo);

    //根据Id查询管理员
    AdminInfo selectAdminById(Long id);

    //查询全部管理员
    List<AdminInfo> selectAllAdmins();

}
```
- 以管理员基本信息.xml的CRUD的具体SQL实现为例
```
<?xml version="1.0" encoding="UTF-8" ?>       固定模版：这是 XML 文件声明，版本 1.0，编码 UTF-8
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"        
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">      固定模版;告诉 IDEA 这是 MyBatis 的映射文件，语法校验用的
<mapper namespace="com.zcx.talentrecruitmentsystem.mapper.AdminInfoMapper">   固定模版：把 XML 和 Mapper 接口绑定在一起，只需要修改对应的包名，为了找到对应的接口方法
    
        //这是插入SQL，id是对应接口的插入方法名，parameterType表示传入该方法的参数
    <insert id="insertAdmin" parameterType="AdminInfo">
    
        //这就是具体的插入SQL语句，对应的数据库表名，列名，#{实体类对应的属性名}，表示从传入的AdminInfo对象中拿数据
        //可以小写SQL语法
        insert into admin_info(account,admin_name,gender,age,email,password)
        values(#{account},#{adminName},#{gender},#{age},#{email},#{password})
        
    </insert>
    
        //这是删除SQL，where用来限制
    <delete id="deleteAdminById" parameterType="long">
        delete from admin_info where id=#{id}
    </delete>
    
        //这是修改SQL
    <update id="updateAdmin" parameterType="AdminInfo">
        update admin_info
        set account=#{account},admin_name=#{adminName},gender=#{gender},age=#{age},email=#{email},password=#{password}
        where id=#{id}
    </update>
    
        //这是按id查询SQL，resultType是返回值的类型，这里为AdminInfo
    <select id="selectAdminById" parameterType="long" resultType="AdminInfo">
        select id,account,admin_name,gender,age,email,password from admin_info where id=#{id}
    </select>
    
        //这是查询全部SQL，resultType是返回值的类型，这里为AdminInfo
        //对应的方法没有传入的数据，所以不需要写parameterType
        //注意MyBatis 会自动把多条数据封装成 List，不用在 XML 里写 List
    <select id="selectAllAdmins" resultType="AdminInfo">
        select id,account,admin_name,gender,age,email,password from admin_info
    </select>
    
    
</mapper>
```
- 注意，如果需要从数据库中拿数据，比如查询语句，就必须写resultType，因为查询需要返回查询后的数据。所以必须写名返回数据类型
- 而增、删、改，在MyBatis里不需要从数据库拿数据，只是受影响行数而已，这是固定规则，所以不需要写resultType


- 在已投递的岗位mapper接口中，需要声明一个根据用户id查询该用户已经投递过的岗位。及该岗位的详情信息，需要联表查询
- 即DeliveryRecord表和JobPost表

- 因为要查询某个用户id的已投递的岗位的信息，即联表查询，查询岗位表和已投递岗位表中岗位相同的部分，并且限制为用户ID，并且排序
- 而且不止要返回JobPost的属性，还要返回已投递岗位表的投递时间和简历状态
- 光只返回JobPost不够

- 所以需要新建vo包，在其下创建JobPostWithDeliveryVO.java，这是个类，综合了两张表的要查询的属性，不对应任何数据库表，主要用于临时把两张表查出来的数据打包给前端展示

- 因为已经在application.yaml中配置好了在resources.mapper下找.xml文件，所以
- 在.xml中写的resultType可以从com.zcx.talentrecruitmentsystem.entity.JobPost，变为JobPost

- 遇到.xml格式标红，但是格式完全正确，完全关闭项目再打开即可，会重新解析的
- 


```
package com.zcx.talentrecruitmentsystem.vo;
/*
    临时保存，岗位表和已投递岗位表的联查信息
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostWithDeliveryVO {  这包含了全部的JobPost属性和两个DeliveryReacord属性
    private Long id;
    private String jobName;
    private Long enterpriseId;
    private String targetEducation;
    private String skills;
    private String salary;
    private String workType;
    private String workLocation;
    private Integer jobStatus;

    private LocalDateTime deliveryTime;
    private Integer status;
}


<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zcx.talentrecruitmentsystem.mapper.DeliveryRecordMapper">
    <select id="selectJobPostByUserId" parameterType="long" resultType="JobPostWithDeliveryVO">
        select  j.*,dr.delivery_time as deliveryTime,dr.status as deliveryStatus     查询全部JobPost的属性+两个已投递岗位的属性
        from delivery_record dr    从已投递岗位开始查
        inner join job_post j   内联查询岗位表
        on dr.job_id = j.id    先查两者岗位id相同的
        where dr.user_id = #{userId}    查完后根据用户id和已投递岗位表用户id进行匹配筛选
        order by dr.delivery_time DESC   根据投递时间倒序排序，即最新的出现在前面
    </select>
</mapper>
```

- 企业基本信息由要有CRUD
- 会员申请表要有企业用户和个人用户的申请(即insert功能)
- 管理员要有查看所有会员申请表，根据id修改申请表中的申请状态，并进一步修改企业用户和个人用户的isVip属性值
- 已投递的岗位要新增根据企业id查询哪些用户投递了这个企业的什么岗位
- 即再建一个OV，里面有已投递的岗位表的属性+岗位名+用户名，三表联查(已投递岗位表+岗位表+用户基本信息)
- 在岗位表需要有根据企业id查询该企业的所有岗位
- 留言表需要三种身份留言互通功能，就是一种CRUD
- 简历表中要有根据毕业学校或者用户id查询对应简历的操作，这是给企业搜索人才简历的实现
- 个人用户基本信息CRUD
- 在岗位表需要根据用户skills模糊查询匹配的岗位
- 简历表的基本CRUD
- 还要有用户投递这个功能，需要在投递表中增加SQL

- **综上。mapper接口和xml只是把各个大功能拆分成细碎的SQL功能，即增删改查，按某个属性查，联表查**
**mapper不关心业务逻辑，不关心各个细碎的功能组合成什么样的复杂功能，他只知道要实现那些负责功能会用到这些CRUD操作**

5. **创建service层**
- **service有两个，一个是service接口，把mapper接口套个壳子，原封不动，另一个是service实现类，把service接口的多个原子功能组合成一个复杂的功能**
**加判断，加事务(几个功能必须全部成功或全部失败)，加校验，加逻辑，就像零件组成成品一样**

- **为什么还需要单独的service接口，我直接用mapper接口不行吗？**
  - 因为mapper接口管的是MyBatis数据库操作
  - 而service接口管的事Spring的业务操作
  - 职责不同，代理者不同，层级不同
- service接口的方法名跟mapper接口的相似，在其实现类里实现了各个声明的方法
怎么实现的？注入mapper，声明对应的mapper接口名，调用其mapper内的方法来实现对应的业务方法

- 以对个人用户基本信息Service接口和其实现类为例
```
package com.zcx.talentrecruitmentsystem.service;

import com.zcx.talentrecruitmentsystem.entity.UserInfo;

import java.util.List;

/*
    个人用户基本信息service接口
 */
public interface UserInfoService {

    //每个方法名跟mapper接口差不多
    int addUser(UserInfo userInfo);
    int deleteUser(Long id);
    int updateUser(UserInfo userInfo);
    UserInfo getUserById(Long id);
    List<UserInfo> getAllUsers();
}


package com.zcx.talentrecruitmentsystem.service.impl;
/*
    用个人用户基本信息Service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import com.zcx.talentrecruitmentsystem.mapper.UserInfoMapper;
import com.zcx.talentrecruitmentsystem.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //告诉Spring：这个类是业务层，会自动创建这个类的对象，放在Spring容器里，想用就用
public class UserInfoServiceImpl implements UserInfoService {

    @Resource   //告诉Spring 把下面的接口拿过来用，因为mapper注解使得MyBatis自动生成了实现类，Spring把它放进了容器，这个注解直接从容器内拿出来用
    private UserInfoMapper userInfoMapper;

    @Override   //重写接口
    public int addUser(UserInfo userInfo){
        return userInfoMapper.insertUser(userInfo);   //直接return就行是因为当前没有业务逻辑直接就是数据库操作
    }

    @Override
    public int deleteUser(Long id){
        return userInfoMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(UserInfo userInfo){
        return userInfoMapper.updateUser(userInfo);
    }

    @Override
    public UserInfo getUserById(Long id){
        return userInfoMapper.selectUserById(id);
    }

    @Override
    public List<UserInfo> getAllUsers(){
        return userInfoMapper.selectAllUsers();
    }

}


```

- 所以service接口就是把mapper接口的方法全搬过来，只不过方法名易读一点
- 然后service实现类就把service接口进行实现，首先加 **@Service**注解
- 告诉Spring：这个类是业务层，会自动创建这个类的对象，放在Spring容器里，想用就用
- 然后 **@Resource**进行依赖注入，把对应的mapper接口拿过来用，在各个重写的方法中返回  调用mapper接口的各个方法的结果
- 即根据mapper的方法，实现service实现类，只不过依赖注入(DI)

- 有的复杂的逻辑需要组合别的方法，比如只有在status为1的时候才可以修改是否为vip
- 如：只有是企业用户才可以修改简历投递状态属性
- 这两个都在service接口内声明了新的方法，并在实现类通过组合各个mapper接口的方法实现

- @Param是mapper接口的东西，是为了和SQL注明对应的变量名，到了service接口就需要去掉

- **登录操作**：
    - 在controller层：接收请求、返回结果
    - 在service层：调用mapper的方法，根据传入的account获取对象，如果对象为null，或对象的password不等于传入的password，就返回null，否则返回得到的对象
    - 在mapper层：根据传入的账号进行查询，返回对象，在SQL里写按照account查询
    - 在entity层：用户数据结构


6. **创建controller层**
- controller是整个项目的大门、入口、接口提供者
- **即：接收前端请求->调用service->返回结果给前端，是前后端交互的唯一入口**
- **职责**：
    - 接收前端传来的参数：路径参数、表单、json、文件...
    - 简单的参数合法性校验：不能为null、不能为空、格式对不对
    - 调用对应的service方法：自己绝对不写业务，不写SQL
    - 统一封装结果返回给前端：成功、失败、提示语、数据
- controller绝对不写业务逻辑、不调用mapper、不处理事务、不写复杂判断、不操作数据库 ---这全是service的事
- 各层的关系：
    - 调用方向：前端 → Controller → Service → Mapper → DB
    - 返回方向：DB → Mapper → Service → Controller → 前端

- **@RestController**注解：等于把@Controller + @ResponseBody 合在一起
- 作用：表示这个类是接口控制层，即让这个类里的所有方法，都返回JSON数据给前端，而不是跳转页面
    - @Controller：标记这是一个控制器，接收请求
    - @ResponseBody：把返回的对象转成 JSON 字符串
    - @RestController就是上面两者的总和

- 为什么要用这个注解：因为当前项目是前后端分离的项目，后端只提供JSON接口，前端负责页面渲染
- 如果不加@RestController，返回的会被当成页面路径，直接报错

- JSON是啥：JSON是前后端通用的数据格式
```
{
  "id": 1,
  "username": "张三",
  "age": 22
}
```
- 特点：前端能直接读，后端能直接转对象，轻量通用且所有语言都支持
- 即：在controller中返回对象，Spring 会自动把它变成JSON给前端

- @RequestMapping("/user") 什么意思：给整个controller设置接口统一前缀
```
@RestController
@RequestMapping("/user")
public class UserController {
}

那么首先标记了该类为controller接口
其次该类里面所有的接口地址都会自动带上/user
如/add -> 实际地址：/user/add
```
- 作用：
    - 分类接口：用户相关、岗位相关、简历相关具有不同的路径
    - 避免地址冲突：如果多个模块的接口地址都是list，那么如果他们的头地址不同，就不会冲突

- 接口地址：在浏览器、前端里输入的网址
```
http://localhost:8080/user/list
```
- 这个东西叫接口地址，也叫请求路径，后端就是靠这个地址，找到对应的方法去执行

- 为什么会有接口地址：因为前端要告诉后端，我想干什么
- 如：想查用户：访问/user/list，想查岗位：访问/job/list
- **接口地址是自己用注解写出来的**
```
@GetMapping("/list")
查询用，地址栏能直接访问，适合查列表，查详情


@PostMapping("/add")
新增、修改用，用于提交JSON数据，适合表单、复杂对象

```
- 以UserInfoController为例
- 创建controlle包
- 在包下创建各个controller类
- 在类的上面添加@RestController注解和@RequestMapping("/user")注解
- 在类的内部使用依赖注入，使用对应的service接口
- 根据@GetMapping和@PostMapping注解，自己定义合适的接口地址
- 然后每个函数的返回值都是Result
- 每个函数内调用对应的service的各个方法即可

- 因为需要前后端统一格式，所以需要创建common包，在其中创建Result类
```
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

```
- 它是给前端返回数据的标准信封，不管是查询、新增、删除、登录，后端永远只返回这一种格式
- 这样前端拿到就知道：成功还是失败(code)，提示信息(msg),数据是什么(data)
- 最终返回给前端：
```
{
  "code": 200,
  "msg": "登录成功",
  "data": {
    "id": 1,
    "account": "zhangsan",
    "name": "张三"
  }
}
```
- 然后就是在controller类里面写各种方法，使用Result为返回值

- 什么时候用GetMapping：
  - 只是查询、获取数据，如查询列表、根据id查详情、搜索、筛选
  - 参数很少，很简单。如id，
  - 没有敏感信息，如没有密码、账号之类的
  - 可以刷新、收藏、可以直接在浏览器打开
- 什么时候用PostMapping：
  - 要新增、修改、删除数据
  - 参数多、结构复杂、是一个对象：如传某个实体类对象，前端传JSON
  - 包含敏感信息：如密码、账号、身份证
  - 不希望参数暴露在地址栏：密码不能出现在URL里，不想被浏览器历史记录保存
  - 前端传JSON。必须要在传递的参数前加@RequestBody，只要写了这个注解，必须搭配PostMapping

- **上述两个注解都是请求方式过滤器**
- 它们不负责处理业务，只允许对应类型的HTTP请求进来，其他类型直接拒绝
- HTTP协议里本来就有这两种请求方式，一种是GET 一种是POST
- SpringBoot里的两个注解分别对应了这两个请求方式
- 它们的底层都用一个注解：@RequestMapping
- 所以@GetMapping = 限定请求方式为GET的RequestMapping
- 所以@PostMapping = 限定请求方式为POST的RequestMapping

- Spring底层如何识别：
- 项目启动->Spring扫描所有@RestController->把每个方法上的路径和请求方式存到一个Map里
->前端请求进来->Spring拿到请求地址和请求方式->去Map里面匹配：地址对得上且请求方式对得上->放行执行    地址对得上但方式不对->405错误 Method Not Allowed

- GET 和 POST 在底层传输上的真正区别
- GET底层：
    - 参数放在URL后面 /login?account=xxx&pwd=xxx
    - 长度有限制
    - 会被缓存、会被历史记录
    - 明文可见
- POST底层;
    - 参数放在请求体：Request Body
    - URL上看不见
    - 长度几乎无限制
    - 不会被缓存
    - 更安全

- **在启动类里运行**
  - 常见报错：
    - 直接在xml里ResultType使用类名但是MyBatis不知道这个类在哪，这一般是application.yaml没配置以下这一行
    - type-aliases-package: com.zcx.talentrecruitmentsystem.entity,com.zcx.talentrecruitmentsystem.vo
    - 告诉mybatis去这两个包下找类

    - xml中实现了两个方法名一样的SQL，这一般是复制粘贴的时候忘改了


7. **书写前端界面**
- 先在templates文件夹下写一个首页.html即index.html，用于处理三种身份登录
- 然后再一个根目录下写login.html
- 然后需要再控制层新加一个登录控制器，用于依赖注入其他控制器写好的登录功能，实现进入登录页、登录提交、退出登录

- 这里的依赖注入可以用@Autowired，也可以用@Resource，只不过后者是多个实现类时必须要用
- 注意：这个LoginController控制器类上方的注解必须使用@Controller，不能像其他8个使用@RestController
- 因为Controller注解可以跳转页面(html)，而RestController只返回数据，不跳转页面

```
package com.zcx.talentrecruitmentsystem.controller;

import com.zcx.talentrecruitmentsystem.common.Result;
import com.zcx.talentrecruitmentsystem.entity.AdminInfo;
import com.zcx.talentrecruitmentsystem.entity.EnterpriseUserInfo;
import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    以下是个人用户控制器，企业用户控制器，管理员控制器的依赖注入
    为的就是调用三个控制器实现好的login方法
    
    @Autowired
    private UserInfoController userInfoController;

    @Autowired
    private EnterpriseUserInfoController enterpriseUserInfoController;

    @Autowired
    private AdminInfoController adminInfoController;

    //进入登录页面    
    作用是访问   localhost:8080/login
    返回  login.html页面
    @GetMapping("/login")    当有人访问这个路径时，页面给他返回login.html
    public String toLogin(){
        return "login";
    }

    //登录提交
    @PostMapping("/login")  接收表单提交的登录请求
    public String login(
            @RequestParam String account,  接收账号
            @RequestParam String password,  接受密码
            @RequestParam String role,  接收角色
            Model model,   用来传递错误信息
            HttpSession session  保存登录用户信息
    ){
        Result result;  接收登录返回值

        switch(role){  判断是哪个用户身份
            case "user":
                result = userInfoController.login(account,password);
                if(result.getCode()==200){   获取result返回值的code属性，为200则是代表成功
                    UserInfo userInfo = (UserInfo) result.getData();   取出用户对象
                    session.setAttribute("loginUser",userInfo);   存入session方便后续页面使用
                    return "redirect:/user/index";   跳转到对应身份首页
                }
                break;
            case "enterprise":
                result = enterpriseUserInfoController.login(account, password);
                if(result.getCode()==200){
                    EnterpriseUserInfo enterpriseUserInfo = (EnterpriseUserInfo) result.getData();
                    session.setAttribute("loginEnterprise",enterpriseUserInfo);
                    return "redirect:/enterprise/index";
                }
                break;
            case "admin":
                result = adminInfoController.login(account, password);
                if(result.getCode()==200){
                    AdminInfo adminInfo = (AdminInfo) result.getData();
                    session.setAttribute("loginAdmin",adminInfo);
                    return "redirect:/admin/index";
                }
                break;
        }
        //登录失败
        model.addAttribute("msg","账号或密码错误，请重试！");  把错误信息传到页面
        return "login";   返回登录页
    }

    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();    清空session
        return "redirect:/login";    跳回登录页
    }
}
```

- 在index.html中，一般开始登录发的都是GET请求，所以会调用LoginController控制器中以GetMapping("/login“)为请求路径的方法，即进入登录页方法，返回的是"login"即返回login.html
- 然后这就是进入了login.html，在登录页面，前端实现登录按钮明确写了发送方式是POST，所以这会调用以PostMapping("/login")为请求路径的方法，即开始登录，返回的是各自的角色的首页


- **可以看出，虽然在之前的8个控制器，实现了自定义请求索引，对应了每个service方法，但是这只是传了数据**
- **要想跳转页面，执行功能，就需要再专门写跳转控制器，如这个登录跳转控制器**

- 同理，要实现admin控制器各种功能的跳转，还需要实现admin跳转控制器


- **注解后面跟着的接口路径是url，而return返回的页面是在resources目录下找的，两个不是一个东西**

- 页面跳转和数据传送不是一回事。
- 各个前端界面要想调用功能，就需要发送请求路径URL
- 页面跳转控制器，注解后面跟着的是URL路径，
- 并且数据传送控制器也是有注解后面跟着的URL的，他和页面跳转控制器的URL不能一样，
- 当前端输入一个URL时，若二者的注解请求接收的路径一样，那么浏览器就不知道是该跳转页面还是输出数据了

- 所以必须二者有点区分，比如在跳转页面的注解后面多加一个/page，做出区分

- 二者都有return ，返回的是前端界面，你得自己写
- 它是在你的项目的resources目录下寻找的，二者不是一回事

- 在面对修改申请状态之后直接修改isVip属性，用的事务@Transactional注解



8. **项目进阶：整合Redis**
- 首先需要添加Redis依赖
```
      <!-- Spring Data Redis 核心依赖 -->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-redis</artifactId>
      </dependency>
        
      <!-- Lettuce 连接池依赖 -->
      <dependency>
          <groupId>org.apache.commons</groupId>
          <artifactId>commons-pool2</artifactId>
      </dependency>
      必须加 Lettuce 连接池
      这就是 Redis 连接池
      不加 commons-pool2：你的代码每次操作 Redis 都会：
      新建一个连接，用完立刻关闭，下次用 → 再新建 → 再关闭
      就会导致：特别慢（每次都要重新握手、建立连接），高并发直接崩溃（端口不够用、Redis 卡死）
        
      加了连接池，它提前建好一堆连接，放在池子里循环复用
      流程变成：
      项目启动 → 提前创建 5~10 个连接
      你要用 → 直接从池子里拿
      用完 → 放回池子，不关闭
      别人用 → 继续拿，循环用
      
      这样速度极快（不用反复创建销毁）
      并发稳定（控制最多同时多少人访问）
      不会把 Redis 搞崩
        
      <!-- 配置处理器，消除 IDEA 配置提示 -->
      这个其实我实际加了也没用，主要是为了消除字体中间的红杠
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-configuration-processor</artifactId>
          <optional>true</optional>
      </dependency>
```
- 然后再application.yaml中的spring下添加redis配置
```
  redis:
    host: 127.0.0.1
    port: 6379
    password:
    database: 0
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        min-idle: 2
        max-wait: -1ms
        
  注意：一定在spring条目下加入Redis配置
  即：redis配置跟datasource的配置的缩进是一样的
  
  因为SpringBoot 是通过自动配置类来读取配置的
  Redis 的自动配置类是 RedisAutoConfiguration
  它只会读取 spring.redis.* 开头的配置，不会读根层级的 redis.*
  
  所以一旦redis配置不在spring节点下，而是自己单开一列写在根节点
  那么字体会全部标红，并且对于SpringBoot来说就是无效配置
```
- 创建 Redis 配置类（解决序列化乱码）
- 这个类是Redis的翻译官和格式化工具
- 如果没有redis配置类，那么Redis存的数据就会是乱码、看不懂、没法用
- 作用：
  - 把java对象 转成 JSON对象存进Redis
  - 把Redis里的JSON对象 转成java对象
  - 解决Redis存数据乱码的问题

- 为什么Redis存数据会乱码
- 不同于在cmd中使用Redis，cmd中敲的命令天然就是字符串，不会乱码
- 但在java中默认存Redis用的是二进制序列化，而不是字符串
- 他会把java对象变成二进制字节流存进redis，如果不写Redis配置类，那么就会输出乱码

- Redis配置类在哪里创建？
- 在common包下创建
- 因为common包是公共工具包，这个配置类是全局通用配置，整个项目都要用，所以放在这里最合适

- Redis配置类要加@Configuration注解
- 因为这个注解是告诉Spring，我是一个配置类，启动时要优先加载我
- 作用：
  - 加了这个注解，Spring启动时自动运行这个类
  - 不加：这个配置无效
  - 加了：这个配置类才能正常工作

- 在RedisConfig类中由于有对象RedisTemplate帮我们自动在java里写Redis的各种命令
- 即java操作Redis的遥控器，不用自己敲cmd中的Redis命令，spring自带
- 但是如上述所说，这个自带的对象RedisTemplate默认二进制序列化
- 所以我们需要自己定义一个RedisTemplate，给它设置好不乱码的规则，把他交给Spring管理

- 也就是说，其实spring里面RedisTemplate有各种功能，也有不乱码的方法
- 但是默认不开启，所以我们需要手动创建这个RedisTemplate对象，然后调用不乱码的功能
- 覆盖掉默认规则

- 流程：创建RedisTemplate对象，在其上加Bean注解，交给spring管理
- 然后将对象与Redis连接
- 设置key和value的存储格式，分别用String和JSON格式存储
- 然后用创建的RedisTemplate对象调用设置方法
- 方法的参数就是刚才定义的存储格式
- key和value各有两种方法要调用
- 一种是单独的键和值
- 一种是对象内的键和值
- 这两种方法根据传入的定义格式调用后，就覆盖了默认的二进制序列规则
- 然后调用afterPropertiesSet()方法，让设置生效
- 很重要
- 上述以前的设置都是半成品，RedisTemplate 内部有很多 “初始化逻辑”，比如：
  - 检查连接是否配置好
  - 检查序列化器是否配置好
  - 把你设置的各种规则真正加载进去
  - 把工具从 “半成品” 变成 “可用状态”
- 这些逻辑不会自动执行，必须手动调用这个方法才会跑
- 就相当于开机键，之前的步骤都是装外设，只有调用这个方法，才会初始化和激活所有配置，所有的配置才生效
- 最后返回创建好的对象

- 下面的代码就是标准写法，是通用的模版，不需要随着项目的不同改逻辑

```
package com.zcx.talentrecruitmentsystem.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/*
    Redis配置类
 */
@Configuration      告诉Spring，我是一个配置类，启动时要优先加载我
public class RedisConfig {

    
    制造一个RedisTemplate对象，交给Spring管理
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        
        //创建一个新的Redis遥控器，即Redis操作工具
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();

        //连接Redis服务，没有它，这个对象连接不到Redis
        redisTemplate.setConnectionFactory(factory);


        //设置key序列化和不乱码
        //即使用String存储
        //第一行的代码，是让普通的键值对的key不乱码，即name: zcx,age: 18，单独的key:如name和age
        //第二行的代码，是让对象里的好多key不乱码，即user1: name: zcx, age:20，包含在user1这个对象的key：如user1.name user1.age
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());

        //设置value序列化和不乱码
        //即使用JSON格式存储
        redisTemplate.setValueSerializer(RedisSerializer.json());
        redisTemplate.setHashValueSerializer(RedisSerializer.json());

        //让设置生效
        redisTemplate.afterPropertiesSet();

        //把改造好的遥控器交给spring管理
        return redisTemplate;
    }
}


```

- 给高频查询接口加上Redis缓存
- 缓存应该加在哪里？
- 加在service层，实现类里
- 因为service是业务逻辑层，最适合做缓存增强
- 由于controller只负责接受请求，service负责业务逻辑和数据查询。
- 缓存属于查询优化，属于业务逻辑，所有调用service的地方都能自动用上缓存，不需要更改多处

- 哪些接口需要加缓存，以 UserInfoServiceimpl 为例
- 根据id查询用户，查询所有用户，登录查询用户这三个是最频繁访问的，必须加缓存

- 加缓存的流程
```
1. 先查 Redis
2. Redis 有 → 直接返回（不查数据库）
3. Redis 没有 → 查 MySQL
4. 查到后 → 存入 Redis
5. 返回数据
```
- 开始改造，只需要改UserInfoServiceimpl
- 首先在service中注入创建好的RedisTemplate对象
```
@Resource
    private RedisTemplate<String,Object> redisTemplate;
```
- 缓存key前缀，统一管理
- 这是为了区分不同的角色的key不冲突
- 即用户有用户的key，企业有企业的key，都是使用key定位存储数据的
- 要是key意义不明，首先查看的时候就很痛苦，不知道这个数据是啥意思，其次对于项目开发，很多地方用到缓存时，key命名要是混乱极易冲突和重复
- 就相当于给数据放置一个自己命名的文件夹，user文件夹之类的
```
private static final String USER_KEY = "user:";
private static final String USER_LIST_KEY = "user:list";
private static final String USER_ACCOUNT_KEY = "user:account:";

```
- 给根据id查询用户加缓存
```
@Override
    public UserInfo getUserById(Long id){
        //拼接Redis Key
        String key = USER_KEY + id;

        //先查缓存
        UserInfo user = (UserInfo) redisTemplate.opsForValue().get(key);
        if(user != null){
            return user;  //命中缓存，直接返回
        }

        //缓存未命中，查数据库
        user = userInfoMapper.selectUserById(id);

        //查到了就存入Redis(10分钟过期)
        if(user != null){
            redisTemplate.opsForValue().set(key,user,600, TimeUnit.SECONDS);
        }
        return user;
    }
```
- 首先，这是存取字符串，先根据项目设置key
- 一般我们在Redis是 set username zcx  get username
- 现在在这里，我们要根据id查询，那么就把username换成user:1
- 即换一个key值的显示，其他的是一样的、
- 即拼接一下key    String key = USER_KEY + id;

- 核心：UserInfo user = (UserInfo) redisTemplate.opsForValue().get(key);
- 从Redis取数据
- redisTemplate是之前配置类造好的Redis操控工具
- .opsForValue()：ops = operation（操作），意思是我要操作String类型的数据，对应cmd中的set/get
- .get(key)：根据key去Redis中查数据，返回value
- (UserInfo)：强制类型转换，Redis存进去的是Object，取回来我们要转成UserInfo对象



- 核心：redisTemplate.opsForValue().set(key,user,600, TimeUnit.SECONDS);
- 向Redis存数据
- redisTemplate是之前配置类造好的Redis操控工具
- .opsForValue()：ops = operation（操作），意思是我要操作String类型的数据，对应cmd中的set/get
- .set(key,user,600, TimeUnit.SECONDS):往Redis中存数据
- 参数是key：就是之前拼接的key
- user：就是在MySQL中查询到的对象
- 600，TimeUnit.SECONDS：600秒后自动删除，相当于expire key 600
- 这就对应了取数据为什么能根据一个key能取到整个UserInfo对象，因为我存的就是一整个UserInfo对象


- 下面是查询所有用户和登录的修改后的代码，思路跟上述一致
```
@Override
    public List<UserInfo> getAllUsers(){
        String key = USER_LIST_KEY;

        //查缓存
        List<UserInfo> list = (List<UserInfo>) redisTemplate.opsForValue().get(key);
        if(list != null){
            return list;
        }

        //查数据库
        list = userInfoMapper.selectAllUsers();

        if(list != null && !list.isEmpty()){
            redisTemplate.opsForValue().set(key, list, 300, TimeUnit.SECONDS);
        }
        return list;
    }

    //个人用户登录方法，即查账号
    @Override
    public UserInfo getByAccount(String account, String password){
        String key = USER_ACCOUNT_KEY + account;

        // 查缓存
        UserInfo user = (UserInfo) redisTemplate.opsForValue().get(key);

        if(user != null){
            //缓存里有，直接校验密码
            if(user.getPassword().equals(password)){
                return user;
            }
            return null;
        }

        //缓存没有，查数据库

        user = userInfoMapper.selectByAccount(account);
        if (user == null) {
            return null;
        }
        // 密码不正确
        if (!user.getPassword().equals(password)) {
            return null;
        }
        
        // 登录成功，放入缓存（10分钟）
        redisTemplate.opsForValue().set(key, user, 600, TimeUnit.SECONDS);

        return user;
    }
```

- 重点：数据库和缓存必须一致，即数据库更新和删除数据时，缓存必须同步更新！！
- 即修改updateUser接口、deleteUser接口、addUser接口
```
@Override   //重写接口
    public int addUser(UserInfo userInfo){
        //新增用户，清空列表缓存
        int rows = userInfoMapper.insertUser(userInfo);
        if (rows > 0) {
            redisTemplate.delete(USER_LIST_KEY);
        }
        return rows;   //直接return就行是因为当前没有业务逻辑直接就是数据库操作
    }

    @Override
    public int deleteUser(Long id){
        //删除用户 删除缓存，因为登录时还存了account数据，但是这个方法没传入整体的对象
        //所以需要先查一遍，拿到用户信息，再把三个缓存都删了
        UserInfo user = userInfoMapper.selectUserById(id);

        int rows = userInfoMapper.deleteUserById(id);
        if (rows > 0 && user != null) {
            redisTemplate.delete(USER_KEY + id);
            redisTemplate.delete(USER_LIST_KEY);
            redisTemplate.delete(USER_ACCOUNT_KEY + user.getAccount());
        }
        return rows;
    }

    @Override
    public int updateUser(UserInfo userInfo){
        //修改用户时，删除该用户原先存储在Redis中的信息
        int rows = userInfoMapper.updateUser(userInfo);
        if(rows>0){
            //删除该用户的缓存
            String key = USER_KEY + userInfo.getId();
            redisTemplate.delete(key);

            //删除账号缓存
            redisTemplate.delete(USER_ACCOUNT_KEY + userInfo.getAccount());

            //删除用户列表缓存
            redisTemplate.delete(USER_LIST_KEY);
        }
        return rows;
    }

```

- 注意，如果终端控制台不打印类似于这样的输出，则证明缓存生效了
- 因为这样的输出证明用了MySQL执行SQL语句在MySQL中查询数据了
```
Preparing: select * from user_info where id=?
==> Parameters: 1(Long)
<==    Columns: id, account, username, email, password, is_vip
<==        Row: 1, 202300330000, 哈基延, 2517900254@qq.com, 1000, 1
<==      Total: 1

```

- 如果启动项目后，浏览器前端出现Whitelabel Error Page
- 这是常见的告诉我们服务器代码炸了
- 错误信息藏在IDEA控制台终端里
- 经典问题：
```
java.lang.ClassCastException: class java.util.LinkedHashMap 
cannot be cast to class 
com.zcx.talentrecruitmentsystem.entity.UserInfo
```
- 意思是：Redis取出来的数据是Map类型，不是之前传进去的UserInfo 对象
- 在service层中的强制类型转换失败了，所以代码炸了
- 这是因为存储的时候是UserInfo，但是取数据的时候Redis不知道要转成什么类型
- 所以Spring默认转成LinkedHashMap类型了，所以会报错

- 主要原因：
```
JacksonJsonRedisSerializer<Object> jsonSerializer = new JacksonJsonRedisSerializer<>(Object.class);
```
- 在最原先的这种写法，存储的是Object对象，这样取的时候Redis就不知道转成什么类型
- Redis拿到一串JSON，不知道要转成对应的对象类型，只能转成默认的类型：LinkedHashMap
- 所以代码炸了
- 报错：LinkedHashMap cannot be cast to UserInfo
- 而现在这种写法
```
redisTemplate.setValueSerializer(RedisSerializer.json());
```
- Spring 官方新版 RedisSerializer.json () 会自动记录对象类型！
- 所以不会报错，Redis知道要转成什么数据类型
- 所以service中也不用写强转了(之前写强转是因为配置类用的是原先的写法，结果直接炸了，所以就改成现在这样了)


- 像这种缓存炸了的，一定要打开cmd清理原先本地redis存储的错误的缓存
- 即打开cmd，输入flushdb
- 输出为OK，则清理成功

- 上述只是String数据结构的Redis
- 把一整个JSON中的数据用String存储
- 如果要对其中的数据的某一条修改
- 那就得这个整体的数据全删除再重新加入Redis

- 下面开始使用Hash数据结构，可以存储多个单独的字段，修改的话只需要修改对应的字段即可


- 查询简历：先从 Redis Hash 拿
- opsForHash() : 我要用 Hash 结构
- entries(key) : 把这个 Hash 所有字段一次性全部取出来
```
Map<Object,Object> resumeMap = redisTemplate.opsForHash().entries(key);
```

- 如果 Hash 里有数据 → 封装成 UserResume 返回
- 因为： Redis Hash 取出来是 Map，不是对象,所以必须一个一个封装加入，返回封装后的对象
```
if(!resumeMap.isEmpty()){
            UserResume userResume = new UserResume();
            userResume.setId(((Integer) resumeMap.get("id")).longValue());
            userResume.setUserId(((Integer) resumeMap.get("userId")).longValue());
            userResume.setGender((String) resumeMap.get("gender"));
            userResume.setIdCard((String) resumeMap.get("idCard"));
            userResume.setBirthDate(LocalDate.parse((String) resumeMap.get("birthDate")));
            userResume.setNation((String) resumeMap.get("nation"));
            userResume.setPoliticalStatus((String) resumeMap.get("politicalStatus"));
            userResume.setMaritalStatus((String) resumeMap.get("maritalStatus"));
            userResume.setNativePlace((String) resumeMap.get("nativePlace"));
            userResume.setCurrentCity((String) resumeMap.get("currentCity"));
            userResume.setHighestEducation((String) resumeMap.get("highestEducation"));
            userResume.setGraduateSchool((String) resumeMap.get("graduateSchool"));
            userResume.setDepartment((String) resumeMap.get("department"));
            userResume.setMajor((String) resumeMap.get("major"));
            userResume.setEducationType((String) resumeMap.get("educationType"));
            userResume.setSchoolSystem((String) resumeMap.get("schoolSystem"));
            userResume.setForeignLevel((String) resumeMap.get("foreignLevel"));
            userResume.setJobCity((String) resumeMap.get("jobCity"));
            userResume.setExpectedPosition((String) resumeMap.get("expectedPosition"));
            userResume.setSkills((String) resumeMap.get("skills"));
            userResume.setProjectExperience((String) resumeMap.get("projectExperience"));
            userResume.setSelfEvalution((String) resumeMap.get("selfEvalution"));
            return userResume;
        }
```

- 如果缓存没有 → 查询数据库
```
UserResume userResume = userResumeMapper.selectResumeByUserId(userId);
```
- 数据库查到 → 写入 Redis Hash
```
if(userResume!=null){
            //如果在数据库中查询到了，就需要把它加入到缓存中，用Hash
            Map<String, Object> map = new HashMap<>();
            map.put("id", userResume.getId());
            map.put("userId", userResume.getUserId());
            map.put("gender", userResume.getGender());
            map.put("idCard", userResume.getIdCard());
            map.put("birthDate", userResume.getBirthDate().toString());
            map.put("nation", userResume.getNation());
            map.put("politicalStatus", userResume.getPoliticalStatus());
            map.put("maritalStatus", userResume.getMaritalStatus());
            map.put("nativePlace", userResume.getNativePlace());
            map.put("currentCity", userResume.getCurrentCity());
            map.put("highestEducation", userResume.getHighestEducation());
            map.put("graduateSchool", userResume.getGraduateSchool());
            map.put("department", userResume.getDepartment());
            map.put("major", userResume.getMajor());
            map.put("educationType", userResume.getEducationType());
            map.put("schoolSystem", userResume.getSchoolSystem());
            map.put("foreignLevel", userResume.getForeignLevel());
            map.put("jobCity", userResume.getJobCity());
            map.put("expectedPosition", userResume.getExpectedPosition());
            map.put("skills", userResume.getSkills());
            map.put("projectExperience", userResume.getProjectExperience());
            map.put("selfEvalution", userResume.getSelfEvalution());

            redisTemplate.opsForHash().putAll(key,map);
        }
```
- Hash没有办法直接存储对象，必须拆成一个一个字段存储
- 所以需要把对象的每一个属性进行get然后往map里加，最后使用putAll一次性把整个map加入到redis中


- 修改简历，如果简历能在redis中查到（其实肯定有，因为每次查看都要加入缓存）
- 那么直接声明map
- 然后把传入的修改后的对象的各个属性进行获取，然后分别加入加入map
- 最后把map一整个加入到redis中
- 按照hashmap特性，put进去的相同key，key的value会被后续加入的覆盖，所以直接用putAll即可
```
String key = RESUME_HASH_KEY + userResume.getUserId();
            Map<String,Object> map = new HashMap<>();
            map.put("gender",userResume.getGender());
            map.put("skills", userResume.getSkills());
            map.put("graduateSchool", userResume.getGraduateSchool());
            map.put("birthDate", userResume.getBirthDate().toString());
            redisTemplate.opsForHash().putAll(key,map);
```
- 比如说这里就只获取了几条属性，只有修改这几条属性才会能成功显示在浏览器
- 因为其他属性没有被获取，然后整体的key和输出都已经存在redis中
- 那么其他的那些数据，就直接根据原先存在redis中的那些进行返回了
- 只有在这里的这些是能成功修改的
- 所以一般这里应该写全部的resume属性

- 在创建map的过程中，如果添加用Map.of()会有问题，只能允许最大10条数据添加
- 而我这个resume有超过10条的数据
- 就需要用到Map数据结构了，能存多少就多少



- 以上是Hash的数据结构，那么下面开始研究Redis的List结构

- List特点
  - 有序：元素保持插入顺序，可通过索引获取
  - 可重复：允许存储相同的元素
  - 底层是双向链表，左右两端操作极快
  - 适合：列表、流水记录、时序数据、消息队列
  - 比如在此项目中，用户岗位投递记录、留言列表、最新发布的岗位列表等

- 以用户投递岗位记录为例
- 由于本身代码底层不想改动太多mapper和SQL，所以每次投递成功后就重新查询该用户的所有投递记录，加入缓存
- 全量覆盖
- 修改状态成功后，直接删除之前的List，下次查询就是新的List加入了


- 用户投递岗位 -> 删除原先缓存 -> 重新查最新列表加入缓存
- 用户查询自己的投递记录 -> 优先查Redis，没有再查数据库
- 企业修改投递状态 -> 等待Redis缓存过期失效、在下一次用户查询时重新加入缓存



```
//用户查询投递记录列表  - 加入List缓存
    @Override
    public List<JobPostWithDeliveryVO> getJobPostByUserId(Long userId){
        String key = DELIVERY_LIST_KEY + userId;
        List<JobPostWithDeliveryVO> list = (List<JobPostWithDeliveryVO>) (List<?>)redisTemplate.opsForList().range(key,0,-1);

        if(list != null && !list.isEmpty()){
            return list;
        }

        list = deliveryRecordMapper.selectJobPostByUserId(userId);
        if(list != null && !list.isEmpty()){
            //把从数据库查询到的数据全部右插加入缓存
            redisTemplate.opsForList().rightPushAll(key,list.toArray());
            //设置缓存过期时间
            redisTemplate.expire(key,CACHE_EXPIPE, TimeUnit.MINUTES);
        }

        return list;
    }
    
    //真正的业务逻辑
    //只有企业用户才可以修改投递状态
    //企业修改投递状态后，把之前的用户投递记录缓存删除，下次查询自动重新构建新缓存
    //但是我的底层没有根据投递表的主键id查询用户ID的方法
    //所以正能等待缓存自动过期
    @Override
    public int udtDeliveryStatus(Long id,Integer status,String userType){
        if(userType==null || !userType.equals("enterprise")){
            return 0;
        }
        int rows = deliveryRecordMapper.updateDeliveryStatus(id,status);

        return rows;
    }
    
    //用户投递
    //用户新增投递  - 同步更新list缓存
    @Override
    public int addDelivery(Long userId, Long jobId) {
        int rows = deliveryRecordMapper.insertDelivery(userId, jobId);

        if(rows>0){
            String key = DELIVERY_LIST_KEY + userId;
            //删除旧缓存
            redisTemplate.delete(key);

            //查询最新列表
            List<JobPostWithDeliveryVO> newlist = deliveryRecordMapper.selectJobPostByUserId(userId);
            //重新写入缓存
            redisTemplate.opsForList().rightPushAll(key,newlist.toArray());
            redisTemplate.expire(key,CACHE_EXPIPE,TimeUnit.MINUTES);
        }
        return rows;
    }
    
```

- 相比于String和Hash，List也需要一个key
- 拼接key+userId
- 每个用户独立一个List，互不干扰
```
List<JobPostWithDeliveryVO> list = 
    (List<JobPostWithDeliveryVO>) (List<?>)redisTemplate.opsForList().range(key,0,-1);
```
- opsForList() = 我要操作 List 结构
- range(key, 0, -1)
- 0 = 从第 0 个元素开始
- -1 = 取到最后一个元素
- 作用：把整个 List 全部取出来

- 数据库查询后，批量右侧插入缓存
```
redisTemplate.opsForList().rightPushAll(key, list.toArray());
```
- rightPushAll是从右侧批量插入
- list.toArray()是把数组list存储了执行后的SQL返回值拆分成多个单独的对象
- 如果直接存list，就是把一大堆对象整体打包给缓存list
- 后续取数据的时候类型转换直接报错
- 用了.toArray()就是把一大包list拆成一个个单独的对象
- 因为缓存list底层是双向链表，所以只能一个一个对象添加，因为要管理左右指针

- 取数据的时候为什么有两次强制类型转换
```
List<JobPostWithDeliveryVO> list = (List<JobPostWithDeliveryVO>) (List<?>)redisTemplate.opsForList().range(key,0,-1);
```
- 由于缓存list是一个双向链表，不是数组
- 所以它没有直接给我整个列表的命令，只能用range来取
- 他的原生Redis List取数据命令只有LRANGE key 开始索引 结束索引
- LRANGE ： List Range（列表范围）
- 必须指定从哪里取到哪里
- 调用这个方法，返回的是一堆对象的列表：List<Object>
- 由于java语法规则，我如果想要得到具体的类对象不能从Object类型直接强转
- 必须先把Object类型先转成无泛型：List<?>
- 再把无泛型强转为我想要的类型：List<JobPostWithDeliveryVO>


- 综上，Redis的List数据结构实际上就是把多条String用双向链表存起来，排好顺序，维护前后指针
- 注意list内部没有存储索引，它纯是一点一点遍历查出来的












