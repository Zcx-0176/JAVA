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