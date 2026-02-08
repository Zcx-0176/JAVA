package construct;

public class student {
    private String name;
    private int age;
    private String sex;
    private String schoolname;
    public student(){
        System.out.println("无参构造方法");
    }
    public student(String name,int age,String sex,String schoolname){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.schoolname = schoolname;
    }
    public student(String name,int age,String sex){
        this(name, age, sex, "CXZ");
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public String getSchoolname() {
        return schoolname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }
    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", schoolname='" + schoolname + '\'' +
                '}';
    }
}
