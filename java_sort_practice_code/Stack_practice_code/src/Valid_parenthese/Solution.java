package Valid_parenthese;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈的简单应用，判断括号是否匹配
 * 最清晰简单的思路：
 *       先把字符串转成字符数组
 *       然后遍历数组，遇到左括号就压入栈
 *       如果遇到右括号，就弹出栈顶元素，看看是否与右括号匹配
 *       如果不匹配，则把bl 改为false，即返回false
 *       注意几个额外的判断
 *           1.如果全是左括号，没有右括号，则返回false，即如果循环结束栈内还有元素就返回false
 *           2.如果全是右括号，没有左括号，则进入循环不能让空栈弹栈，故需要加一个判断，如果栈为空，证明无法匹配，这直接返回false
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();  //创建栈
        char[] chars = s.toCharArray();  //转成字符数组
        boolean bl = true;  //默认为true
        for(char c : chars){   //遍历字符数组
            if(c == '(' || c == '[' || c == '{'){  //如果是左括号则压入栈
                stack.push(c);
            }else{  //如果是右括号，开始判断
                if(!stack.isEmpty()){  //如果栈为空，证明当前的右括号没有可以匹配的左括号，更别提对应的左括号，直接返回false
                    if(c == ')'){   //栈不为空，则开始弹栈，对应匹配，不对应就返回false
                        if(stack.pop() != '('){
                            bl = false;
                        }
                    }else if(c == ']'){
                        if(stack.pop() != '['){
                            bl = false;
                        }
                    }else if(c == '}'){
                        if(stack.pop() != '{'){
                            bl = false;
                        }
                    }
                }else{
                    bl = false;
                }
            }
        }
        if(!stack.isEmpty()){   //如果遍历完数组，栈还有元素，证明还有几个左括号没有匹配上右括号，返回false
            bl = false;
        }
        return bl;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("]"));
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("(["));
        System.out.println(s.isValid("()[]({[]})[]"));
    }
}
