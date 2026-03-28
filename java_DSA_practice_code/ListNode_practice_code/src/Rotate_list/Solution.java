package Rotate_list;
/**
 * 链表旋转
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 思路
 *    获取链表长度，对k取余
 *    然后对应节点调整连接
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0){  //k==0时，返回head，链表为空返回head
            return head;
        }else if(head.next == null){  //只有一个节点，直接返回head
            return head;
        }
        ListNode current = head;
        int length=0;    //遍历整个链表，获取链表长度和尾节点
        while(current.next!=null){
            length++;
            current = current.next;
        }
        length++;

        k = k%length;    //获取k的余数，因为k可能比链表长度大

        if(k==0){   //k==0时，返回head，就是不需要移动，因为正好移动了链表长度个数，跟原先的没有区别
            return head;
        }
        /*
        如果1->2->3->4->5->null
        k = 3
        则最后应变为：3->4->5->1->2->null
        所以n为2
        找到2那个节点
        把2.next 变为null
        把5那个节点，也就是之前获取链表长度时遍历到的尾节点current，把它的的next变为head，即接到1那里
        然后把head赋值为temp1，也就是n个节点后的那个节点，即3
        返回head
         */
        int n = length-k;   //获取正向数第n个节点的next应该变为null
        ListNode temp = head;  //n个节点后的那些节点，需要找到并接到前面去
        int i = 0;
        while(i<n-1){
            i++;
            temp = temp.next;
        }
        ListNode temp1 = temp.next;
        temp.next = null;
        current.next = head;
        head = temp1;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        Solution s = new Solution();
        ListNode ans = s.rotateRight(head, 2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
