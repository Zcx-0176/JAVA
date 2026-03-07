package entity;
/**
商品实体类
 实例化序列化接口Serializable
 成员变量：id,name,category,price,quantity,createTime,updateTime
 使用@Data,@AllArgsConstructor,@NoArgsConstructor来创建getter,setter,toString方法和有参构造器及无参构造器
 要应用Lombok注解，需要导入lombok.jar包，现在IDEA已经有这个包
 需要在File中找到Settings中找到Build,Tools,Annotation Processors，选择Enable，然后重启IDEA
 这样这个项目就能识别Lombok注解
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data  // getter setter toString等方法
@AllArgsConstructor  // 有参构造器
@NoArgsConstructor   // 无参构造器
public class Product{
    private String id;        //商品编号
    private String name;      //商品名称
    private String category;  //商品类别
    private double price;     //商品价格
    private int quantity;     //商品数量
    public double getTotalPrice(){
        return price*quantity;
    }

}
