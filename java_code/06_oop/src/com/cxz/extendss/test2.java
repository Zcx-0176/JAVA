package com.cxz.extendss;

public class test2 {
    public static void main(String[] args) {
        zi z = new zi();
        z.print();
    }

}
class fu {
    String name="fu";
}

class zi extends fu{
    String name="zi";
    public void print(){
        String name = "lalalalal";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}