package polymorphsm3;

public class test {
    public static void main(String[] args) {
        //解耦合
        animal a = new tortoise();
        a.run();
        //强制类型转换
        tortoise t1 = (tortoise) a;
        t1.eat();

        wolf w = new wolf();
        go(w);
        tortoise t = new tortoise();
        go(t);
    }
    public static void go(animal a){
        System.out.println("go go go...");
        a.run();
        if(a instanceof tortoise){
            tortoise t = (tortoise) a;
            t.eat();
        }else if(a instanceof wolf){
            wolf w = (wolf) a;
            w.jump();
        }
    }
}
