package Swap_Knodes_in_pairs;
/**
 * 递归实现k个一组反转链表
 * 例：1->2->3->4->5->6->null
 * 核心思路
 *      1.先检查当前是否有k个节点，用count来记录
 *      2.如果count<k，说明当前链表不够k个节点，返回head
 *      3.如果count>=k，说明当前链表有k个节点，开始反转
 *      4.反转这个操作，就是可以看成反转整个链表，prev=null，只不过while循环结束条件为(i<k)，每次循环i++
 *      5.第一次反转完成后，head从1变成指向1，没有变化
 *      6.current从1指向4
 *      7.prev从null变成指向3，也就是反转后的头结点
 *      8.现在是  3->2->1 那么后续的节点怎么办 4->5->6->null
 *      9.后续的节点用head.next递归接收
 *      10，即head.next = reverseKGroup(current, k);
 *      11.等于把之前的重来一遍，传入的current就是后续节点的头结点head，等于把之前的全经历一遍
 *      12.如果还能反转，递归到最后返回的是prev，也就是反转后的头结点，由上一级递归head.next接收，这样上一级递归的尾节点就跟下一级递归的头结点连上了
 *      13.如果不能反转，函数内是返回head，函数内的head就是传入的current，也就是后续节点的头结点，依旧由上一级递归head.next接收，这样上一级递归的尾节点就跟下一级递归的头结点连上了
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<=1){
            return head;
        }

        ListNode current = head;
        int count = 0;
        while(current !=null && count<k){
            current = current.next;
            count++;
        }

        if(count<k){
            return head;
        }
        ListNode prev = null;
        current = head;
        int i =0;
        while(i<k){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            i++;
        }
        head.next = reverseKGroup(current, k);
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Solution s = new Solution();
        ListNode ans = s.reverseKGroup(head, 3);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
