package com.cxz.staticmathod;

public class util {
    //静态类验证码方法
    private util(){
    }
    public static String getCode(int length){
        String code = "";
        for (int i = 0; i < length; i++) {
            int num = (int)(Math.random()*10);
            code += num;
        }
        return code;
    }
}
