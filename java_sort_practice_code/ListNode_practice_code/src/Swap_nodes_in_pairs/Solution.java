package Swap_nodes_in_pairs;
/**
 * 非常简单的交换链表节点的操作
 * 注意
 *      1.注意一开始头结点的赋值，需要单独处理
 *      2.注意处理完一开始的两个数后，后面还接不接着循环了，如果后面没有数或者只有一个数就直接break
 *      3.如果后面还有很多数，跟头结点那个操作一样
 *      交换操作：先把current前面的节点连上current.next，再把current.next的next指向current，最后把current的next指向temp(之前保存过的原先的current.next.next)
 *      4.注意要把current前面的节点在上一次循环中保存起来，需要用到 prev，因为prev要与current.next进行连接
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current = head;
        ListNode prev = current;
        if(head == null){
            return null;
        }
        while(current != null && current.next != null){
            if(current == head){
                ListNode temp = current.next.next;
                head = current.next;
                current.next.next = current;
                current.next = temp;

                current = current.next;
            }
            if(current == null || current.next == null){
                break;
            }
            ListNode temp = current.next.next;
            prev.next = current.next;
            current.next.next = current;
            current.next = temp;

            prev = current;
            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution s = new Solution();
        ListNode ans = s.swapPairs(head);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
