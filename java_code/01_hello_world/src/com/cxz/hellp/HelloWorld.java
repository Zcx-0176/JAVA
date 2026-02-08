package com.cxz.hellp;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world!");
        System.out.println(getCode());
        print();
        System.out.println(add(1,2));
    }
    //定义一个方法，帮我生成一个验证码
    /**
     * 生成一个四位的随机数字验证码
     *
     * 该方法用于生成一个四位的数字验证码，用于用户验证、安全校验等场景
     * 验证码由0-9之间的随机数组成，每次调用该方法时生成的验证码都不相同
     *
     * @return 生成的四位数字验证码，以字符串形式返回
     */
    public static String getCode(){
        // 初始化验证码字符串，此时为空
        String code = "";
        // 循环四次，每次生成一个随机数字并将其添加到验证码字符串中
        for (int i = 0; i < 4; i++) {
            // 生成一个0到9之间的随机数
            int num = (int)(Math.random()*10);
            // 将生成的随机数字添加到验证码字符串中
            code += num;
        }
        // 返回生成的四位数字验证码
        return code;
    }
    //定义一个方法输出三行你好世界
    public static void print(){
        for (int i = 0; i < 3; i++) {
            System.out.println("你好世界");
        }
    }
    //定义一个方法表示两数相加
    public static int add(int a,int b){
        return a+b;
    }
}












