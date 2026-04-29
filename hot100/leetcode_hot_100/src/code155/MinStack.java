package code155;
/*
    最小栈
    本题要求用常数时间内检索栈内的最小值
    当前类用的是最小堆数据结构：PriorityQueue
    但是在某些数量级和顺序的数据时，是O(n)级别，无法到达常数
    首先最小堆就是一个java定义好的数据结构
    加入数据后，堆顶就是最小值
    然后如果弹栈了，那么就需要把这个值从最小堆去掉
    所以如果最小堆的堆顶是这个值，直接把最小堆的堆顶弹出即可
    如果不是这个值，那么就需要先把最小堆挨个弹出，看值是否匹配，
    匹配上了再弹出去，然后把之前弹出的所有值再一个个按顺序压回来
    这就是为什么在某些情况下可能是O(n)


    所以另一个类就是真正常数级别的方法

    使用双栈法，一个栈存储数据
    另一个栈存储对应的数据的时候的最小值
    这样每次要获取最小值，直接就获取另一个栈的栈顶元素就好
    如果第一个栈要弹栈，就把另一个栈也弹出即可

 */
import java.util.*;
class MinStack {
    private Deque<Integer> deque;
    private PriorityQueue<Integer> minHeap;

    public MinStack() {
        this.deque = new ArrayDeque<>();
        this.minHeap = new PriorityQueue<>();
    }

    public void push(int val) {
        minHeap.add(val);
        deque.push(val);
    }

    public void pop() {
        int temp = deque.pop();
        if(minHeap.peek()==temp){
            minHeap.poll();
        }else{
            List<Integer> list = new ArrayList<>();
            while(minHeap.peek()!=temp){
                int t = minHeap.poll();
                list.add(t);
            }
            minHeap.poll();
            int n = list.size();
            for(int i=n-1;i>=0;i--){
                minHeap.add(list.get(i));
            }
        }
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return minHeap.peek();
    }
}
