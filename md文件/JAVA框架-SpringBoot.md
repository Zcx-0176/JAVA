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
- **@RequestMapping**是核心注解，**@RequestMapping("/hello")** 这样写之后，在浏览器中输入localhost:8080/hello，就会返回hello()方法的返回值，即"Hello World"
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
  1. 字符串（最常用）
  ```
  str: 我是字符串
  ```
  2. 数字
  ```
  age: 20
  money: 99.8
  ```
  3. 布尔值
  ```
  flag: true
  show: false
  ```
  4. 空值null
  ```
  empty: null
  ```
  5. 数组(List)
  ```
  写法一：短横杠
  hobby:
  - 游泳
  - 跑步
  - 编程

  写法二：行内
  hobby: [游泳,跑步,编程]
  ```
  6. 对象(Map)
  ```
  person:
    name: 李四
    age: 25
  ```
- **SpringBoot中yml最常用功能**
  1. 端口号配置
  ```
  server:
    port: 8080
  ```
  2. 自定义配置
  ```
  my:
    name: 小明
    age: 18
    message: "hello world"

  在代码中读取：
  @Value("${my.name}")
  private String name;
  ```
   3. 引用配置
  ```
  app:
    name: myapp
    desc: ${app.name}是一个SpringBoot项目
  ```
  - 把app.name替换为了myapp，最终的效果就是desc = "myapp是一个SpringBoot项目"
  4. 多环境切换
  - 因为SpringBoot最常用的一套环境隔离方案，开发、测试、生产用不同的配置
     - 主配置文件：application.yml
     - 开发环境：application-dev.yml
     - 生产环境：application-prod.yml
     - 测试环境：application-test.yml
     - 在主配置文件内切换环境：
     ```
      spring:
        profiles:
          active: dev  # dev=开发 / prod=生产 / test=测试

          写 dev → 自动加载 application-dev.yml
          写 prod → 自动加载 application-prod.yml
     ```

- **使用yml为实体类赋值**
- 首先在pojo包下创建实体类Dog和Person，并添加有参无参构造器，getter和setter方法，然后记得在类上方添加 **@Component注解** ，**这个注解负责把实例类对象添加到Spring容器中，即存进去**，**然后再test测试类那里，用@Autowired注解，声明private Dog dog;，即从容器中取对象给我的测试类用**
- **Component注解**：把一个普通 Java 类变成 Spring 容器管理的 Bean，Bean = 受 Spring 管理的对象，加了这个注解，Spring 启动时就会自动创建这个类的对象，存起来备用。如果不用这个注解你还得自己new一个，不方便管理
- **@Autowired注解**：把Spring容器中的对象取出来给我用
- 二者一个存一个取，缺一不可
- **@Value注解**：从配置文件（application.yml）里把值取出来，赋值给 Java 变量。当然也可以在@Component类里面使用@Value注解，把值赋给类成员变量，这样类对象创建出来以后，类成员变量的值就会有值了，只不过这种太麻烦，不便捷，一般是前者更好。
- **@ConfigurationProperties**：从配置文件（application.yml）里把值取出来，赋值给类成员变量。@ConfigurationProperties(prefix = "person")，即告诉SpringBoot，把配置文件中的person.*的值，赋给类成员变量
```
@Component   存对象
public class Dog {
    @Value("旺财")  直接给类成员变量赋值了
    private String name;
    @Value("3")    直接给类成员变量赋值了
    private Integer age;
    public Dog() {
    }
    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
@Component    存对象
@ConfigurationProperties(prefix = "person")  读取配置文件，
                          把配置文件中的person.*的值，赋给类成员变量
public class Person {

    private String name;
    private Integer age;
    private Boolean happy;
    private LocalDate birthday;;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
    public Person() {
    }
    public Person(String name, Integer age, Boolean happy, LocalDate birthday, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birthday = birthday;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

}
这是application.yml文件
server:
  port: 8080

person:      # 配置文件，存了person.*的值，给类成员变量赋值
  name: qiqi
  age: 18
  happy: true
  birthday: 1999-01-01
  maps:
    k1: v1
    k2: v2
  lists:
    - code
    - music
    - girl
  dog:
    name: 旺财
    age: 1

这是测试类
@SpringBootTest
class DemoHelloWorldApplicationTests {
    private Dog dog;   对类进行声明
    private Person person;   
                    该注解对应于@Component注解，是用来取对象的
    @Autowired    该注解写在测试类构造函数上，表示把对象全取了。这样就不用每一行声明上方都写这个注解了
    public DemoHelloWorldApplicationTests(Dog dog, Person person) {
        this.dog = dog;
        this.person = person;
    }
    @Test
    void contextLoads() {
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getHappy());
        System.out.println(person.getBirthday());
        System.out.println(person.getMaps());
        System.out.println(person.getLists());
        System.out.println(person.getDog().getName());
        System.out.println(person.getDog().getAge());
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
    }
}

输出为：
qiqi
18
true
1999-01-01
{k1=v1, k2=v2}
[code, music, girl]
旺财
1
旺财
3

注意如果输出为null，要么是yml配置文件中，变量名没有跟实体类的属性对应一致，
要么是实体类没有加@Component注解，
要么是缺少getter和setter方法
```
- |     | @ConfigurationProperties | @Component |
  | :--: | :----------------------: | :--------: |
  | 功能 | 批量注入配置文件属性     | 单个注入   |
  | 松散绑定(松散语法) | 支持 | 不支持 |
  | Spel| 不支持 | 支持 |
  | JSR303数据校验 | 支持 | 不支持 |
  | 复杂类型封装 | 支持 | 不支持 |

