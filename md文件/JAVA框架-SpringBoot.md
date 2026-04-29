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
  

## 十一、Redis
- 核心作用：做缓存
- 数据库MySQL存永久数据（慢），而Redis存储热点数据（块，减轻数据库压力）

1. **安装Redis**
- 打开浏览器访问：https://github.com/tporadowski/redis/releases
- 下载最新版redis-x.x.x.zip
- 解压到"E:\Redis\Redis-x64-5.0.14.1"
```
使用管理员方式打开cmd

先进入正确的目录
cd /d E:\Redis\Redis-x64-5.0.14.1

临时启动 Redis（先验证能不能用）
redis-server.exe redis.windows.conf
看到 Redis is now ready to accept connections on port 6379 就成功了

再开一个新 CMD，测试连接
cd /d E:\Redis\Redis-x64-5.0.14.1
redis-cli.exe
ping
返回 PONG 说明 Redis 正常运行。

```
- 安装成系统服务(开机自启动)
```
在管理员身份的 CMD 里执行：
cd /d E:\Redis\Redis-x64-5.0.14.1
redis-server.exe --service-install redis.windows.conf
redis-server.exe --service-start
这样以后就不用每次手动启动了。
```

- 配置环境变量：把 E:\Redis\Redis-x64-5.0.14.1 这个路径，添加到系统环境变量的 Path 里，配置完重启 CMD，以后在任何路径都能直接用 redis-server 和 redis-cli 命令了
```
打开cmd，输入 sysdm.cpl，回车
弹出窗口后，切换到高级选项卡
弹出窗口后，切换到高级选项卡

在下方的系统变量列表里，找到名为 Path 的变量，双击它
点击右上角的 新建
把你的 Redis 路径粘贴进去：
E:\Redis\Redis-x64-5.0.14.1
一路点击 确定 保存
``` 

2. **认识Redis**
- Redis：全称Remote Dictionary Server，是一个
  - **高性能内存数据库**：数据存在内存里，读写速度极快
  - **键值对存储**：就像一个大字典，用Key找Value
  - **非关系型数据库(NoSQL)**:和MySQL这种关系型数据库不一样，不存表，不用SQL
- **核心作用**
  - **==缓存==**：把 MySQL 里的热点数据放到 Redis，减轻数据库压力，提升接口响应速度
  - **分布式锁、限流、计数器、消息队列**
  
3. **Redis 核心：5 种数据类型**
- **字符串 String**
- 特点：存储单个键值对，支持数字、字符串、二进制数据
- 适用场景：缓存用户信息、计数器、分布式Session
- **必学命令**
```
set key value       存值
get key             取值
del key             删除
incr key         自增，数字自增，比如点赞数
expire key seconds   设置过期时间，比如缓存1小时，seconds为秒数，到了时间就会自动删除
ttl key           查看剩余过期时间
persist key           取消过期时间
append key str       追加字符串
```
- **哈希 Hash ——存对象专用**
- 特点：类似Map，适合存对象，节省空间
- 适用场景：缓存用户信息（id、name、age）、商品详情
- **必学命令**
```
hset key field value  存单个字段
hget key field   取单个字段
hgetall key  取所有字段和值
hdel key field   删除字段
hlen key    获取对象有多少个字段
hexists key   判断字段是否存在
```
- **列表 List ——有序队列**
- 特点：双向链表，按插入顺序排序，支持左右操作
- 适用场景：消息队列、点赞列表
- 评论列表
- **必学命令**
```
lpush key value   左侧插入
rpush key value   右侧插入
lpop key   左侧弹出
rpop key   右侧弹出
lrange key 0 -1   查看所有元素，0是第一个，-1是最后一个
llen key   获取列表长度
```
- **集合 Set ——无序、不重复**
- 特点：元素不重复，无序，支持交集 / 并集 / 差集
- 适用场景：好友列表、标签、去重、共同好友
- **必学命令**
```
sadd key value   添加元素
smembers key   查看所有元素
sismember key value   判断元素是否存在
sinter key1 key2   求交集(共同好友)
scard key   获取集合元素个数
```
- **有序集合 ZSet —— 带分数的集合**
- 特点：元素不重复，按分数排序
- 适用场景：排行榜、延迟队列、带权重的列表
- **必学命令**
```
zadd key score value   添加元素+分数
zrange key 0 -1   按分数升序查看所有元素，0是第一个，-1是最后一个
zrevrange key 0 -1   按分数降序查看所有元素，0是第一个，-1是最后一个(排行榜)
zrem key value   删除元素
zcard key  获取集合元素个数
zscore key val   查看某个元素的分数
```

