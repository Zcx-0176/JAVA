package com.cxz.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class demo1test {
    @Test
    public void testprintNumber(){
        demo1.printNumber("张三abc");
        demo1.printNumber("");
        demo1.printNumber(null);
    }
    @Test
    public void testgetMaxIndex(){
        int index1 = demo1.getMaxIndex("张三abc");
        int index2 = demo1.getMaxIndex("");
        int index3 = demo1.getMaxIndex(null);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        Assertions.assertEquals(6, index1, "本轮测试失败");//故意写错的期待结果
        Assertions.assertEquals(-1, index2);
        Assertions.assertEquals(-1, index3);
    }
}
