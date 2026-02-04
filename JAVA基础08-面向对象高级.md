# <center><font face="仿宋" font color=bark>Java基础</font>
## <center><font face="楷体" size=5>zcx</font> 
### 一、面向对象高级
1. **代码块**
- 是类中的五大成分之一(成员变量、构造器、方法、代码块、内部类)
- 代码块分为两种：静态代码块、实例代码块
  - **静态代码块**：**格式：static{}**。特点：类加载时执行，只执行一次。作用：完成类的初始化
  - >public class test {
    public static String a;  **==静态成员变量==**
    public static int[] arr=new int[52];
    **==static{
        // 静态代码块，与类一起优先加载，只执行一次，先加载静态代码块
        //故常用于初始化类的静态成员变量
        System.out.println("静态代码块");
        a = "ssssss";
        arr[0]=1;  //初始化静态数组
    }==**
    public static void main(String[] args) {
        System.out.println("main方法");
    }
}
  - **实例代码块**：**格式：{}**。特点：对象创建时执行，每创建一个对象执行一次。作用：完成对象的初始化
  - >public class test2 {
    private String name;
    **=={  // 实例代码块，无static修饰，属于对象
        System.out.println("实例代码块");
        name = "cxz"; //初始化对象的实例资源
    }==**
    public static void main(String[] args) {
        test2 t = new test2();
        System.out.println("main方法");
    }
}

2.**内部类**
- 如果一个类定义在另一个类的内部，则称这个类位内部类
- **成员内部类**：就是类中的一个普通成员。外部类对象持有
  - 成员内部类可以直接访问外部类的静态成员，也可以直接访问外部类的实例成员
  - 成员内部类的实例方法中，可以直接拿到当前寄生的外部类对象 语法：外部类名.this
  - >public class classd { **//外部类**
  public static int a=0;  **==外部类的静态成员==**
    private int b=0;  **==外部类的实例成员==**
    ==public class innerclass {  **//成员内部类，属于外部类对象**
        public void show()
        {
            System.out.println("show");
            System.out.println(a);  
            System.out.println(b);
            System.out.println(classd.this);
        }
    }==
}
public class test {     
    public static void main(String[] args)
    {
        **==//创建对象：外部类名.内部类名 创建内部类对象名 = new 外部类名().new 内部类名();
        classd.innerclass a = new classd().new innerclass();==**
        a.show();
    }
}
- **静态内部类**：有static修饰的内部类，属于外部类自己持有
  - 静态内部类能直接访问外部类的静态成员
  - 静态内部类中不可以访问外部类的实例成员
  - >public class classd {  **==外部类==**
    public static String name="aaaa";  **==外部类静态成员变量==**
    public static  class innerclass{  **==静态内部类==**
        public void show(){
            System.out.println(name);
        }
    }
}
public class test {
    public static void main(String[] args)
    {**==//创建对象：外部类名.内部类名 对象名 = new 外部类名.内部类名()
        classd.innerclass ci = new classd.innerclass();==**
        ci.show();
    }
}
- **局部内部类**：定义在方法中、代码块中、构造器等执行体中(基本没用)
- **匿名内部类**：是一种特殊的局部内部类
  - 匿名是指：程序员不需要为这个类声明名字，**默认有个隐藏的名字(外部类名$编号.class)**
  - **==格式：new 抽象父类/抽象接口(){类体，一般是方法重写}；==**
  - 特点：**匿名内部类本质是一个子类，并会立即创建出一个子类对象**
  - 作用：更方便的创建一个子类对象
  - >public abstract class animal {  **==抽象父类==**
    public abstract void cry();
}
public class test {  **==主类==**
    public static void main(String[] args) {
        animal a = ***==new animal(){ **==匿名内部类==**
            @Override
            public void cry() {
                System.out.println("cry");
            }
        };别忘了要写上分号==***
    }**这部分就是匿名内部类，相当于一个子类，同时还是一个子类对象，就跟创建一个子类继承父类然后声明对象是一样的**
}**编译看左边，运行看右边，是可以运行的**
  - **常见使用形式**：**==通常作为一个对象参数传输给方法==**
  - >public class test2 {  **==主类==**
    public static void main(String[] args) {  
        swim s1 = new swim(){  **==第一个匿名内部类==**
            @Override
            public void swiming() {
                System.out.println("student can swiming");
            }
        };
        start(s1);  **==调用方法==**
        start(new swim(){  **==第二个匿名内部类,现在是直接充当了start需要的参数，因为内部类能立即创建出一个子类对象==**
            @Override
            public void swiming() {
                System.out.println("teacher can swiming");
            }
        });
    }  **==上述这俩就是匿名内部类不同的使用形式==**
    public static void start(swim s){ **==start方法==**
        s.swiming();
    }
}
interface swim{
    void swiming();   **==抽象方法==**
}
  - **应用场景**
     - 调用别人提供的方法实现需求时，这个方法正好可以让我们传输一个匿名内部类对象给其使用(不是主动去用的，而是调用别人的方法需要才用)
  - **另一个应用场景**
  - 