package code148;
/*
    链表排序
    将所给的链表在O(nlogn)的复杂度进行升序排序
    首先想到归并排序，即先递归分割成左右两份
    先把左侧一直递归分到只有一份
    再把右侧一直递归分到只有一份
    然后把两者进行排序
    首先声明一个名为h值为0的链表节点
    声明一个cu节点指向h.next，用于递归返回新排序的链表

    接下来就是循环进行比较左右两个链表的每个值的大小
    然后依次挂靠到h节点下形成新的链表
    这个逻辑简单，注意别忘了每次挂靠到h下，h也要往后移动
    当然如果左右长度不一致，就直接把剩下的链表挂靠到h.next
    然后递归返回cu,next

    这里有俩个地方需要格外注意
    1. 如何快速的找到当前链表的中间节点
    使用快慢指针
    慢指针初始化为head
    快指针初始化为head.next
    开始while循环，如果fast!=null&&fast.next!=null就一直进行下去
    每次slow往后移动一个节点
    fast往后移动2个节点
    这样当fast.next为null时，说明这个链表是偶数个节点，遍历到最后了
    当fast为null时，说明这个链表是奇数个节点，同样遍历到最后了
    不管如何，slow.next就是右半部分的链表头

    2. 当查出slow.next时，需要声明ListNode temp = slow.next
    再把slow.next赋值为null
    因为递归每次传入的都是只有头结点
    如果不写明赋值为null，这就根本还是一个链表，根本就是无限递归下去了

    当然，这步写完，就开始用左右指针赋值为head、和temp
    开始递归分割
    然后就可以处理左右链表的排序了

 */
import java.util.*;
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode h = new ListNode(0);
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode cu = h;

        while(left != null &&right !=null){
            if(left.val >= right.val){
                h.next = right;
                right = right.next;
            }else{
                h.next = left;
                left = left.next;
            }
            h = h.next;
        }
        if(left!=null){
            h.next = left;
        }else if(right !=null){
            h.next = right;
        }
        return cu.next;
    }
}
