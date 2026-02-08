package com.cxz.demo;

public class silvercard extends card{
    public silvercard(String cxz, String cxz1, String number, int i) {
        super(cxz, cxz1, number, i);
    }
    public void consume(double money) {
        System.out.println("使用银卡消费,您当前消费："+money);
        System.out.println("优惠后价格："+money*0.9);
        if(getBalance()<money*0.9){
            System.out.println("余额不足，请充值");
        }else{
            setBalance(getBalance()-money*0.9);  //更新后的余额
            System.out.println("当前余额："+getBalance());
        }
    }
}
