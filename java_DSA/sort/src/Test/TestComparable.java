package Test;
import Comparable.Student;
/**
 * 该java文件在定义测试方法Comparable getMax(comparable c1, comparable c2)
 * 参数c1,c2都是Comparable接口的实现类
 * 旨在进一步理解Comparable接口
 */
public class TestComparable {
    public static Comparable getMax(Comparable c1, Comparable c2){
        int result = c1.compareTo(c2);
        if(result<0){//c1<c2
            return c2;
        }else if(result>=0){ //c1>=c2
            return c1;
        }
        return null;
    }
    public static void main(String[] args){
        Student s1 = new Student(18,"张三");
        Student s2 = new Student(20,"李四");
        int re1 = s1.compareTo(s2);
        System.out.println(re1);  //输出-2
        Comparable max = getMax(s1,s2);
        System.out.println(max);   //输出Student{age=20, username='李四'}
    }
}
