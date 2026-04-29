package code206;
/*
    反转链表
    常规思维题
    首先需要一个指向以前的节点prev
    初始化为null
    需要一个指向头结点的current
    用于一开始遍历该链表

    循环条件是current!=null
    首先，先保存current后的节点，即ListNode temp = current.next;
    然后把当前节点的next节点指向以前的节点prev
    把prev赋值为当前节点
    当前节点赋值为temp

    如:
    一开始链表是 1 -> 2 -> 3 -> 4 -> 5
    第一次循环，current为1，prev为null，temp为2以后
    先保存temp ，然后因为要反转，所以1的next需要为null，也就是赋值为prev
    然后prev赋值为current，也就是当前节点1，
    然后current赋值为temp，这是为了遍历到下一个节点，即节点2

    进入到节点2，当前current为2，prev为1，temp为3以后
    先保存temp，然后因为要反转，所以2应该指向1，也就是指向prev，即赋值为prev
    然后prev赋值为当前节点current，也就是2
    然后current赋值为temp，继续遍历下一个节点

    以此类推，到链表最后，prev就被赋值为5，current被赋值为temp，此时的temp为null
    结束循环了
    返回的链表需要从prev开始遍历
    即return prev
 */
import java.util.*;
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
