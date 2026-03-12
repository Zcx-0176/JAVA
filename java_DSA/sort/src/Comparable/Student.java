package Comparable;
/**
 * 定义Student类，包含属性age,username
 * 使用Comparable接口，进行比较，比较的是Student对象的内容
 * 所以Comparable后面的参数是 Student
 * 实现这个接口，需要重写compareTo方法，方法的参数是Student
 * 可以按照年龄进行排序，即return this.age-student.getAge();
 * 如果按照姓名进行排序，即return this.username-student.getUsername();
 */
public class Student implements Comparable<Student>{
    private  int age;
    private String username;
    public Student(int age,String username){
        this.age=age;
        this.username=username;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
    @Override
    public int compareTo(Student student){
        return this.age-student.getAge();
    }
}
