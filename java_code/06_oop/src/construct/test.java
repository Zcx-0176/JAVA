package construct;

public class test {
    public static void main(String[] args) {
        zi z = new zi( "CXZ", '男', "C++");
    }
}
class fu{
    private String name;
    private char sex;
    public fu(){
    }
    public fu(String name,char sex){
        this.name = name;
        this.sex = sex;
    }
}
class zi extends fu{
    private String skill;
    public zi(String name,char sex,String skill){
        super(name,sex);
        this.skill = skill;
    }
}