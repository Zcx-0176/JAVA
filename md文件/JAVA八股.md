# <center><font face="仿宋" font color=bark>JAVA 八股 </font>
## <center><font face="楷体" size=5>zcx</font> 

### 一、java基础
##### 一、java基本数据结构
1. **8大基本类型**
- |类型|字节|取值范围|包装类|
  |:----:|:----:|:----:|:----:|
  |byte|1|-2⁷ ~ 2⁷即-128~127|Byte|
  |short|2|-2¹⁵ ~ 2¹⁵-1|Short|
  |int|4|-2³¹ ~ 2³¹-1|Integer|
  |long|8|-2⁶³ ~ 2⁶³-1|Long|
  |float|4|单精度浮点，约 6~7 位有效数字|Float|
  |double|8|双精度浮点，约 15~16 位有效数字|Double|
  |char|2|0~65,535|Character|
  |boolean|1|true/false|Boolean|
- boolean 在虚拟机规范里没有规定固定字节，不同 JVM 实现可能是 1 字节或 1 位。
- **浮点型不能精确表示所有小数，所以禁止用于金额计算，要用 BigDecimal。**
- **BigDecimal 就是 Java 里用来做精确小数计算的类**
  ```
    System.out.println(0.1 + 0.2);
    // 输出：0.30000000000000004  错的！

    金融、金额、计费场景绝对不能用 double，必须用：
    BigDecimal a = new BigDecimal("0.1");
    BigDecimal b = new BigDecimal("0.2");
    System.out.println(a.add(b)); // 0.3  正确
  ```
    - float/double 不精确，BigDecimal 精确
  - **创建时一定要用字符串构造 new BigDecimal("0.1")**，不要用 double
  - **加减乘除用 add()、subtract()、multiply()、divide()**
  - 除法要指定舍入模式，否则除不尽会抛异常
  ```
  BigDecimal a = new BigDecimal("10");
  BigDecimal b = new BigDecimal("3");

  // 保留 2 位小数，四舍五入
  BigDecimal result = a.divide(b, 2, RoundingMode.HALF_UP);

  System.out.println(result); // 输出 3.33


  // 1. 四舍五入（最常用）
  RoundingMode.HALF_UP

  // 2. 直接向上取整（进一法，比如计算运费、金额）
  RoundingMode.UP

  // 3. 直接向下取整（截断，不四舍五入）
  RoundingMode.DOWN

  // 4. 银行家舍入（四舍六入五成双，金融常用）
  RoundingMode.HALF_EVEN

  ```


2. **基本类型与包装类的区别**
- **默认值不同**
  - 基本类型默认值为 0，包装类默认值为 null。
- **存储位置不同**
  - 基本类型：存储在**栈**中，速度快
  - 包装类型：**对象存储在堆，引用存储在栈**
  ```
  Integer age = new Integer(20);

  new Integer (20) 是对象
  它是真实存在的一块内存，存着数据 20，放在堆里。

  age 是引用
  它只是一个地址编号，存在栈里，相当于 “指向堆里那个对象的手指”

  ```
- **使用场景不同**
  - 集合只能存包装类，不能存基本数据类型
  - 方法返回值允许null时必须用包装类
  ```
  因为：基本类型 不可能为 null！
  int、byte、boolean、double… 这些都是实实在在的值，没有 “空” 这个概念
  nt 默认是 0
  boolean 默认是 false
  它们永远不可能等于 null
  ```
- **线程安全**
  - 基本类型都是值，天然线程安全；
  - 包装类对象不可变，但引用可替换，所以包装类对象本身线程安全，而引用对象本身非线程安全
  ```
  ① 基本类型天然线程安全
    基本类型就是一个值，不存在 “共享对象”“修改内部状态”。
    每个线程用自己栈里的值，互不干扰，所以天然安全。
  ② 包装类对象不可变
    Integer、Long、String 这些都是不可变类：
    内部值用 private final 修饰
    一旦创建，里面的值永远不能改
    任何看似修改的方法，其实都是返回新对象

    比如：
    Integer a = 10;
    a = 20;
    不是把原来的 10 改成 20，而是让 a 这个引用指向了一个新的 Integer (20) 对象。
  ③ 但引用可替换
    引用只是个地址，你可以随便让它指别的对象：
    a ------> Integer(10)  （不可变）
    a ------> Integer(20)  （引用换了）
  ```