- **松散绑定**：**yml 里的配置名，和 Java 类里的属性名，不用写得一模一样，Spring 也能自动匹配。即==大小写不敏感，下划线不敏感，短横线不敏感==。这几种情况是可以匹配上的**
```
如java类里写
private String userName;

那么在 yml 里 全都能自动匹配成功：
user_name
user-name  企业命名风格，最常用短横线
userName  标准一模一样的
username
USER_NAME
```
- **JSR303数据校验**：**是Java 的一套【数据校验标准】，作用是给前端传过来的数据 / 配置文件的数据 做合法性检查**
- **使用JSR303数据校验**：**在实体类上加 @Validated 注解开启JSR303校验，在属性上加上JSR303对应的需要的注解，就可以实现数据校验了，注解如下**
- **不过你需要在pom.xml里引入JSR303依赖，把下面的整个加进去，再刷新Maven依赖，就可以导入下面表格中的各种注解了**
```
<!-- JSR303 数据校验核心依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
- | 注解 | 作用 |
  | :--: | :--: |
  | @Validated | 开启 JSR303 校验 |
  | @NotBlank | 字符串不能为空，不能全为空格 |
  | @NotEmpty | 集合、数组、字符串不能为空 |
  | @NotNull | 不能为 null |
  | @Email | 必须是邮箱格式 |
  | @Positive | 必须是正数 |
  | @Negative | 负数 |
  | @Size | 长度必须在指定范围内 |
  | @Min | 最小值 |
  | @Max | 最大值 |
  | @Pattern | 正则校验 |
- 比如：
年龄必须是正数
名字不能为空
邮箱格式必须正确
手机号必须 11 位
这些校验，JSR303 用注解就能搞定
- 示例：
```
@Component
@ConfigurationProperties(prefix = "person")
@Validated  // 开启 JSR303 校验（关键！）
public class Person {

    @NotBlank(message = "名字不能为空！")  // 名字不能为空
    private String name;

    @Positive(message = "年龄必须大于0！") // 年龄必须正数
    private Integer age;

    @Email(message = "邮箱格式不正确！")   // 必须是邮箱格式
    private String email;
}

```

- **多环境配置及配置文件位置**
- **yml配置文件能放在项目(demo_hello_world)里面的四个位置**
- **config文件夹需要自己创建**
- **高优先级的配置文件的配置会覆盖优先级低的**
  1. 最高优先级：项目根目录下的 config 文件夹
  ```
  E:\java-workplace\SpringBoot\demo_hello_world\config\application.yml
  ```
  2. 第二优先级：项目根目录
  ```
  E:\java-workplace\SpringBoot\demo_hello_world\application.yml
  ```
  3. 第三优先级：resources 下的 config 文件夹
  ```
  E:\java-workplace\SpringBoot\demo_hello_world\src\main\resources\config\application.yml
  ```
  4. 最低优先级：resources 根目录（默认的位置）
  ```
  E:\java-workplace\SpringBoot\demo_hello_world\src\main\resources\application.yml
  ```
- **一定要在工作目录是你的项目这种情况下运行，如果根目录是文件夹的话，文件夹里面包含了你的项目，那么工作目录就是你的文件夹，如果按照上述的方式放置配置文件，那么运行时，按照上述方法创建的项目根目录下的config文件夹和项目根目录的application.yml文件，就读取不到了**
- **多环境配置**：在项目实际开发中，我们往往需要针对不同的环境进行不同的配置，比如开发环境、测试环境、生产环境等等，这时就需要用到多环境配置了
- **可以创建如下几个配置文件**
```
application.yml → 主配置（用来切换环境）
application-dev.yml → 开发环境（你自己用）
application-test.yml → 测试环境
application-prod.yml → 线上环境
```
- **在 application.yml 中可以写切换环境的代码,==注意：不管放在哪个优先级的主配置文件，都可以生效，他不参与优先级的覆盖==**
```
spring:
  profiles:
    active: dev   # 这里写 dev / test / prod 就能切换
```
- **如果没有在主配置环境中写上面的切换代码，那么程序会加载默认环境，即主配置文件的环境**

## 七、SpringBoot Web开发

#### 1. **导入静态资源**
- 静态资源有：**HTML、CSS、JS、图片等**
- **静态资源存放的位置**：**==全部放在src/main/resources/下面==**，优先级从高到低，如果在不同文件下有同名的资源，优先级高的会覆盖优先级低的
  - **resources/META-INF/resources**，几乎不用，因为是给打包成 jar 包的第三方依赖用的
  - **resources/resources/**，很少用
  - **resources/static/** 最为常用，企业默认
  - **resources/public/**
- **如何访问静态资源**：把静态资源放在这些文件夹下，然后从主程序启动，然后再浏览器输入localhost:8080/静态资源路径即可。8080是默认端口，可以自己修改。如localhost:8080/index.html，或者localhost:8080/css/style.css。不需要加static或者public之类的，因为SpringBoot已经自动配置了去这些文件夹找静态资源了。

#### 2. **如何定制首页**
 1. **纯静态首页，优先级低**
  - 找到**static**文件夹，在其中新建**index.html**，名字必须一模一样，然后在这个文件中写页面内容(前端知识)，然后启动项目，直接访问**localhost:8080**，就可以直接显示首页了，当然8080是默认端口
2. **动态首页(用 @Controller 返回页面，优先级更高)**
  - **可以通过控制器跳转到首页，动态页面可以访问后端传进来的数据，并且必须由@Controller注解跳转**
  - **templates** 文件夹，存放动态页面，优先级低于静态资源
  - **当然，要是放在templates文件夹下的页面，那么需要使用Thymeleaf模板引擎才可访问**
  - **使用 Thymeleaf 模板引擎**
  ```
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
  ```
  - **示例**
  ```
  这是在Controller中写一个方法，返回index.html
  @Controller
  public class Indexcontroller {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
   }
  跟静态资源一样，SpringBoot会自动去 templates 文件夹下寻找页面，然后返回给用户，访问路径一样
  templates目录下专门存放动态页面
  ```

#### 3. **模版引擎**
- **模版引擎让HTML界面能看懂JAVA后端传过来的数据**
- **最经典的模版引擎：Thymeleaf，加入如下依赖即可使用**
- 不过现在都是前后端分离了，所以这个模版引擎用处不大了
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
- 示例：
```
<!DOCTYPE html>
<html lang="zh" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>首页</title>
</head>
<body>
    <h1>欢迎你，[[${username}]]</h1>
</body>
</html>

