package com.cxz.demo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;   //有这些就不用自己写那些方法了，编译时一键导入了
@Data  // getter setter equals hashCode toString方法
@AllArgsConstructor // 全参构造器
@NoArgsConstructor  // 无参构造器
public class card {
    private String cid;
    private String name;
    private String phone;
    private double balance;
    //预存金额
    public void save(double money){
        this.balance += money;
    }
    //消费金额
    public void consume(double money){
        this.balance -= money;
    }
}
