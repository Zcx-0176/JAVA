package com.cxz.demo;

public class goldcard extends card{
    public goldcard(String cxz, String cxz1, String number, int i) {
        super(cxz, cxz1, number, i);
    }
    public void consume(double money) {
        System.out.println("使用金卡消费,您当前消费："+money);
        System.out.println("优惠后价格："+money*0.8);
        if(getBalance()<money*0.8){
            System.out.println("余额不足，请充值");
        }else{
            setBalance(getBalance()-money*0.8);  //更新后的余额
            System.out.println("当前余额："+getBalance());
            if(money*0.8>=200){
                printticket();
            }else{
                System.out.println("金卡会员消费不满200，无法打印洗车票");
            }
        }
    }
    public void printticket(){
        System.out.println("金卡会员消费满200，请打印洗车票");
    }
}
