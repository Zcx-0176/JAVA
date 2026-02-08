package com.cxz.array;
public class array_test {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        //做牌，创建一个动态初始化数组存储54张牌。
        String[] cards=new String[54];
        //card=[null...]
        //准备四种花色和点数，再做牌存入数组中
        String[] colors={"♦","♣","♥","♠"};
        String[] points={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //拼装花色和点数
        for(int i=0;i<points.length;i++){
            for(int j=0;j<colors.length;j++){
                cards[i*4+j]=colors[j]+points[i];
            }
        }
        cards[52]="小王";
        cards[53]="大王";
        for(int i=0;i<points.length;i++){
            for(int j=0;j<colors.length;j++){
                System.out.print(cards[i*4+j]+"\t");
            }
            System.out.println();
        }
        System.out.println(cards[52]);
        System.out.println(cards[53]);

        for(int i=0;i<54;i++){
            int num1=(int)(Math.random()*cards.length);
            int num2=(int)(Math.random()*cards.length);
            String a = cards[num1];
            cards[num1]=cards[num2];
            cards[num2]=cards[num1];
        }
        for(int i=0;i<cards.length;i++){
            System.out.print(cards[i]);
        }
    }

}