3. **自动装箱&自动拆箱**
- 装箱：基本类型 -> 包装类
```
Integer a = 10;  // 底层：Integer.valueOf(10)
```
- 拆箱：包装类 -> 基本类型
```
int b = a;       // 底层：a.intValue()
```
- **拆箱时如果对象是null，会抛出 NullPointerException**
```
Integer a = null;
int b = a; // NPE！
```
- **valueOf ()**
- valueOf() 是包装类的静态工厂方法。
```
Integer a = Integer.valueOf(10);

它干了两件事
1.把基本类型 int → 包装类型 Integer（装箱）
2.内部会走缓存，优先返回缓存里已有的对象，不重复 new

自动装箱底层就是调用 valueOf ()
Integer a = 10;
// 等价于 Integer a = Integer.valueOf(10);

正是因为 valueOf 用了缓存，才出现 -128~127 用 == 为 true 的现象
这句话什么意思呢：

valueOf 内部逻辑是这样的：
if (a >= -128 && a <= 127) {  
    从缓存里拿一个已经创建好的对象返回
    即：同一个数字，在缓存范围内，永远返回同一个对象！
}else { 
    new 一个新的 Integer 对象返回
 }

 如：
 Integer a = 100;
 Integer b = 100;
 System.out.println(a == b); // true
 因为 == 是比较两个对象的地址
 100 是 -128~127 范围内的数字
 所以 a 和 b 指向的是同一个对象，所以 == 为 true

 但：
 Integer c = 200;
 Integer d = 200;
 System.out.println(c == d); // false
 200 不在 -128~127 范围内
 所以 a 和 b 创建了两个对象，
 指向的对象地址不同
 所以 == 为 false
```

##### 二、String、StringBuilder、StringBuffer

1. 三者对比：
- |特性|String|StringBuilder|StringBuffer|
  |:----:|:----:|:----:|:----:|
  |可变性|不可变|可变|可变|
  |线程安全|非线程安全|非线程安全|线程安全|
  |效率|低(拼接产生新对象)|最快|快|
  |使用场景|少量字符串、常量|单线程拼接|多线程拼接|
- **String为什么不可变？**
  - 底层是被 final 修饰的字符数组
  - String 类本身被 final 修饰，不能被继承
  ```
  public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {

    private final char value[];  // 核心！

    }
  ```
  - 所有修改方法（substring、replace、concat）都返回新 String 对象，不修改原对象
  ```
  String s = "abc";
  s.replace('a', 'z');

  你以为 s 变成 "zbc" 了？
  并没有！s 还是 "abc"
  replace 只是返回了一个新字符串，你没接住而已。

  正确写法：
  s = s.replace('a', 'z');
  这也不是修改原对象，是让 s 引用指向了一个新对象。
  ```
- **不可变的好处**
  - 线程安全（多线程无竞争）
  - 哈希值固定，适合做 HashMap key
  - 字符串常量池复用，节约内存
- **String常量池**
  - 字符串字面量会进入 字符串常量池（String Pool）
  - **常量池：Java 专门开了一块小内存，用来放重复的字符串，避免重复创建。**
  ```
  String s1 = "abc";
  String s2 = "abc";
  第一次 "abc" → 放进常量池
  第二次 "abc" → 直接用池里的，不新建

  所以
  s1 == s2 → true
  因为指向同一个对象
  ```
  - new String("abc") 会创建两个对象：
    - 常量池中的 "abc"
    - 堆中新的 String 对象
  ```
  String s = new String("abc");

  执行过程：
  先看 "abc" → 去常量池找
  没有就创建一个放进去
  再执行 new String (...)
  在堆里再新建一个 String 对象

  所以一共两个对象：
  常量池里的 "abc"
  堆里 new 出来的 String

  这也是为什么：
  String s1 = "abc";
  String s2 = new String("abc");

  s1 == s2 → false
  一个在常量池，一个在堆，地址不一样
  ```
  - **intern()** 方法：把字符串 “强行扔进常量池”，并返回池里的对象。
  ```
  String s1 = new String("abc");
  String s2 = s1.intern();
  String s3 = "abc";

  System.out.println(s2 == s3); // true
  作用：
  如果池里已有 → 返回池对象
  如果没有 → 把当前字符串加入池，再返回
  所以这样就会是s2和s3指向同一个对象
  ```
- **String 拼接底层原理**
  - **编译期常量拼接**："a" + "b" → 编译器直接优化为 "ab"，没有任何对象损耗
  - **编译器变量拼接**：s1 + s2 底层会创建 StringBuilder 并 append
  ```
  String s1 = "a";
  String s2 = "b";
  String s3 = s1 + s2;

  底层真实执行：
  String s3 = new StringBuilder().append(s1).append(s2).toString();

  每次 + 都会：
  新建 StringBuilder
  append
  再 new String

  所以循环里面使用+=，性能会爆炸
  String s = "";
  for (int i = 0; i < 1000; i++) {
      s += i;
  }
  每次循环都：new StringBuilder → append → new String

  正确写法是：
  StringBuilder sb = new StringBuilder();
  for (...) {
      sb.append(i);
  }
  String s = sb.toString();
  ```
  - 循环中大量 += 会频繁创建对象，性能极差，必须手动用 StringBuilder
