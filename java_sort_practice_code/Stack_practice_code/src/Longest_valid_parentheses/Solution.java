package Longest_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 栈的简单应用，最长有效括号
 * 思路：
 *      1.创建两个栈，一个栈用于保存左括号stackchar，一个栈用于保存左括号的索引stacknum
 *      2.声明一个整型数组is，在后续的遍历中，不能匹配的位置置为1，能匹配的位置置为0
 *      3.遍历字符串，如果遇到左括号，则将左括号压入栈stackchar，并把左括号的索引也压入栈stacknum
 *      4.如果遇到右括号，看左括号栈是否为空，如果为空则该右括号没有能匹配的，把is数组中该右括号的索引置为1
 *      5.如果栈不为空，那么就把左括号弹栈，把左括号索引弹栈，并把is数组中该左括号索引位置置为0
 *      6.循环结束后，如果栈不为空，证明栈内的左括号没有匹配上，需要把这些左括号对应的索引也置为1
 *      7.循环该栈，直到栈空结束循环，每次弹栈，is数组中该索引位置置为1
 *      8.最后就变成了在一串1 0 数组中找出最长的0
 *      9.经过循环遍历返回最长的0的长度
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int size = s.length();
        int[] is = new int[size];
        Deque<Character> stackchar = new ArrayDeque<>();
        Deque<Integer> stacknum = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<size;i++){
            if(chars[i] == '('){
                stackchar.push(chars[i]);
                stacknum.push(i);
            }else{
                if(stackchar.isEmpty()){
                    is[i] = 1;
                }else{
                    stackchar.pop();
                    is[stacknum.pop()] = 0;
                }
            }
        }

        while(stackchar.size()>0){
            stackchar.pop();
            is[stacknum.pop()] = 1;
        }
        int count = 0;
        int maxcount = 0;
        for(int i=0;i<size;i++){
            if(is[i]==0){
                count++;
            }else{
                count = 0;
            }
            maxcount = Math.max(maxcount,count);
        }
        return maxcount;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses(""));
        System.out.println(s.longestValidParentheses("()(()((()))"));
    }
}