这里的[[${username}]]几乎是后端传过来的数据
后端通过如下形式传给前端
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        // 给页面传数据
        model.addAttribute("username", "张三");
        return "index"; // 去找 templates/index.html
    }
}
```
#### 4. **SpringMVC**
- **SpringMVC是Spring 用来做 Web 开发的框架，写接口、接收请求、返回数据。SpringBoot自动配置好了SpringMVC的工具**
- **@RestController、@GetMapping、@PostMapping**：SpringMVC的注解
- **MVC是一种代码分层思想，把程序分成3个部分**
  - **Model：数据模型，封装数据，比如用户名、密码**
  - **View：视图，页面，比如HTML**
  - **Controller：控制器，处理请求，比如接收用户名、密码，然后把数据传递给Model，然后把Model的数据传递给View，View再把数据展示给用户**
- SpringMVC就是把上述三层串起来的框架
- 我们现在写的接口都是SpringMVC实现的。SpringMVC是做Web的框架
- **SpringMVC的核心组件**
  - DispatcherServlet（核心控制器）：总指挥。所有请求先到它这里，它再分发到对应的 Controller
  - @Controller / @RestController：请求处理器，写接口的类
  - @RequestMapping / @GetMapping：请求路径绑定，网址映射
  - View / JSON：返回结果，页面或者数据
- **SpringMVC的流程**
  - 用户发送请求，DispatcherServlet 总管
  - 核心找映射，找到 @GetMapping ("/hello")
  - 找到对应的 Controller，执行方法hello ()，返回结果
  - DispatcherServlet 把结果返回给浏览器
- **扩展SpringMVC**
- 在不破坏SpringBoot自动配置的前提下，自己添加新功能，比如：加拦截器(登录校验)，加跨域支持，加自定义页面跳转，加静态资源映射。只不过不替换原来的配置，而是**扩展**
- **SpringMVC如何扩展**
```
@Configuration  // 告诉 Spring：这是配置类
public class MyMvcConfig implements WebMvcConfigurer {

    // 你想加什么功能，就重写什么方法
    // 例1：加跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // ... 跨域配置
    }

    // 例2：加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // ... 拦截器配置
    }
}
```
- **SpringMVC扩展的文件应放在src/main/java/com.example.demo0/config下，这个config需要自己创建，这个config文件夹跟你创建的controller文件夹在一个目录下**
- 绝对不能用EnableWebMvc注解，这个注解会替换掉SpringBoot自动配置的SpringMVC，导致SpringBoot配好的SpringMVC无法使用

## 八、员工管理系统
- 实现简单的员工管理系统，目的是熟悉上述知识。
- **第0步：创建项目，勾选依赖**：Spring Web、Spring Data JPA、MySQL Driver、Thymeleaf、Lombok、Spring Security、Validation等
- | 依赖分类 | 依赖名称 | 作用 |
  | --- | --- | --- |
  |Web|Spring Web|提供 RESTful API、Web MVC 功能，是 Web 项目的基础|
  |SQL|Spring Data JPA|简化数据库操作，实现 ORM 映射和 CRUD|
  |SQL|MySQL Driver|连接 MySQL 数据库的驱动（如果用其他数据库，选对应驱动）|
  |Template Engines|Thymeleaf|模板引擎，用于生成 HTML 页面|
  |Developer Tools|Lombok|简化 Java 代码，如自动生成 Getter、Setter、构造函数|
  |Developer Tools|Spring Boot DevTools|热重载，修改代码后自动重启，提升开发速度|
  |Security|Spring Security|提供安全功能，如用户认证、授权|
  |IO|Validation|数据验证，如数据校验、数据格式化|
- **第一步：准备工作**：
- 可以在resources下创建banner.txt，自定义启动时的欢迎界面
- 在resources下创建application.yml，配置数据库连接信息
- **第二步：创建各层级**
- **数据库层设计(Entity实体类+Repository接口)**
  - 先在com.example.employeemanagementsystem目录下创建entity包和repository包
  - 在entity包下创建User.java类和Employee.java类
  - 定义User实体类，映射数据库employee数据库中的user表，存储用户名和密码
  - 定义Employee实体类，映射数据库employee数据库中的employee表，存储员工信息
  - 在repository包下创建UserRepository.java接口和EmployeeRepository.java接口，继承JpaRepository接口，实现数据库CRUD操作
- **配置层(config包)**
  - 在config包下创建
  - SecurityConfig类，配置自己的认证逻辑，配置 SecurityFilterChain，定义哪些 URL 需要认证、哪些可以匿名访问。指定自定义登录页面 /login，登录成功后跳转至首页 /。配置密码编码器（开发环境用 NoOpPasswordEncoder，生产需更换为 BCryptPasswordEncoder）。
- **业务层(service包)**
  - 在service包下创建
  - UserDetailsServiceImpl.java类，实现SpringBoot提供的UserDetailsService接口，用于用户认证登录。成员变量是UserRepository接口的类型，重写loadUserByUsername方法，根据用户名查询数据库(通过UserRepository接口中自带的方法)，返回用户信息
- **控制层(controller包)**
  - 在controller包下创建
  - LoginController：处理 /login 请求，返回登录页面。
  - IndexController：处理 / 请求，返回登录成功后的首页。
  - EmployeeController：处理员工相关请求，如员工列表、员工添加、员工编辑、员工删除。
- **视图层(templates目录)**
  - login.html：登录表单页面，提交用户名和密码到 /login 接口。
  - index.html：首页，展示系统功能入口。
  - 在templates目录下创建list.html，展示员工列表
  - 在templates目录下创建add.html，展示添加员工页面
  - 在templates目录下创建edit.html，展示编辑员工页面
- **在DBeaver中，可以点击SQL编辑器，选择新建SQL编辑器，输入SQL语句，执行SQL语句，就可填入数据，如INSERT INTO `employee_db`.`user` (username, password) VALUES ('1111', '1234567');刷新user表，查看数据**
- 启动后，访问localhost:8080，会自动跳转到登录页面，输入在MySQL中填入的用户名1111和密码1234567，登录成功后，会自动跳转到首页，点击查看列表即可进入员工列表页面，然后可点击添加员工按钮、编辑按钮和删除按钮，进行增删改查操作

## 九、JDBC
- **JDBC**:**Java Database Connectivity**，即Java 官方提供的一套接口规范，让 Java 程序能连接数据库、执行 SQL、操作数据。
- 所有java操作数据库的框架，底层都是JDBC
- **核心思想**：JDBC本身是**一套接口，即java.sql 包下的一堆类（Connection、Statement、ResultSet 等）**，没有实现类，
- 实现类由各个数据库厂商提供，叫**数据库驱动（Driver）**

- **核心对象**
  - **DriverManager**:加载驱动，获取数据库连接
  - **Connection**：数据库连接对象，负责创建语句，管理事务
  - **Statement**：执行 SQL 语句，返回结果集，但是有SQL注入风险
  - **PreparedStatement**：执行 SQL 语句，返回结果集，防注入、效率高，企业必用
  - **ResultSet**：结果集对象，封装了查询结果
- **标准执行步骤**：加载驱动，获取连接Connection，获取PreparedStatement，执行SQL，处理ResultSet，关闭连接
- **Statement vs PreparedStatement**：Statement：直接拼接 SQL，有注入风险，不预编译。PreparedStatement：预编译 SQL，使用？占位符，防注入，重复执行效率高。
- **执行方法**：executeQuery()：执行查询语句（SELECT），返回 ResultSet。executeUpdate()：执行增删改（INSERT/UPDATE/DELETE），返回受影响行数。
- **JDBC事务**：JDBC默认自动提交事务(执行一次SQL就提交一次)
- **连接池**：原生JDBC频繁创建和销毁连接，性能极差，故常用Druid连接池，或者SpringBoot默认的HikariCP连接池
- 如下是普通java项目，使用JDBC操作数据库，需要在项目根目录下创建lib文件夹，将mysql-connector-java-8.0.23.jar复制到lib文件夹下，并右键这个jar包，选择Add to Classpath，这样lib下的所有jar包都会被添加到项目依赖中
```
import java.sql.*;

