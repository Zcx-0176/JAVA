package Simplify_path;

import java.util.*;
/**
 * 栈的简单应用，路径简化
 * 思路：
 *      1.将路径按/进行分割，得到一个字符串数组，使用字符串的split()方法
 *      2.创建一个栈，用于保存路径
 *      3.遍历该字符串数组，如果遇到空字符串或者当前字符串是"."，则跳过
 *      4.如果遇到".."，则栈内弹出一个元素
 *      5.如果遇到其他字符串，则入栈
 *      6.最后将栈内元素倒序，并拼接成字符串
 *      注意，对于比较字符串的判断，必须使用equals()方法，不能使用==，
 *      因为==比较的是值，只能比较int，char，boolean，即比较的是地址
 *      而equals可以只比较值
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : paths) {
            if (s.equals("")|| s.equals(".")) {
                continue;
            }
            if(s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        int stacksize = stack.size();
        String[] st = new String[stacksize];
        for(int i=stacksize-1;i>=0;i--){
            st[i] = stack.pop();
        }
        String result = "";
        for(int i=0;i<stacksize;i++){
            result += "/";
            result +=st[i];
        }
        if(result.equals("")){
            result += "/";
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/user/Documents/../Pictures"));
    }
}