- 因为String是不可变的，每次拼接都会产生新对象，所以java搞了**两个可变字符串：StringBuilder和StringBuffer，它们内部都有一个可扩容的char数组，append 多少，它就往数组里塞多少，不会新建对象**
- **核心区别**
- 线程安全：
  - StringBuffer 是线程安全的
它的方法都加了 synchronized 锁
  - StringBuilder 没有锁，线程不安全
- 性能：
  - StringBuilder 更快
  - StringBuffer 因为要加锁、解锁，速度慢一点
- **使用场景**
  - 单线程就用StringBuilder
  - 多线程就用StringBuffer
  - 循环拼接字符串，使用StringBuilder
  
##### 三、==和equals()
1. ==的作用
   - 基本数据类型：比较值是否相等
   - 引用数据类型：比较内存地址是否相同(是不是同一个对象)
2. equals()
   - 来自 Object 类，默认实现就是 ==，比较地址
   ```
   public boolean equals(Object obj) {
       return (this == obj);
   }

   很多类重写了 equals ()，改为比较内容：
   String
   Integer、Long 等包装类
   BigDecimal
   自定义实体类（建议重写）
   ```
3. equals 与 hashCode 约定
   - 两个对象 equals 为 true，hashCode 必须相等
   - 两个对象 hashCode 相等，equals 不一定为 true
   - 只重写 equals 不重写 hashCode，会导致 HashMap 等集合出错

#### 四、包装类缓存机制
1.  **Integer 缓存**
    - Integer.valueOf() 使用缓存
    - 默认缓存范围：-128 ~ 127
    - 超过范围会 new 新对象
    ```
    Integer a = 100;
    Integer b = 100;
    a == b;  // true

    Integer c = 200;
    Integer d = 200;
    c == d;  // false

    但是如果是new声明，就一定是新对象，不走缓存
    Integer a = new Integer(10);
    Integer b = new Integer(10);
    a == b; // false（new 一定新对象，不走缓存）
    ```
2. **其他包装类缓存范围**
- |包装类|缓存范围|
  |:----:|:----:|
  |Byte|-128 ~ 127|
  |Short|-128 ~ 127|
  |Character|0 ~ 127|
  |Boolean|true, false|
  |Long|-128 ~ 127|
  |Float|无缓存|
  |Double|无缓存|

#### 五、扩展
1. **Java 只有值传递**
   - 基本类型：传递值的副本
   - 引用类型：传递地址值的副本
   - 方法内部修改引用指向不会影响外部；修改对象内部属性会影响外部
2. **char 为什么是 2 字节？**
   - 因为 Java 使用 Unicode 编码，早期固定 2 字节表示一个字符
3. **float /double 精度问题**
   - System.out.println(0.1 + 0.2); // 0.30000000000000004
   - 原因：二进制无法精确表示部分十进制小数。
4. **为什么包装类都是不可变类**
   - 线程安全
   - 可以安全缓存
   - 可以安全用作Map的key

#### 六、面向对象三大特性
1. **封装**
- 核心思想：**隐藏内部实现，暴露安全接口**
- 用 private 修饰成员变量，外部不能直接访问
- 提供 getter/setter 方法控制访问
- 好处：安全、可维护、降低耦合
- 底层意义：不让外部随意篡改对象内部状态，保证数据合法性

2. **继承**
- 使用 **extends** 关键字
- Java 只支持**单继承**，一个类只能有一个父类
  - 原因是：为了避免菱形继承问题(多个父类有同名方法时冲突)，简化设计
- 但是一个类可以实现多个接口 implements A,B,C
- 子类拥有父类**非私有的属性和方法**
- 构造方法不能被继承

3. **多态**
- **同一个行为，具有多个不同的表现形式**
- 实现三要素：
  - 继承/实现关系
  - 方法重写
  - 父类引用指向子类对象
```
格式
Father f = new Son();


口诀：编译看左边，运行看右边
编译时：看父类有没有这个方法
运行时：执行子类重写后的方法
Father f = new Son();
f.say(); // 执行 Son 的 say()
```
- **成员变量没有多态！**
```
class Father { int a = 10; }
class Son extends Father { int a = 20; }

Father f = new Son();
System.out.println(f.a); // 输出 10
```
#### 七、重载(Overload)
- **同一个类中，方法名相同，参数列表不同,与返回值无关**
- 参数列表不同包括：
  - 参数个数不同
  - 参数类型不同
  - 参数顺序不同
- **编译期多态**：编译器在编译阶段就确定调用哪个方法，编译期多态也叫静态绑定
- **返回值不用不算重载**
- **重载：同名不同参，编译期绑定**