public class JdbcUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    //加载驱动
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    //关闭资源
    public static void  close(ResultSet rs,Statement stmt,Connection conn){
        try{
            if(rs!=null) rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(stmt!=null) stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null) conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//增删改查完整测试类
//C ： 创建create
//R ： 读取read
//U ： 修改update
//D ： 删除delete
public class JdbcCRUD {
    public static void add(String name,int age,String address){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into user(name,age,address) values(?,?,?)";
        //?是占位符，表示 SQL 语句中的参数，参数的值会通过 set 方法设置
        try{
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql); //通过数据库连接对象 conn 调用 prepareStatement(sql) 方法，将 SQL 语句预编译并创建 PreparedStatement 对象 pstmt
            pstmt.setString(1,name); //把传入的name的值赋给 SQL 语句中的第一个参数?
            pstmt.setInt(2,age);  //把传入的age的值赋给 SQL 语句中的第二个参数?
            pstmt.setString(3,address);  //把传入的address的值赋给 SQL 语句中的第三个参数?
            int rows = pstmt.executeUpdate();  //执行 SQL 语句，返回受 SQL 语句影响的行数
            System.out.println("新增成功，影响行数："+ rows);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null,pstmt,conn);
        }
    }
    //根据id查询
    public static void findById(int id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from user where id=?";
        try{
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();  //执行 SQL 查询语句，返回结果集 rs
            if(rs.next()){   //将游标移动到结果集的第一行，如果存在数据则返回 true，用于判断查询结果是否为空
                System.out.println("id:" + rs.getInt("id")
                    + " name:" + rs.getString("name")
                    + " age:" + rs.getInt("age")
                    + " address:" + rs.getString("address"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs,pstmt,conn);
        }
    }
    //修改
    public static void update(int id,String name){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update user set name=? where id=?";
        try{
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            int rows = pstmt.executeUpdate();
            System.out.println("修改成功，影响行数："+ rows);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null,pstmt,conn);
        }
    }
    //删除
    public static void delete(int id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from user where id=?";
        try{
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int rows = pstmt.executeUpdate();
            System.out.println("删除成功，影响行数："+ rows);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(null,pstmt,conn);
        }
    }
    //事务演示
    /*
    这段代码演示了数据库事务操作：
        获取数据库连接并关闭自动提交
        准备两条 SQL 语句：id=1 的用户年龄减 1，id=2 的用户年龄加 1
        依次执行两条更新语句
        如果都成功执行，则提交事务
        如果发生异常，事务会自动回滚，保证数据的原子性和一致性
     */
    public static void transaction(){
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try{
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false); //关闭自动提交
            String sql1 = "update user set age=age-1 where id=1";
            String sql2 = "update user set age=age+1 where id=2";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.executeUpdate();
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.executeUpdate();

            conn.commit();
            System.out.println("事务提交成功");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(null,pstmt1,null);
            JdbcUtil.close(null,pstmt2,conn);
        }
    }
    //测试
    public static void main(String[] args) {
        add("张三", 18, "北京");
        findById(1);
        add("李四", 19, "上海");
        add("王五", 20, "广州");
        findById(2);
        update(1,"张三冯");
        delete(3);
        transaction();
    }
}
```
- **SpringBoot对JDBC的封装**
- |层级|作用|核心组件|
  |:---:|:---:|:---:|
  |连接管理层|替代原生 DriverManager，用连接池复用连接，避免频繁创建销毁|DataSource（数据源接口）|
  |模板工具层|封装资源获取 / 释放、异常处理，让开发者只关注 SQ|JdbcTemplate|
  |ORM 框架层|进一步封装，用对象操作替代手写 SQL|MyBatis / MyBatis-Plus / JPA|
- **核心组件：DataSource数据源**
- javax.sql.DataSource 是 Java 标准接口，负责管理数据库连接，是连接池的统一入口。
- 对比原生JDBC，原生每次请求都要新建连接，用完再销毁。而SpringBoot从连接池借连接，连接复用，默认用连接池HikariCP
- **核心工具：JdbcTemplate**
- JdbcTemplate 是 SpringBoot 封装的轻量级 JDBC 工具类，简化了 JDBC 的操作，提供了一系列方法，简化了数据库操作。自动获取连接，释放连接，处理异常，简化结果集映射
- 核心方法：
- |方法|作用|
  |:---:|:---:|
  |update(String sql, Object... args)|执行 INSERT、UPDATE、DELETE 语句，返回影响的行数|
  |query(String sql, Object... args)|执行 SELECT 语句，返回结果集|
  |queryForObject(String sql, Object... args)|执行 SELECT 语句，返回单个结果，即单行单列/单行多列|
  |batchUpdate(String sql, Object[][] args)|执行批量 INSERT、UPDATE、DELETE 语句，返回影响的行数|
- **SpringBoot默认连接池：HikariCP**
- HikariCP 是 SpringBoot 默认的连接池，性能高、配置简单、线程安全，开箱即用，几乎不需要额外配置
- **基础使用：零代码、仅需配置**
  - **引入依赖**
  ```
  <!-- 引入这个依赖 -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
  <!-- 或者引入这个依赖 -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
  ```
  - **配置application.yml**
  ```
  spring:
  datasource:
    url: jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
    # HikariCP 核心配置（可选，默认值已足够优秀）
    hikari:
      minimum-idle: 5          # 最小空闲连接数
      maximum-pool-size: 20    # 最大连接数
      idle-timeout: 30000      # 空闲连接超时时间（ms）
      pool-name: HikariCP      # 连接池名称
      max-lifetime: 1800000    # 连接最大生命周期（ms）
      connection-timeout: 30000 # 连接超时时间（ms）
  ```
- **使用JdbcTemplate操作数据库**
```
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Spring 自动注入 DataSource 并初始化 JdbcTemplate
    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 新增
    public int add(String name, int age, String address) {
        String sql = "INSERT INTO user(name, age, address) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, name, age, address);
    }

    // 根据ID查询
    public User findById(int id) {
        String sql = "SELECT id, name, age, address FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setAddress(rs.getString("address"));
            return user;
        }, id);
    }
}
```
- **SpringBoot对Druid连接池的整合**
- **引入依赖**
  ```
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
  </dependency>
  <dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
  </dependency>
  <!-- Druid 连接池 -->
  <!-- 替换成这个，支持 SpringBoot 3.x / 4.x -->
  <dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-3-starter</artifactId>
    <version>1.2.20</version>
  </dependency>
  ```
 - **配置application.yml**
 ```
 spring:
  datasource:
    url: jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource # 指定 Druid 数据源
    druid:
      # 连接池配置
      initial-size: 5        # 初始化连接数
      min-idle: 5            # 最小空闲连接数
      max-active: 20         # 最大连接数
      max-wait: 60000        # 获取连接最大等待时间（ms）
      time-between-eviction-runs-millis: 60000   # 空闲连接检测间隔
      min-evictable-idle-time-millis: 300000     # 连接最小空闲时间
      validation-query: SELECT 1 FROM DUAL      # 验证连接有效性的 SQL
      test-while-idle: true      # 空闲时检测连接有效性
      test-on-borrow: false      # 借用连接时不检测（提升性能）
      test-on-return: false      # 归还连接时不检测
      pool-prepared-statements: true # 开启 PSCache
      max-pool-prepared-statement-per-connection-size: 20
      # 监控配置
      filters: stat,wall,log4j2 # 开启统计、防注入、日志过滤
      web-stat-filter:
        enabled: true           # 开启 Web 监控
        url-pattern: /*
        exclusions: "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"
      stat-view-servlet:
        enabled: true           # 开启监控页面
        url-pattern: /druid/*
        allow: 127.0.0.1       # 仅允许本地访问
        login-username: admin  # 监控页面登录账号
        login-password: 123456 # 监控页面登录密码
 ```
 - **使用JdbcTemplate操作数据库**：跟HikariCP那个代码操作完全一样，JdbcTemplate会自动使用Druid连接池
 - **访问Druid监控页面**：localhost:8080/druid，输入配置的 login-username 和 login-password，即可查看连接池实时状态，SQL 执行统计（慢查询、执行次数），Web 请求监控，Spring 监控等
 - **但是遗憾的是我电脑上的IDEA不兼容Druid，所以只能用HikariCP了，但是HikariCP的配置比Druid简单很多，所以还是推荐HikariCP**


## 十、MyBatis
- **MyBatis是一款半自动ORM(Object Relational Mapping)框架，即对象↔ 关系型数据库 自动映射，半自动=SQL自己写，映射帮你做**
- 做的事情：
  - 管理数据库连接
  - 执行SQL
  - 把ResultSet自动封装成java对象
- **核心结构**
```
请求 → Controller → Service → Mapper（接口）→ Mapper XML(写SQL) → MyBatis 引擎 → 数据库
```
- **核心四部分**：
  - **实体类Entity**：对应表结构
  - **Mapper接口**：定义方法，方法名对应SQL语句ID，参数和返回值对应SQL参数和结果集
  - **Mapper XML**：写真正的SQL语句，使用SQL语句ID和Mapper接口对应
  - **配置文件**：指定mapper位置、数据源
- 对于JPA，不用写SQL，但是复杂查询SQL不可控。对于MyBatis，简单复杂的SQL都需要自己写，极度灵活，但在重复简单SQL时，代码冗余。MyBatis-Plus，兼顾JPA的方便和、MyBatis的灵活性，即简单SQL语句不用写，复杂的自己手写
- **MyBatis执行流程**：加载核心配置文件(mybatis-config.xml或application.yml)，构建SqlSessionFactory，创建SqlSession，SqlSession执行Mapper接口方法，找到XML中对应的SQL语句，执行SQL，结果自动映射为java对象，关闭资源。

- **使用MyBatis实现员工管理系统**
  - **实体类**:在entity包下创建Employee.java,用于操作数据库表
  ```
  /**
   * 员工实体类
  **/
  //效果：创建该实体类对应的数据库表，数据库表名称小写
  @Data   //作用：自动生成getter/setter，toString、equals、hashCode 等方法方法
  @NoArgsConstructor    //无参构造方法
  @AllArgsConstructor   //全参构造方法
  public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
  }
  ```
  - **在service包下创建EmployeeService.java**，用于封装Mapper接口方法
  ```
  @Service
  public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    //注入Mapper
    public EmployeeService(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }
    public List<Employee> findAll(){
        return employeeMapper.findAll();
    }
    public Employee findById(Integer id){
        return employeeMapper.findById(id);
    }
    public void add(Employee employee){
        employeeMapper.insert(employee);
    }
    public void update(Employee employee){
        employeeMapper.update(employee);
    }
    public void delete(Integer id){
        employeeMapper.delete(id);
    }
  }
  ```
  - **Mapper接口**:在mapper包下创建EmployeeMapper.java接口，用于定义方法
  ```
  @Mapper
  public interface EmployeeMapper {
    //查询全部
    List<Employee> findAll();
    //根据id查询
    Employee findById(Integer id);
    //添加
    int insert(Employee employee);
    //修改
    int update(Employee employee);
    //删除
    int delete(Integer id);
  }
  ```
  - **Mapper XML**:在resources文件夹下创建mapper包，在其下创建EmployeeMapper.xml文件，用于定义SQL语句，对应Mapper接口的方法
  ```
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

  <!-- namespace 必须对应 Mapper 接口全类名 -->
  <mapper namespace="com.example.emsmybatis.mapper.EmployeeMapper">

    <!-- 查询所有 -->
    <select id="findAll" resultType="com.example.emsmybatis.entity.Employee">
        select * from employee
    </select>

    <!-- 根据ID查询 -->
    <select id="findById" resultType="com.example.emsmybatis.entity.Employee" parameterType="int">
        select * from employee where id = #{id}
    </select>

    <!-- 新增 -->
    <insert id="insert" parameterType="com.example.emsmybatis.entity.Employee">
        insert into employee(name, age, email)
        values(#{name}, #{age}, #{email})
    </insert>

    <!-- 修改 -->
    <update id="update" parameterType="com.example.emsmybatis.entity.Employee">
        update employee
        set name=#{name}, age=#{age}, email=#{email}
        where id=#{id}
    </update>

    <!-- 删除 -->
    <delete id="delete" parameterType="int">
        delete from employee where id=#{id}
    </delete>
    </mapper>
  ```
  - **在配置文件application.yml中添加MyBatis配置**，用于配置数据源和MyBatis
  ```
  spring:
  datasource:
    url: jdbc:mysql://localhost:3306/employee_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver

  # MyBatis 配置
  mybatis:
    #  mapper XML 文件位置
    mapper-locations: classpath:mapper/*.xml

    #  开启驼峰命名自动映射（数据库 a_column → Java aColumn）
    configuration:
      map-underscore-to-camel-case: true
      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl  # 打印SQL
  ```
  - **pom.xml中添加MyBatis依赖和MySQL驱动**
  - 如果pom.xml中添加了security依赖，则需要添加如下配置：
  - **创建config包，创建SecurityConfig.java类**，用于登录的操作
  ```
  @Configuration
  @EnableWebSecurity
  public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                //用 SpringSecurity 自带登录页，不用自己写
                .formLogin(form -> form
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // 账号：1111   密码：1234567
    进行登录
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("1111")
                .password(passwordEncoder().encode("1234567"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
  }
  ```
  - **登录界面验证成功后，就需要写EmployeeController.java来跳转到对应的界面，和IndexController.java跳转到首页。并且需要在resources下的templates文件夹下创建相应的界面.html**
  - **创建controller包，创建EmployeeController.java类**，用于跳转到各个界面
  ```
  @Controller
  @RequestMapping("/employee")
  public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Employee> emps = employeeService.findAll();
        model.addAttribute("emps", emps);
        return "list";
    }

    @GetMapping("/addPage")
    public String addPage(){
        return "add";
    }

    @PostMapping("/add")
    public String add(Employee employee){
        employeeService.add(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        Employee emp = employeeService.findById(id);
        model.addAttribute("emp", emp);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
  }
  ```
  - **创建controller包，创建IndexController.java类**
  - 这是直接跳转到员工列表页面了
  ```
  @Controller
  public class IndexController {
    @GetMapping("/")
    public String index(){
        return "redirect:/employee/list";
    }
  }
  ```
  - **在templates文件夹，创建list.html、add.html、detail.html文件，因为在EmployeeController.java类中已经写过了跳转页面的逻辑，所以这里要有跳转的各个页面**
  ```
  # add.html:
  <!DOCTYPE html>
  <html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <title>添加员工</title>
  </head>
  <body>
  <h1>添加员工</h1>
  <form action="/employee/add" method="post">
    姓名：<input name="name"><br>
    年龄：<input name="age"><br>
    邮箱：<input name="email"><br>
    <button type="submit">提交</button>
  </form>
  </body>
  </html>

  # detail.html:
    <!DOCTYPE html>
    <html lang="zh-CN">
    <head>
        <meta charset="UTF-8">
        <title>员工详情</title>
    </head>
    <body>
    <h1>员工详情</h1>
    <hr>

    <h3>ID：[[${emp.id}]]</h3>
    <h3>姓名：[[${emp.name}]]</h3>
    <h3>年龄：[[${emp.age}]]</h3>
    <h3>邮箱：[[${emp.email}]]</h3>

    <br><br>
    <a href="/employee/list">← 返回列表</a>
    </body>
    </html>

  # list.html:
  <!DOCTYPE html>
  <html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <title>员工列表</title>
  </head>
  <body>
  <h1>员工列表</h1>
  <table border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <tr th:each="emp : ${emps}">
        <td th:text="${emp.id}"></td>
        <td th:text="${emp.name}"></td>
        <td th:text="${emp.age}"></td>
        <td th:text="${emp.email}"></td>
        <td>
             <!-- 👇 查看详情按钮（跳转到详情页） -->
            <a th:href="@{/employee/detail/{id}(id=${emp.id})}">查看详情</a>
            <!-- 👇 删除按钮（删除员工） -->
            <a th:href="@{/employee/delete/{id}(id=${emp.id})}">删除</a>
        </td>
    </tr>
  </table>
  <br>
  <a href="/employee/addPage">去添加员工</a>
  </body>
  </html>
  ```
- **注意：**
  - **==XML 的 namespace 必须等于 Mapper 接口的全类名==**
  - 作用：告诉 MyBatis 这个 XML 是和哪个接口绑定的，写错会导致找不到 Mapper，启动报错
  ```
  <mapper namespace="com.example.emsmybatis.mapper.EmployeeMapper">
  ```
  - **==XML 的 id 必须等于 Mapper 接口方法名==**
  - MyBatis 会根据方法名，找到 XML 中 id 相同的 SQL 语句执行。不一致会报 StatementNotFoundException
  ```
  // Mapper 接口方法
  List<Employee> findAll();

  <!-- XML 中对应 SQL 的 id 必须和方法名完全一致 -->
  <select id="findAll" resultType="com.example.emsmybatis.entity.Employee">
    select * from employee
  </select>
  ```
  - **==参数传递用 #{}，安全防 SQL 注入==**
  - #{id} 会被 MyBatis 处理为 PreparedStatement 的占位符 ?，预编译执行。**==绝对不要用 ${}，它是字符串拼接，会导致 SQL 注入漏洞==**
  ```
  <select id="findById" resultType="com.example.emsmybatis.entity.Employee">
    select * from employee where id = #{id}
  </select>
  ```
- **动态SQL**
- **根据不同的条件，自动拼接不同的SQL。**如只传姓名->按姓名查，只传年龄->按年龄查，姓名和年龄都传->按姓名和年龄查，都不传送->查所有。不用在 Java 里拼字符串，MyBatis 帮你智能拼接
- **==动态SQL五大核心标签**
  - **< if >:判断条件**
  - 作用：满足条件就拼接SQL，不满足就不拼
  - 语法：
  ```
    <if test="条件">
        要拼接的 SQL
    </if>
    
    如按姓名+年龄模糊查询
    <select id="findByCondition" resultType="Employee">
        select * from employee
        where 1=1  <!-- 用来占位，保证语法正确 -->
        <if test="name != null and name != ''">
        and name like concat('%', #{name}, '%')
        </if>
        <if test="age != null">
        and age = #{age}
        </if>
    </select>
  ```
  - **< where >**:自动优化where条件
  - 作用：自动去掉多于的and/or，没有条件时，自动去掉where关键字
  ```
    <select id="findByCondition" resultType="Employee">
        select * from employee
        <where>
            <if test="name != null and name != ''">
                and name like concat('%', #{name}, '%')
            </if>
            <if test="age != null">
                and age = #{age}
            </if>
        </where>
    </select>
    效果：
    没传任何条件 → select * from employee
    只传年龄 → select * from employee where age = ?
    都传 → select * from employee where name like ? and age = ?
    自动处理and
  ```
  - **< set >**:专门用于动态更新
  - 作用：修改时只更新有值的字段，没传的字段不修改
  ```
  动态更新员工
    <update id="updateDynamic">
        update employee
        <set>
            <if test="name != null">name = #{name},</if>
            <if test="age != null">age = #{age},</if>
            <if test="email != null">email = #{email},</if>
        </set>
        where id = #{id}
    </update>

    自动去掉最后多余的逗号
    只传 name → 只更新 name
    只传 age → 只更新 age
    三个都传 → 三个一起更新
  ```
  - **< choose > + < when > + < otherwise >**:多选一
  - 作用：只选一个条件执行，满足一个就不看其他
  ```
    <select id="findChoose" resultType="Employee">
        select * from employee
        <where>
            <choose>
                <when test="name != null">
                    name = #{name}
                </when>
                <when test="age != null">
                    age = #{age}
                </when>
                <otherwise>
                    1=1
                </otherwise>
            </choose>
        </where>
    </select>

    有 name → 只按 name 查询
    没有 name 有 age → 只按 age 查询
    都没有 → 查询全部
  ```
  - **< foreach >**:循环 → 批量操作核心
  - 作用：批量删除、新增、查询(in查询)
  - 批量删除(最常用)
  ```
    <delete id="deleteBatch">
        delete from employee where id in
        <foreach collection="list" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </delete>

    collection="list"：传入的是 List 集合
    item="id"：循环变量名
    open="("：循环开始前加 (
    separator=","：中间加逗号
    close=")": 循环结束后加 )
    
    最终生成SQL：delete from employee where id in (?, ?, ?)
  ```
  - 批量新增(超高效率)
  ```
    <insert id="insertBatch">
        insert into employee(name, age, email)
        values
        <foreach collection="list" item="emp" separator=",">
            (#{emp.name}, #{emp.age}, #{emp.email})
        </foreach>
    </insert>

    一次插入 100 条数据，只执行一次 SQL，速度极快
  ```
  - 批量查询(in查询)
  ```
    <select id="selectBatch" resultType="Employee">
        select * from employee where id in
        <foreach collection="list" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </select>

    最终生成SQL：select * from employee where id in (?, ?, ?)
  ```
- **在原先的员工管理系统添加上述动态SQL功能**
  - **在Mapper接口方法中添加上述功能**
  ```
  //动态条件查询
    List<Employee> findByCondition(Employee employee);
    //动态更新
    int updateDynamic(Employee employee);
    //批量删除
    int deleteBatch(List<Integer> ids);
    //批量插入
    int insertBatch(List<Employee> employees);
    //choose查询
    List<Employee> findByChoose(Employee employee);
  ```
  - **在XML中添加实现上述功能的SQL**
  ```
   <!-- 动态条件查询 -->
    <select id="findByCondition" resultType="com.example.emsmybatis.entity.Employee">
        select * from employee
        <where>
            <if test="name != null and name != ''">
                and name like concat('%', #{name}, '%')
            </if>
            <if test="age != null">
                and age = #{age}
            </if>
        </where>
    </select>

    <!-- 动态更新 -->
    <update id="updateDynamic" parameterType="com.example.emsmybatis.entity.Employee">
        update employee
        <set>
            <if test="name != null">name = #{name},</if>
            <if test="age != null">age = #{age},</if>
            <if test="email != null">email = #{email},</if>
        </set>
        where id = #{id}
    </update>

    <!-- 批量删除 -->
    <delete id="deleteBatch">
        delete from employee where id in
        <foreach collection="list" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </delete>

    <!-- 批量新增 -->
    <insert id="insertBatch">
        insert into employee(name,age,email) values
        <foreach collection="list" item="emp" separator=",">
            (#{emp.name}, #{emp.age}, #{emp.email})
        </foreach>
    </insert>

    <!-- choose 多选一查询 -->
    <select id="findChoose" resultType="com.example.emsmybatis.entity.Employee">
        select * from employee
        <where>
            <choose>
                <when test="name != null">
                    name = #{name}
                </when>
                <when test="age != null">
                    age = #{age}
                </when>
                <otherwise>
                    1=1
                </otherwise>
            </choose>
        </where>
    </select>
  ```
  - **在service中实现这些接口方法，写业务逻辑**
  ```
  /**
     * 动态条件查询
     */
    public List<Employee> search(String name, Integer age) {
        Employee condition = new Employee();
        condition.setName(name);
        condition.setAge(age);
        return employeeMapper.findByCondition(condition);
    }

    /**
     * 动态更新：只更新年龄
     */
    public void updateAgeOnly(Integer id, Integer age) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setAge(age);
        employeeMapper.updateDynamic(employee);
    }

    /**
     * 批量新增：自动构造3条测试数据
     */
    public void addBatchTestData() {
        Employee e1 = new Employee(null, "批量一号", "piliang1@test.com", 20);
        Employee e2 = new Employee(null, "批量二号", "piliang2@test.com", 21);
        Employee e3 = new Employee(null, "批量三号", "piliang3@test.com",22);
        employeeMapper.insertBatch(List.of(e1, e2, e3));
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        employeeMapper.deleteBatch(ids);
    }
    // CHOOSE 查询
    public List<Employee> chooseQuery(Employee condition) {
        return employeeMapper.findByChoose(condition);
    }
  ```
  - **在controller中接收参数，调用service，负责跳转，能让其在浏览器上访问显示**
  ```
  // 动态查询
    @GetMapping("/search")
    public String search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            Model model
    ) {
        model.addAttribute("emps", employeeService.search(name, age));
        return "list";
    }

    // 动态更新年龄
    @GetMapping("/dynamicUpdate/{id}")
    public String dynamicUpdate(@PathVariable Integer id, Integer age) {
        employeeService.updateAgeOnly(id, age);
        return "redirect:/employee/list";
    }

    // 批量新增
    @GetMapping("/batchAdd")
    public String batchAdd() {
        employeeService.addBatchTestData();
        return "redirect:/employee/list";
    }

    // 批量删除
    @GetMapping("/deleteBatch")
    public String deleteBatch() {
        employeeService.deleteBatch(Arrays.asList(1,2,3));
        return "redirect:/employee/list";
    }
    @GetMapping("/choose")
    public String choose(String name, Integer age, Model model) {
        Employee condition = new Employee();
        condition.setName(name);
        condition.setAge(age);
        List<Employee> list = employeeService.chooseQuery(condition);
        model.addAttribute("emps", list);
        return "list";
    }

  ```
  - **补充list.html页面，让上述功能显示在页面上，可视化**
  ```
    <a href="/employee/batchAdd">【演示：批量新增3人】</a>
    <a href="/employee/deleteBatch">【演示：批量删除1,2,3】</a>

    <br/><br/>

    <form action="/employee/search" method="get">
        姓名：<input name="name" placeholder="输入姓名">
        年龄：<input name="age" placeholder="输入年龄">
        <button type="submit">动态查询</button>
    </form>
    <!-- 新增 CHOOSE 查询（优先级：姓名 > 年龄） -->
    <h3>CHOOSE 查询（优先姓名，姓名为空则查年龄）</h3>
    <form action="/employee/choose" method="get">
        姓名：<input name="name" placeholder="输入姓名">
        年龄：<input name="age" placeholder="输入年龄">
        <button type="submit">CHOOSE 查询</button>
    </form>
  ```
- **多表查询**
- 一对一：一个员工对应一个部门
- 一对多：一个部门底下有多个员工
- **完善之前的员工管理系统，增加显示员工表的部门id，表自带的信息，并且后面加一个按钮，能够显示该部门id下的所有员工信息，并且在现实详情信息时，把该员工所在的部门名称显示出来**
  - **首先创建部门实体类和部门表**
  ```
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Department {
        private Integer id;
        private String dept_name;
    }
  ```
  - **修改员工实体类，添加部门id，添加部门对象，为了在显示员工详情时，能够显示部门名称，以及查询该部门下的所有员工信息，所以添加**
  ```
  private Integer dept_id;
  private Department department;
  ```
  - **Mapper接口：添加多表查询的方法**
  ```
  //多表查询
    List<Employee> findEmployeeWithDept(Integer dept_id);
  ```
  - **Service接口：添加多表查询的方法**
  ```
  // 联表查询：根据 dept_id 查询该部门下所有员工 + 部门信息
    public List<Employee> getEmployeesByDeptId(Integer dept_id) {
        return employeeMapper.findEmployeeWithDept(dept_id);
    }
  ```
  - **Controller：调用多表查询的方法**
  ```
  // 联表查询接口：根据 dept_id 查询部门下所有员工
    @GetMapping("/dept/{dept_id}")
    public String getEmployeesByDept(@PathVariable Integer dept_id, Model model) {
        List<Employee> emps = employeeService.getEmployeesByDeptId(dept_id);
        model.addAttribute("emps", emps);
        return "list"; // 复用 list.html 展示结果
    }
  ```
  - **xml文件：添加多表查询的sql语句**
  ```
  <!-- 联表查询 resultMap：员工 + 部门 -->
    <resultMap id="EmployeeWithDeptMap" type="com.example.emsmybatis.entity.Employee">
        <!-- 员工表字段映射 -->
        <id column="id" property="id"/>
        <result column="name" property="name"/>
        <result column="age" property="age"/>
        <result column="email" property="email"/>
        <result column="dept_id" property="dept_id"/>

        <!-- 一对一关联：部门表 -->
        <association property="department" javaType="com.example.emsmybatis.entity.Department">
            <id column="dept_id" property="id"/>
            <result column="dept_name" property="dept_name"/>
        </association>
    </resultMap>

    <!-- 联表查询 SQL：根据 dept_id 查询员工 + 部门 -->
    <select id="findEmployeeWithDept" resultMap="EmployeeWithDeptMap">
        SELECT
        e.*,
        d.id AS dept_id,
        d.dept_name
        FROM employee e
        LEFT JOIN department d ON e.dept_id = d.id
        WHERE e.dept_id = #{dept_id}
    </select>
  ```
  - **list.html页面：添加多表查询的按钮**
  ```
  <!-- 在操作列添加按钮，点击查看该部门下所有员工 -->

            <a th:href="@{/employee/dept/{dept_id}(dept_id=${emp.dept_id})}">查看部门员工</a>

  ```
  - **对以往的方法和页面进行修改**
  - **list.html页面：添加部门ID**
  - **detail.html页面：添加部门名称**
  - **xml中findAll 使用resultType="Employee"，导致 dept_id 和 department 映射不全，所以需要使用使用 resultMap**
  ```
    <select id="findAll" resultMap="EmployeeWithDeptMap">
        SELECT
            e.*,
            d.id AS dept_id,
            d.dept_name
        FROM employee e
        LEFT JOIN department d ON e.dept_id = d.id
    </select>
    这样 findAll 会
    把 dept_id 正确映射到 Employee.dept_id
    把 department 信息加载到 Employee.department
  ```
  - **xml中findById 使用resultType="Employee"，导致 dept_id 和 department 映射不全，所以需要使用使用 resultMap**
  ```
    <select id="findById" resultMap="EmployeeWithDeptMap">
        SELECT
            e.*,
            d.id AS dept_id,
            d.dept_name
        FROM employee e
        LEFT JOIN department d ON e.dept_id = d.id
        WHERE e.id = #{id}
    </select>
  ```
  - **xml中的insert,批量添加，update都需要加上部门ID这个属性**
  

