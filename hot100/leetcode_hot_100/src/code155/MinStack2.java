package code155;
/*
    这就是另一个方法，双栈法
    首先明确，是第二个栈维护对应数据压入第一个栈时，此时的栈内最小值
    所以必须每次压入数据时，先获取第二个栈的栈顶元素，即新元素还没压入栈时的第一个栈的最小值
    然后最小值和这个新元素比较
    然后再把新元素压入第一个栈，比较后的最小值压入第二个栈

    所以一开始就需要把Int类型的最大值压入第二个栈，不然空栈咋比较

    不可以用一个int类型的数进行比较最小值，
    因为这样如果某个最小的值先压入再弹出，这个int类型的数据就一直记录这个数了
    而数据弹出后，虽然栈内没有这个数了，但是那个最小值还记录着
    而使用第二个栈的栈顶进行比较就不会出现这个问题
    因为每次都是跟第二个栈的栈顶比较，压栈弹栈都是随之更新的，不会一成不变

 */

import java.util.*;
public class MinStack2 {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MinStack2() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(stack2.peek(),val));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