- 学到目前，上述命令只能在cmd使用
```
打开 CMD → 输入 redis-cli
进到这个界面: 127.0.0.1:6379>
上述命令在这里敲，在这里运行，在这里显示结果
数据永久保存在我的电脑，关掉cmd，关机，数据还在
```
- Redis 本质是一个后台服务
- cmd的redis-cli 只是一个客户端工具，用来手动操作、测试、联系命令
```
实操练习 
一、String 字符串
-- 1. 存 key-value
set username zcx

-- 2. 取值
get username

-- 3. 数字自增（点赞、浏览量）
set blog_view 0
incr blog_view
get blog_view

-- 4. 设置过期时间（100秒自动消失）
set msg hello
expire msg 100

-- 5. 查看剩余过期时间
ttl msg

-- 6. 取消过期，永久保存
persist msg

-- 7. 删除key
del username


二、Hash 哈希（存对象，适合用户 / 商品）
-- 1. 单个字段赋值
hset user1 name 赵晨旭
hset user1 age 20
hset user1 sex 男

-- 2. 单独取某一个字段
hget user1 name
hget user1 age

-- 3. 一次性取出对象所有数据
hgetall user1

-- 4. 获取当前对象有几个字段
hlen user1

-- 5. 判断某个字段是否存在
hexists user1 sex

-- 6. 删除对象里某个字段
hdel user1 sex


三、List 列表（有序、队列、左右进出）
-- 1. 右侧添加数据（顺序存入）
rpush list1 a b c d

-- 2. 左侧添加数据
lpush list1 0

-- 3. 查看列表所有元素  0=第一条  -1=最后一条
lrange list1 0 -1 

-- 4. 查看列表总长度
llen list1

-- 5. 左侧弹出（删除最左边第一个）
lpop list1

-- 6. 右侧弹出（删除最右边最后一个）
rpop list1


四、Set 集合（无序、自动去重、无重复）
-- 1. 添加多个元素
sadd tag 游戏 音乐 美食 游戏

-- 2. 查看集合所有元素（自动去重，看不到重复的游戏）
smembers tag

-- 3. 判断某个元素是否在集合中
sismember tag 音乐
sismember tag 看书

-- 4. 查看集合元素总数
scard tag

-- 5. 再建一个集合，用来测试交集
sadd tag2 音乐 运动 美食

-- 6. 取两个集合交集（共同元素 = 共同爱好）
sinter tag tag2


五、ZSet 有序集合（带分数、自动排序 = 排行榜）
-- 1. 添加成员+分数（分数在前，内容在后）
zadd score_rank 85 张三
zadd score_rank 96 李四
zadd score_rank 72 王五
zadd score_rank 91 赵六

-- 2. 按分数【升序】排列（低分在前）
zrange score_rank 0 -1

-- 3. 按分数【降序】排列（高分在前，排行榜）
zrevrange score_rank 0 -1

-- 4. 查看某个成员的分数
zscore score_rank 李四

-- 5. 查看有序集合总数量
zcard score_rank

-- 6. 删除指定成员
zrem score_rank 王五


-- 清空当前数据库所有数据（慎用，练习专用）
flushdb
```

```
核心区别
String：单纯一个 key 绑定一个值，简单粗暴

Hash：一个 key 里面包多个小字段，适合存对象

List：有序、允许重复，像排队队列

Set：无序、强制去重，适合爱好 / 标签

ZSet：带分数自动排序，专门做排行榜
```


4. **Redis 整合 SpringBoot + MyBatis**
- 核心逻辑：
- 之前是redis-cli 手动敲命令 → 手动增删改查 Redis。
- 现在是整合后：
Java 代码代替你手动敲 Redis 命令
- 查数据库之前，先查Redis缓存，缓存有数据，直接返回，不查MySQL，缓存没数据，查 MyBatis/MySQL，查到后存入 Redis，更新/删除数据时，同步删除Redis缓存，保证数据一致
- **核心目的**：减轻 MySQL 压力、提升接口速度
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



