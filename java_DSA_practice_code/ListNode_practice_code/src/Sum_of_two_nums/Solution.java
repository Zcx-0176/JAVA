package Sum_of_two_nums;
/**
 * 本题主要是处理进位
 * 主要学会如何创建新链表
 * 即：current.next = new ListNode(rval);
 * 当前节点的next存放的是下一个节点的地址
 * 那么当前节点就指向了新创建的节点
 * 链表就连起来了
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int rval = l1.val+l2.val+carry;
            if(rval>=10){
                carry = 1;  //如果相加大于10.就需要进位
                rval -=10;
            }else if(rval<10){
                carry=0;
            }
            current.next = new ListNode(rval);  //创建新节点
            current = current.next;  //移动到新创建的节点，为了以后的创建
            l1=l1.next;   // l1移动到下一个节点
            l2=l2.next;   // l2移动到下一个节点
        }
        while(l1!=null){  // 处理l1未遍历完的节点
            int rval = l1.val+carry;
            if(rval>=10){
                carry = 1;
                rval -=10;
            }else{
                carry=0;
            }
            current.next = new ListNode(rval);
            current = current.next;
            l1=l1.next;
        }
        while(l2!=null){  // 处理l2未遍历完的节点
            int rval = l2.val+carry;
            if(rval>=10){
                carry = 1;
                rval -=10;
            }else{
                carry=0;
            }
            current.next = new ListNode(rval);
            current = current.next;
            l2=l2.next;
        }
        if(carry!=0){  //如果最后的最后又有了进位，就需要再创建一个节点
            current.next = new ListNode(carry);
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution s = new Solution();
        ListNode ans = s.addTwoNumbers(l1, l2);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans = ans.next;
        }
    }
}
