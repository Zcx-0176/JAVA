package polymorphsm;

public class test {
    public static void main(String[] args) {
        //对象多态
        animal a = new wolf();  //父类引用指向子类对象
        animal b = new tortoise();  //父类范围更大，这是子类赋给父类引用
        //行为多态
        a.run();  //编译看左边，运行看右边
        b.run();  //编译看左边animal有没有run方法，运行看右边子类有没有run方法
    }
}
