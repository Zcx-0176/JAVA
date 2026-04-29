package code739;
/*
    每日温度
    使用int数组存储result数组，默认初始化为0
    使用单调栈，栈内存储的是传入的温度数组的索引
    for循环i 从0到n

    先是while循环判断栈是否为空，若不为空且 当前i索引的温度 大于 栈顶的的索引代表的温度
    证明 当前栈顶的索引index的位置，距离比他大的温度的索引 i 相差i-index
    所以result[i] = i - index

    如果栈为空，或者小于等于
    就把索引压入栈

    注意，栈是后进先出，对于i=2，即第三个数
    temperatures = [73,74,75,71,69,72,76,73]
    for循环i到3时，发现71小于75，这时候是把71压入栈
    同理把69压入栈
    然后循环到72，这时候栈顶是69小于当前索引的温度72，开始循环，把索引相减的结果放入结果集
    然后继续while循环判断，发现当前栈顶元素71还是小于当前索引温度72.继续索引相减放入结果集
    继续循环判断，发现75大于72了，就结束while循环，把72压入栈
    然后遍历到76，发现栈顶的72小于76.则索引相减，放入结果集
    然后栈顶元素是75，发现也小于76，也索引相减，放  入结果集
    现在栈为空了，结束循环
    然后把76压入栈
    遍历到73，发现栈顶元素76大于73，故不进入while循环
    把73压入栈
    然后for循环终止了，栈里的两个元素因为没有后续的温度判断就不处理了
    因为一开始的result结果集初始化就是0
    所以栈内剩下的元素无所谓
*/
import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp>temperatures[stack.peek()]){
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }
        return result;
    }
}
