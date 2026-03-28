package Implement_a_stack_using_queues;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 用两个队列，一个队列是queue1，一个队列是queue2
 * 数据来的时候，首先入队queue2，如果queue1为空，则直接把queue2的元素出队，入队到queue1中
 * 如果queue1有元素，则可以把queue1中的元素依次出队到queue2，然后再把queue2中的元素依次出队到queue1
 * 这样左手倒右手，就会事元素从 FIFO 变成在queue1 LIFO
 * 实在不行画个图算了，很好理解的
 */
public class MyStack {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    public MyStack() {

    }

    public void push(int x) {
        queue2.offer(x);
        if(queue1.isEmpty()){
            queue2.poll();
            queue1.offer(x);
        }else{
            while(!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            while(!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
