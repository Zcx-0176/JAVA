package polymorphsm2;

public class test {
    public static void main(String[] args) {
        //解耦合
        animal a = new tortoise();
        a.run();
        wolf w = new wolf();
        go(w);
        tortoise t = new tortoise();
        go(t);
    }
    public static void go(animal a){
        System.out.println("go go go...");
        a.run();
    }
}