#### 八、重写(Override)
- **子类对父类已有方法重新实现**
- 必须满足：(严格规则)
  - 方法名完全相同
  - 参数列表完全相同
  - 返回值类型兼容(基本类型必须相同，引用类型可协变)
  - 子类方法权限不能更低
    - 父类 public → 子类只能 public
    - 父类 protected → 子类 protected 或 public
  - 不能抛出更宽泛的受检异常
- **运行期多态**：JVM 在运行时根据对象实际类型调用方法，也叫动态绑定
- **static 方法、private 方法、final 方法 不能被重写**
- **重写：同名同参，运行期绑定，权限不能更小**

- |特性|重载|重写|
  |:----:|:----:|:----:|
  |位置|同一个类内部|父子类之间|
  |方法名|相同|相同|
  |参数列表|必须不同|必须相同|
  |返回值|无关|兼容/相同|
  |权限|无限制|不能更小|
  |异常|无关|不能更宽泛|

#### 九、this关键字
- **this** 关键字：本质是当前对象的引用
- 谁调用方法，this就代表谁
```
private int age;
public void setAge(int age) {
    this.age = age;   将传入函数的age参数赋给当前对象的age私有属性
}


调用本类其他构造方法
public User() { 
  this(10); 
}
public User(int age) { ... }
注意：
必须放在第一行
不能互相递归调用


调用本类其他成员方法
this.eat();


返回当前对象
return this;
```
- **this 就是当前对象自己的引用，存在于实例方法中**


#### 十、super关键字
- **super** 关键字：指向父类的引用，用于访问父类成员
```
调用父类构造方法
public Son() {
    super(); // 必须第一行
}
任何子类构造，默认第一行都会隐式调用 super()


访问父类成员变量
super.age


调用父类被重写的方法
super.say();
```
- **this()和super()不能同时出现**
- **super()和this()不能在静态方法中调用**
- **super()和this()都必须在构造方法第一行**

#### 十一、java异常体系
1. 异常整体继承结构：
```
Throwable
├── Error（错误，JVM 级，程序无法处理）
└── Exception（异常，程序可处理）
    ├── RuntimeException（运行时异常，非受检）
    └── 其他 Exception（受检异常，编译期强制处理）
```
- **Throwable**
  - 所有异常和错误的顶级父类
  - 只有它或子类对象，才能被 try/catch/finally 处理
  - 只有它或子类，才能跟在 throw/throws 后面
- **Error（错误）**
  - JVM 层面严重问题，程序无法捕获、无法恢复
  - 一般是系统崩溃、资源耗尽
  - 代码不需要、也不应该去 try-catch
  - 如：
  ```
  StackOverflowError：栈溢出（递归死循环）
  OutOfMemoryError：OOM 内存溢出
  NoClassDefFoundError：找不到类
  LinkageError：类加载链接失败  
  ```
- **Exception（异常）**
  - 程序逻辑错误，可被 try/catch 处理
  - 分为
    - **RuntimeException（运行时异常，非受检）**
    - **其他 Exception（受检异常，编译期强制处理）**
- **RuntimeException（运行时异常）**
  - 编译不检查、不强制捕获
  - 一般是代码逻辑错误导致
  ```
  NullPointerException：空指针 NPE
  IndexOutOfBoundsException：数组 / 集合越界
  IllegalArgumentException：参数不合法
  ClassCastException：类型转换异常
  ArithmeticException：算术异常（除 0）
  ConcurrentModificationException：并发修改异常
  ```
- **受检异常（Checked Exception）**
  - 编译期强制处理：要么 try-catch，要么 throws 抛出
  - 不是代码 Bug，是外部环境 / 预期可出现的问题
  ```
  IOException：IO 异常（文件读写、网络）
  SQLException：数据库异常
  ParseException：解析异常
  ClassNotFoundException：找不到类
  ```
- **异常五个关键字**
  - **try**：包裹可能出异常的代码块
  - **catch**：捕获并处理对应类型异常，可以多个 catch，**子类异常放前面，父类放后面**，否则编译报错
  - **finally**：无论是否异常、是否 return，最终一定执行。唯一不执行：System.exit(0) 退出了JVM,所以不会执行finally里面的代码了
  - **throw**：手动抛出一个异常对象，方法内部用
  - **throws**：方法声明上抛出异常类型，告诉调用者：我这里可能抛这个异常，你处理
- **finally 与 return 执行顺序**
  - 先执行 try 里代码
  - 遇到 return → 先去执行 finally
  - finally 执行完 → 再回来 return
  ```
  public static int test() {
    try {
        return 1;
    } finally {
        System.out.println("finally");
    }
  }

  return 1 准备 → 执行 finally → 再返回 1
  如果 finally 里也 return，会覆盖原来的返回值，极不推荐。
  ```

#### 十二、static /final/finally /finalize
1. **static（静态关键字）**